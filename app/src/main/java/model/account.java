package model;

import android.os.Parcel;
import android.os.Parcelable;

public class account implements Parcelable {

    private String emailuser,password, namauser;

    protected account(Parcel in) {
        emailuser = in.readString();
        password = in.readString();
        namauser = in.readString();
    }

    public static final Creator<account> CREATOR = new Creator<account>() {
        @Override
        public account createFromParcel(Parcel in) {
            return new account(in);
        }

        @Override
        public account[] newArray(int size) {
            return new account[size];
        }
    };

    public String getEmailuser() {
        return emailuser;
    }

    public void setEmail(String email) {
        this.emailuser = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNamauser() {
        return namauser;
    }

    public void setNamauser(String namauser) {
        this.namauser = namauser;
    }

    public account(String email, String password, String nama) {
        this.emailuser = email;
        this.password = password;
        this.namauser = nama;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(emailuser);
        dest.writeString(password);
        dest.writeString(namauser);
    }
}
