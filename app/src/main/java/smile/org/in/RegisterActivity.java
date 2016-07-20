package smile.org.in;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {

    Firebase ref = null;
    Users users = null;
    private EditText SmileID, FullName, ContactNumber, Password, ConfirmPassword;
    private Button buttonRegister;
     private String smileIDString, FullNameString, ContactNumberString, PasswordString, ConfirmPasswordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Firebase.setAndroidContext(this);

    }

    protected void onStart() {
        super.onStart();
        SmileID = (EditText) findViewById(R.id.editSmileID);
        FullName = (EditText) findViewById(R.id.editFullName);
        ContactNumber = (EditText) findViewById(R.id.editContactNumber);
        Password = (EditText) findViewById(R.id.editPassword);
        ConfirmPassword = (EditText) findViewById(R.id.editConfirmPassword);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        onRegisterButtonClick();
    }

    void onRegisterButtonClick() {
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref = new Firebase(Config.FIREBASE_ROOT);
                smileIDString = SmileID.getText().toString().trim();
                FullNameString = FullName.getText().toString().trim();
                ContactNumberString = ContactNumber.getText().toString().trim();
                PasswordString = Password.getText().toString().trim();
                ConfirmPasswordString = ConfirmPassword.getText().toString().trim();
                validation();

                users = new Users();
                users.setSmileID(smileIDString);
                users.setFullname(FullNameString);
                users.setContact_Number(ContactNumberString);
                users.setPassword(PasswordString);
                Firebase ref_smileID = ref.child("Users").child(smileIDString);
                ref_smileID.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            SmileID.setError("User already registered");

                        }
                        else {
                            if (!(PasswordString.equals(ConfirmPasswordString)) || PasswordString.isEmpty())
                                validation();
                            else {

                                ref.child("Users").child(smileIDString).setValue(users);
                                Toast.makeText(RegisterActivity.this, "Successfully registered. Login to continue", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(i);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }


                });


            }
        });

    }

    protected void validation() {
        if (smileIDString.isEmpty()) SmileID.setError("Enter Smile ID");
        if (FullNameString.isEmpty()) FullName.setError("Enter Full Name");
        if (ContactNumberString.isEmpty()) ContactNumber.setError("Enter Contact Number");
        if (PasswordString.isEmpty()) Password.setError("Enter Password");
        if (ConfirmPasswordString.isEmpty()) ConfirmPassword.setError("Confirm Password");
        if (!(PasswordString.equals(ConfirmPasswordString))) {
            ConfirmPassword.setError("Password does not match");
        }

    }
}
