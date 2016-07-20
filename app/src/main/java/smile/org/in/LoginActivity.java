package smile.org.in;

import android.content.Intent;
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

public class LoginActivity extends AppCompatActivity {


    EditText editTextSmileID, editTextPassword;
    Button loginButton;
    String smileID_forauth;
    String password_forauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Firebase.setAndroidContext(this);
    }

    protected void onStart() {
        super.onStart();
        editTextSmileID = (EditText) findViewById(R.id.editsmileID);
        editTextPassword = (EditText) findViewById(R.id.editpassword);
        loginButton = (Button) findViewById(R.id.buttonlogin);
    }

    protected void onResume() {
        super.onResume();
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                smileID_forauth = editTextSmileID.getText().toString().trim();
                password_forauth = editTextPassword.getText().toString().trim();
                validation();
                Firebase ref_Users = new Firebase(Config.FIREBASENODE_USERS);


                ref_Users.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild(smileID_forauth)) {

                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                Users user_password = snapshot.getValue(Users.class);

                                if (password_forauth.equals(user_password.getPassword())) {
                                    Toast.makeText(getApplicationContext(), "USER AUTHENTICATED", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(LoginActivity.this, ProfileActivity.class);
                                    i.putExtra("SMILE ID", smileID_forauth);
                                    i.putExtra("FULL NAME", user_password.getFullname());
                                    startActivity(i);

                                } else {
                                    editTextPassword.setError("Incorrect Password");
                                }

                            }
                        } else {
                            editTextSmileID.setError("User not registered");
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
        if (smileID_forauth.isEmpty()) editTextSmileID.setError("Enter Smile ID");
        if (password_forauth.isEmpty()) editTextPassword.setError("Enter Password");

    }
}
