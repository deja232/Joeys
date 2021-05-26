package model;

import android.os.Parcel;
import android.os.Parcelable;

public class kamar implements Parcelable {
    public int getJenis() {
        return jenis;
    }

    public void setJenis(int jenis) {
        this.jenis = jenis;
    }

    public kamar(int jenis) {
        this.jenis = jenis;
    }

    private  int jenis;

    protected kamar(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<kamar> CREATOR = new Creator<kamar>() {
        @Override
        public kamar createFromParcel(Parcel in) {
            return new kamar(in);
        }

        @Override
        public kamar[] newArray(int size) {
            return new kamar[size];
        }
    };
}
