package tff.agventure;

import java.io.Serializable;

public class ContactInfo implements Serializable {
    private String mAddress;
    private String mPhoneNumber;
    private String mEmail;
    private String mHours;

    public ContactInfo(String hours, String address, String phoneNumber, String email) {
        mHours = hours;
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

    public String getHours() {
        return mHours;
    }

    public void setHours(String hours) {
        mHours = hours;
    }
}


