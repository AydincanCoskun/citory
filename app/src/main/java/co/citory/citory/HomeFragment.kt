package co.citory.citory

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.citory.citory.Adapter.AllTipsAdapter
import co.citory.citory.Adapter.AllhomeTipsAdapter
import co.citory.citory.Fragment.CreateTripFragment
import co.citory.citory.databinding.FragmentHomeBinding
import co.citory.citory.databinding.FragmentSettingsBinding
import co.citory.citory.model.AllTipsList
import co.citory.citory.model.Alltipsmodel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    private var _binding:FragmentHomeBinding? = null
    private val binding get() = _binding!!
  private lateinit var allitemadapter: AllhomeTipsAdapter
  private lateinit  var postArrayList:ArrayList<AllTipsList>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(layoutInflater)
        val view = binding.root

        binding.button3.setOnClickListener {
            val fragment=CreateTripFragment()
            val transaction=fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment,fragment)?.commit()

        }
        binding.button.setOnClickListener {
            val intent= Intent(this@HomeFragment.context,All_tips::class.java)
            startActivity(intent)
        }
        binding.textView38.setOnClickListener {
           val fragment=SearchFragment()
            val transaction=fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment,fragment)?.commit()
        }

        postArrayList=ArrayList<AllTipsList>()
        alltips()
        binding.recyclerViewhome.layoutManager= LinearLayoutManager(this@HomeFragment.context,
            RecyclerView.HORIZONTAL,false)
        allitemadapter= AllhomeTipsAdapter(postArrayList)
        binding.recyclerViewhome.adapter=allitemadapter

        return view


    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)


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
                            var lastname="  ${k.flaneur_last_name}"
                            var tip=k.tip
                            var imgpic=k.flaneur_pic
                            var city="-${k.flaneur_city}"
                            var country=k.flaneur_country
if (imgpic!=null){
    val alltipss=AllTipsList(id,fid,tip,name,lastname,imgpic,city,country)
    postArrayList.add(alltipss)
}

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