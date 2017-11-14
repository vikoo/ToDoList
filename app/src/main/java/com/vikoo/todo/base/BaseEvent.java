package com.vikoo.todo.base;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by vikoo on 14/11/17.
 */

public class BaseEvent implements Parcelable {

    protected BaseEvent(Parcel in) {
    }

    public static final Creator<BaseEvent> CREATOR = new Creator<BaseEvent>() {
        @Override
        public BaseEvent createFromParcel(Parcel in) {
            return new BaseEvent(in);
        }

        @Override
        public BaseEvent[] newArray(int size) {
            return new BaseEvent[size];
        }
    };

    public BaseEvent() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
