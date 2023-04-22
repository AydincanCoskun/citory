package co.citory.citory.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Country (
    @SerializedName("results")
    @Expose
    val results:List<CountryList>){
}