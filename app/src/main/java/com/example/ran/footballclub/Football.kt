package com.example.ran.footballclub

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Football(val nama : String, val image : Int, val keterangan : String) : Parcelable