package smile.org.in;

/**
 * Created by Vivek on 13-Jul-16.
 */
public class Users {

    private String smileID;
    private String Fullname;
    private String Contact_Number;
    private String Password;
    public Users(){

    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getContact_Number() {
        return Contact_Number;
    }

    public void setContact_Number(String contact_Number) {
        Contact_Number = contact_Number;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getSmileID() {
        return smileID;
    }

    public void setSmileID(String smileID) {
        this.smileID = smileID;
    }




}
