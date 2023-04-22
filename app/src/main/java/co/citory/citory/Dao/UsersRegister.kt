package co.citory.citory.Dao
import co.citory.citory.CRUDcevap
import co.citory.citory.Cevap.SearchCevap
import co.citory.citory.model.Alltipsmodel
import co.citory.citory.model.Country
import co.citory.citory.model.CreateTrips
import  retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface UsersRegister {

   @POST(value ="users/register_with_email/")
   @FormUrlEncoded
   fun UserSave(@Field(value = "first_name")first_name:String,
                @Field(value = "last_name")last_name:String,
                @Field(value = "email")email:String,
                @Field(value = "password")password:String,
                @Field(value = "country")country:Int,
                @Field(value = "dob")dob:String):Call<CRUDcevap>

@GET("country")
fun getCountry():Call<Country>


    @POST("country")
    @FormUrlEncoded
    fun getCountryid(@Field("country_name")country_name:String):Call<Country>

    @GET("flaneurtip/flaneurtipbrowse")
    fun getAllTips(): Call<Alltipsmodel>

    @GET("city")
    fun getAllCity(): Call<SearchCevap>

    @POST("trip")
    @FormUrlEncoded
    fun gettrip(@Field(value = "city") city:Int,
                @Field(value = "travel_type") travel_type: ArrayList<Int>,
                @Field(value = "date") date: String,
                @Field(value = "explanation") explanation:String,
                @Field(value = "number_of_people") number_of_people:Int,
                @Field(value = "direct_flaneur") direct_flaneur: Int?
    ):Call<CreateTrips>

}