package co.citory.citory
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
data class CRUDcevap (@SerializedName("succes")
@Expose
var success:Int,
        @SerializedName("message")
        @Expose
        var message:String){

}