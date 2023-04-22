package co.citory.citory

import co.citory.citory.model.CountryList
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CountryCevap(
    @SerializedName("Country")
    @Expose
    var CountryList:List<CountryList>,
    @SerializedName("succes")
    @Expose
    var succes:Int
) {
}