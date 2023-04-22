package co.citory.citory.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 data class SearchModel(
    @SerializedName("id")
    @Expose
    var id:Int,
    @SerializedName("country")
    @Expose
    val country: SearchDetails,
    @SerializedName("city_name")
    @Expose
    var city_name:String,
    @SerializedName("location")
    @Expose
    var location:String,
    @SerializedName("image")
    @Expose
    var image:String,
    @SerializedName("active")
    @Expose
    var active:Boolean,


    )
{
}