package co.citory.citory.Cevap


import co.citory.citory.model.SearchModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchCevap(

    @SerializedName("results")
    @Expose
    val results:List<SearchModel>)
{
}
