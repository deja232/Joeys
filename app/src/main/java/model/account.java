package model;

import android.os.Parcel;
import android.os.Parcelable;

public class account implements Parcelable {

    private String email,password,nama;

    protected account(Parcel in) {
        email = in.readString();
        password = in.readString();
        nama = in.readString();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public account(String email, String password, String nama) {
        this.email = email;
        this.password = password;
        this.nama = nama;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(nama);
    }
}
