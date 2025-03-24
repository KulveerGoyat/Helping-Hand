package com.example.helpinghand.model

import android.os.Parcel
import android.os.Parcelable

data class ProfessionItem(
    val imageResId: Int,
    val title: String,
    val description: String, // Add description
    val phone: String, // Add phone
    val email: String // Add email
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageResId)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(phone)
        parcel.writeString(email)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProfessionItem> {
        override fun createFromParcel(parcel: Parcel):ProfessionItem {
            return ProfessionItem(parcel)
        }

        override fun newArray(size: Int): Array<ProfessionItem?> {
            return arrayOfNulls(size)
        }
    }
}
