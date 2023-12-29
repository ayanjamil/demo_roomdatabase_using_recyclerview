package com.example.demo_roomdb_and_recyclerview

import android.os.Parcel
import android.os.Parcelable

data class model(var eventImage:Int, var id:String):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(eventImage)
        parcel.writeString(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<model> {
        override fun createFromParcel(parcel: Parcel): model {
            return model(parcel)
        }

        override fun newArray(size: Int): Array<model?> {
            return arrayOfNulls(size)
        }
    }
}