package com.emedinaa.myapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 8/23/18
 */
public class Product implements Parcelable {

    private int id;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
    }

    public Product() {
    }

    protected Product(Parcel in) {
        this.id = in.readInt();
    }

    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
