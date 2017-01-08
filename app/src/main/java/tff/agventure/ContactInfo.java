package tff.agventure;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class ContactInfo implements Serializable {
    private String mAddress;
    private String mPhoneNumber;
    private String mEmail;
    private List<TimeOfOperation> mTimesofOperation;

    public ContactInfo(List<TimeOfOperation> timesofOperation, String address, String phoneNumber, String email) {
        mTimesofOperation = timesofOperation;
        mAddress = address;
        mPhoneNumber = phoneNumber;
        mEmail = email;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public List<TimeOfOperation> getTimesofOperation() {
        return mTimesofOperation;
    }

    public void setTimesofOperation(List<TimeOfOperation> timesofOperation) {
        mTimesofOperation = timesofOperation;
    }
}


