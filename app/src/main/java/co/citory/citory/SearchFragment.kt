package co.citory.citory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.citory.citory.Adapter.SearchAdapter
import co.citory.citory.Cevap.SearchCevap
import co.citory.citory.RecMargin.ContactMargin
import co.citory.citory.databinding.FragmentSearchBinding
import co.citory.citory.databinding.FragmentSettingsBinding
import co.citory.citory.model.SearchDetails
import co.citory.citory.model.SearchModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList


class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    private lateinit  var postArrayList:ArrayList<SearchModel>
    private lateinit var allitemadapter: SearchAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(layoutInflater)
        val view = binding.root
        postArrayList=ArrayList<SearchModel>()
        alltips()
        binding.recyclerViewv.layoutManager= LinearLayoutManager(this@SearchFragment.context)
        allitemadapter= SearchAdapter(postArrayList)
        binding.recyclerViewv.adapter=allitemadapter
        var dividerItem=DividerItemDecoration(this@SearchFragment.context,RecyclerView.VERTICAL)
        ResourcesCompat.getDrawable(resources,R.drawable.divider_rec,null)?.let {
            dividerItem.setDrawable(it)
        }
        binding.recyclerViewv.addItemDecoration(dividerItem)
        val itemMargin=ContactMargin()
        binding.recyclerViewv.addItemDecoration(itemMargin)
        binding.searchView2.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return false
            }
        })



        return view
    }
    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<SearchModel>()
            for (i in  postArrayList) {
                if (i.city_name.lowercase(Locale.ROOT).contains(query)) {

                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {

                Toast.makeText(this@SearchFragment.context, "No Data found", Toast.LENGTH_SHORT).show()

            } else {
                allitemadapter.setFilteredList(filteredList)
            }
        }
    }
    fun alltips(){

        val kdi=ApiUtils.getUsersInterface()
        kdi.getAllCity().enqueue(object: Callback<SearchCevap> {
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





                            val alltipss=SearchModel(id,SearchDetails(k.country.id,k.country.country_code,k.country.country_name),cityname,location,img,active)
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}