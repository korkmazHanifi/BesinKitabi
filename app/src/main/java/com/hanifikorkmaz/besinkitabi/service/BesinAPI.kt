package com.hanifikorkmaz.besinkitabi.service

import com.hanifikorkmaz.besinkitabi.model.Besin
import retrofit2.http.GET

interface BesinAPI {

    //https://raw.githubusercontent.com/atilsamancioglu/BTK20-JSONVeriSeti/refs/heads/master/besinler.json(İstek Atacağımız API)

    //BASEURL -> https://raw.githubusercontent.com/
    //ENDPOINT -> atilsamancioglu/BTK20-JSONVeriSeti/refs/heads/master/besinler.json

    @GET("atilsamancioglu/BTK20-JSONVeriSeti/refs/heads/master/besinler.json")
    suspend fun getBesin(): List<Besin>
}