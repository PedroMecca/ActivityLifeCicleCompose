package br.edu.ifsp.scl.prdm.sc303500x.activitylifeciclecompose

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    var name : String = "",
    var age : Int = 0
): Parcelable

