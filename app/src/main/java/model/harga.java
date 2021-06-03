package model;

import android.os.Parcel;
import android.os.Parcelable;

public class harga implements Parcelable {

    private int harga1 = 1000000,harga2 = 1500000,harga3 = 3000000,harga4 = 6000000,harga5 = 10000000;

    protected harga(Parcel in) {
        harga1 = in.readInt();
        harga2 = in.readInt();
        harga3 = in.readInt();
        harga4 = in.readInt();
        harga5 = in.readInt();
    }

    public static final Creator<harga> CREATOR = new Creator<harga>() {
        @Override
        public harga createFromParcel(Parcel in) {
            return new harga(in);
        }

        @Override
        public harga[] newArray(int size) {
            return new harga[size];
        }
    };

    public int getHarga1() {
        return harga1;
    }


    public int getHarga2() {
        return harga2;
    }



    public int getHarga3() {
        return harga3;
    }



    public int getHarga4() {
        return harga4;
    }



    public int getHarga5() {
        return harga5;
    }


    public harga(int harga1, int harga2, int harga3, int harga4, int harga5) {
        this.harga1 = harga1;
        this.harga2 = harga2;
        this.harga3 = harga3;
        this.harga4 = harga4;
        this.harga5 = harga5;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(harga1);
        dest.writeInt(harga2);
        dest.writeInt(harga3);
        dest.writeInt(harga4);
        dest.writeInt(harga5);
    }

    public harga() {
    }
}
