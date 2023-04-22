package co.citory.citory.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CountryList (
    @SerializedName("id")
    @Expose
    var id:Int,
            @SerializedName("country_code")
           @Expose
           var country_code : String,
                    @SerializedName("country_name")
                    @Expose
                    var country_name:String)

{

}