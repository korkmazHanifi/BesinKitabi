package com.hanifikorkmaz.besinkitabi.model

import com.google.gson.annotations.SerializedName   //Anahtardan'dan(Key) farklı bir isim vermek istersek.

data class Besin(

    @SerializedName("isim")
    val besinIsim : String?,    // ?(nullable) bu anahtar JSON dosyasında her yerde tanımlanmamış olabilir.

    @SerializedName("kalori")
    val besinKalori: String?,

    @SerializedName("karbonhidrat")
    val besinKarbonhidrat: String?,

    @SerializedName("protein")
    val besinProtein: String?,

    @SerializedName("yag")
    val besinYag: String?,

    @SerializedName("gorsel")
    val besinGorsel: String?
)
