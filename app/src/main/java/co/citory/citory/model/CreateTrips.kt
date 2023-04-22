package co.citory.citory.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CreateTrips(
    @SerializedName("city")
                      @Expose
                      var city:Int,
                      @SerializedName("travel_type")
                      @Expose
                      val travel_type: ArrayList<Int>,
                      @SerializedName("date")
                      @Expose
                      var date:Int,
                      @SerializedName("explanation")
                      @Expose
                      var explanation:String,
                      @SerializedName("number_of_people")
                      @Expose
                      var number_of_people:Int,
                      @SerializedName("direct_flaneur")
                      @Expose
                      var direct_flaneur:Int,


                      )
{
}