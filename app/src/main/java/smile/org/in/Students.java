package smile.org.in;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Vivek on 18-Jul-16.
 */
public class Students {
    private String Smileid;
    @JsonProperty("Full Name")
    private String Name;
    private String Fathername;
    private String Address;


    public Students(){
        //Default constructor reqd for firebase database
    }
    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
    }

    public String getSmileid() {
        return Smileid;
    }

    public void setSmileid(String smileid) {
        Smileid = smileid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFathername() {
        return Fathername;
    }

    public void setFathername(String fathername) {
        Fathername = fathername;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAltContactNo() {
        return AltContactNo;
    }

    public void setAltContactNo(String altContactNo) {
        AltContactNo = altContactNo;
    }

    public String getCollege() {
        return College;
    }

    public void setCollege(String college) {
        College = college;
    }

    public String getAmtSent() {
        return AmtSent;
    }

    public void setAmtSent(String amtSent) {
        AmtSent = amtSent;
    }

    public String getExpectedAmt() {
        return ExpectedAmt;
    }

    public void setExpectedAmt(String expectedAmt) {
        ExpectedAmt = expectedAmt;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getYearofpassing() {
        return Yearofpassing;
    }

    public void setYearofpassing(String yearofpassing) {
        Yearofpassing = yearofpassing;
    }

    public String getXIImarks() {
        return XIImarks;
    }

    public void setXIImarks(String XIImarks) {
        this.XIImarks = XIImarks;
    }

    public String getXmarks() {
        return Xmarks;
    }

    public void setXmarks(String xmarks) {
        Xmarks = xmarks;
    }

    private String ContactNo;
    private String AltContactNo;
    private String College;
    private String AmtSent;
    private String ExpectedAmt;
    private String Remarks;
    private String Source;
    private String Yearofpassing;
    private String XIImarks;
    private String Xmarks;




}
