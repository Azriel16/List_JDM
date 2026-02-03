package com.dicoding.listjdm

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Jdm(
    val name: String?,
    val description: String?,
//    val kapasitamesin: String?,
//    val dimensi: String?,
//    val bahanbakar:String?,
    val photo: Int
) : Parcelable
    // {
//    constructor(parcel: Parcel) : this(
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readValue(Int::class.java.classLoader) as? Int
//    ) {
//    }
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(name)
//        parcel.writeValue(description)
//        parcel.writeString(photo)
//
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<Jdm> {
//        override fun createFromParcel(parcel: Parcel): Jdm {
//            return Jdm(parcel)
//        }
//
//        override fun newArray(size: Int): Array<Jdm?> {
//            return arrayOfNulls(size)
//        }
//    }
//}