package co.citory.citory.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AllTipsList(
@SerializedName("id")
@Expose
var id:Int,
@SerializedName("flaneur_id")
@Expose
var flaneur_id : Int,
@SerializedName("tip")
@Expose
var tip:String,
@SerializedName("flaneur_first_name")
@Expose
var flaneur_first_name:String,
@SerializedName("flaneur_last_name")
@Expose
var flaneur_last_name:String,
@SerializedName("flaneur_pic")
@Expose
var flaneur_pic:String,
@SerializedName("flaneur_city")
@Expose
var flaneur_city:String,
@SerializedName("flaneur_country")
@Expose
var flaneur_country:String,

)
{
}