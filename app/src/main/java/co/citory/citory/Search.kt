package co.citory.citory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.citory.citory.Adapter.SearchAdapter
import co.citory.citory.Cevap.SearchCevap
import co.citory.citory.databinding.ActivitySearchBinding
import co.citory.citory.model.SearchDetails
import co.citory.citory.model.SearchModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Search : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private lateinit  var postArrayList:ArrayList<SearchModel>
    private lateinit var allitemadapter:SearchAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding=ActivitySearchBinding.inflate(layoutInflater)
        val view=binding.root

        setContentView(view)
        postArrayList=ArrayList<SearchModel>()
        alltips()


    }
    fun alltips(){

        val kdi=ApiUtils.getUsersInterface()
 kdi.getAllCity().enqueue(object:Callback<SearchCevap>{
     override fun onResponse(call: Call<SearchCevap>, response: Response<SearchCevap>) {
         if (response!=null){
             val liste= response.body()?.results
             if (liste != null) {
                 for(k in liste){
var id=k.id
                     var countrya=ArrayList<SearchDetails>()
                     var countrycode=k.country.country_code
                     var countryname=k.country.country_name
                     var cityname=k.city_name
                     var location=k.location
                     var img=k.image
                     var active=k.active





                     val alltipss=SearchModel(id,SearchDetails(k.country.id,k.country.country_code,k.country.country_name),countryname,location,img,active)
                     postArrayList.add(alltipss)
                 }
                 allitemadapter.notifyDataSetChanged()
             }
         }
     }

     override fun onFailure(call: Call<SearchCevap>, t: Throwable) {
t.printStackTrace()
     }

 } )
}
}