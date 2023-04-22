package co.citory.citory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import co.citory.citory.Adapter.AllTipsAdapter
import co.citory.citory.databinding.ActivityAllTipsBinding
import co.citory.citory.model.AllTipsList
import co.citory.citory.model.Alltipsmodel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class All_tips : AppCompatActivity() {
    private lateinit var binding: ActivityAllTipsBinding
    private lateinit var postArrayList:ArrayList<AllTipsList>
    private lateinit var allitemadapter:AllTipsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
binding= ActivityAllTipsBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        postArrayList=ArrayList<AllTipsList>()
        alltips()
        binding.recrow.layoutManager=LinearLayoutManager(this)
allitemadapter= AllTipsAdapter(postArrayList)
        binding.recrow.adapter=allitemadapter



    }
    fun alltips(){
        val kdi=ApiUtils.getUsersInterface()
        kdi.getAllTips().enqueue(object: Callback<Alltipsmodel> {
            override fun onResponse(call: Call<Alltipsmodel>, response: Response<Alltipsmodel>) {
                if (response!=null){
                    val liste= response.body()?.results
                    if (liste != null) {
                        for(k in liste){
                            var id=k.id
                            var fid=k.flaneur_id
                            var name=k.flaneur_first_name
                            var lastname=k.flaneur_last_name
                            var tip=k.tip
                            var imgpic=k.flaneur_pic
                            var city=k.flaneur_city
                            var country=k.flaneur_country

                  val alltipss=AllTipsList(id,fid,tip,name,lastname,imgpic,city,country)
                            postArrayList.add(alltipss)
                        }
                        allitemadapter.notifyDataSetChanged()
                    }
                }

            }

            override fun onFailure(call: Call<Alltipsmodel>, t: Throwable) {

            }
        })
}
}