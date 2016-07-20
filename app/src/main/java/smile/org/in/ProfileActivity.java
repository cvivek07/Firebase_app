package smile.org.in;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView SmileID, FullName;
    Button bRegStudents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent i = getIntent();
       String smileIDstring= (String) i.getExtras().get("SMILE ID");
        String fullnamestring = (String) i.getExtras().get("FULL NAME");
        SmileID= (TextView) findViewById(R.id.textViewSmilieID);
        FullName = (TextView) findViewById(R.id.textViewFullName);
        SmileID.setText(getString(R.string.yoursmileID, smileIDstring));
        FullName.setText(getString(R.string.welcome, fullnamestring));
        bRegStudents = (Button) findViewById(R.id.buttonregstudents);
        bRegStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfileActivity.this, RegisterStudentActivity.class);
                startActivity(i);
            }
        });

    }
}
