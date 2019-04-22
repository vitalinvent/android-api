package ru.kassatka.comepay_sdk.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductItemsGson extends ProductItems implements Parcelable {

    protected ProductItemsGson(Parcel in) {
    }

    public static final Creator<ProductItemsGson> CREATOR = new Creator<ProductItemsGson>() {
        @Override
        public ProductItemsGson createFromParcel(Parcel in) {
            return new ProductItemsGson(in);
        }

        @Override
        public ProductItemsGson[] newArray(int size) {
            return new ProductItemsGson[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
