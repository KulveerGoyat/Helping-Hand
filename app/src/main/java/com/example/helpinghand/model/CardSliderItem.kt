package com.example.helpinghand.model

import android.os.Parcel
import android.os.Parcelable

data class CardSliderItem(
    val imageResId: Int,
    val title: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageResId)
        parcel.writeString(title)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<CardSliderItem> {
        override fun createFromParcel(parcel: Parcel): CardSliderItem {
            return CardSliderItem(parcel)
        }

        override fun newArray(size: Int): Array<CardSliderItem?> {
            return arrayOfNulls(size)
        }
    }
}
