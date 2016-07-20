package smile.org.in;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class RegisterStudentActivity extends AppCompatActivity {
    private Firebase ref_students = null;
    Students student = null;
    private EditText eSmileID, eFullName, eFatherName, eAddress, eContactNumber, eAltContactNumber, eCollegeName, eAmtSent, eExpectedAmt, eRemarks,
            eSource, eYearofpassout, eXIImarks, eXmarks;
    private Button bAddStudent;
    String smileIDString, FullNameString, FatherNameString, AddressString, ContactNumberString, AltContactNumberString,
            CollegeString, AmtSentString, ExpectedAmtString, RemarksString, SourceString, YOPString, XIImarksString, XmarksString;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerstudent);
        Firebase.setAndroidContext(this);
    }

    protected void onStart() {
        super.onStart();
        eSmileID = (EditText) findViewById(R.id.editSmileID);
        eFullName = (EditText) findViewById(R.id.editFullName);
        eFatherName = (EditText) findViewById(R.id.editFatherName);
        eAddress = (EditText) findViewById(R.id.editAddress);
        eContactNumber = (EditText) findViewById(R.id.editContactNumber);
        eAltContactNumber = (EditText) findViewById(R.id.editAltContactNumber);
        eCollegeName = (EditText) findViewById(R.id.editCollegeName);
        eAmtSent = (EditText) findViewById(R.id.editAmtSent);
        eExpectedAmt = (EditText) findViewById(R.id.editExpectedAmtforcoursecompletion);
        eRemarks = (EditText) findViewById(R.id.editRemarks);
        eSource = (EditText) findViewById(R.id.editSource);
        eYearofpassout = (EditText) findViewById(R.id.edityearofpassout);
        eXIImarks = (EditText) findViewById(R.id.edit12Marks);
        eXmarks = (EditText) findViewById(R.id.edit10Marks);
        bAddStudent = (Button) findViewById(R.id.buttonAddStudent);
        onAddStudentButtonClick();
    }

    protected void onAddStudentButtonClick() {
        bAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref_students = new Firebase(Config.FIREBASENODE_STUDENTS);
                smileIDString = eSmileID.getText().toString().trim();
                FullNameString = eFullName.getText().toString().trim();
                FatherNameString = eFatherName.getText().toString().trim();
                AddressString = eAddress.getText().toString().trim();
                ContactNumberString = eContactNumber.getText().toString().trim();
                AltContactNumberString = eAltContactNumber.getText().toString().trim();

                CollegeString = eCollegeName.getText().toString().trim();
                AmtSentString = eAmtSent.getText().toString().trim();
                ExpectedAmtString = eExpectedAmt.getText().toString().trim();
                RemarksString = eRemarks.getText().toString().trim();
                SourceString = eSource.getText().toString().trim();
                YOPString = eYearofpassout.getText().toString().trim();
                XIImarksString = eXIImarks.getText().toString().trim();
                XmarksString = eXmarks.getText().toString().trim();

                student = new Students();
                student.setSmileid(smileIDString);
                student.setName(FullNameString);
                student.setFathername(FatherNameString);
                student.setAddress(AddressString);
                student.setContactNo(ContactNumberString);
                student.setAltContactNo(AltContactNumberString);
                student.setCollege(CollegeString);
                student.setAmtSent(AmtSentString);
                student.setExpectedAmt(ExpectedAmtString);
                student.setRemarks(RemarksString);
                student.setSource(SourceString);
                student.setYearofpassing(YOPString);
                student.setXIImarks(XIImarksString);
                student.setXmarks(XmarksString);
                ref_students.child(smileIDString).setValue(student);
            }
        });
    }
}
