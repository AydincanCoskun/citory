package co.citory.citory.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import co.citory.citory.ApiUtils
import co.citory.citory.SignUpSuccess
import co.citory.citory.databinding.FragmentCreateTripBinding
import co.citory.citory.model.CreateTrips
import com.google.android.gms.cast.framework.SessionManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class CreateTripFragment : Fragment() {
    private var _binding: FragmentCreateTripBinding? = null
    private val binding get() = _binding!!
    private lateinit var sessionManager: SessionManager
    private lateinit var firebaseAuth: FirebaseAuth

    var years:Int=0
    var Months:Int=0
    var dayofMonths:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateTripBinding.inflate(layoutInflater)
        val view = binding.root
        firebaseAuth= Firebase.auth
        val curruntUser=firebaseAuth.currentUser
        val a= curruntUser?.email
        if (curruntUser!=null){
            binding.textView46.text="$a"
        }

return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


            binding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
                years=year
                Months=month
                dayofMonths=dayOfMonth


        }

        binding.checkedTextView2.setOnClickListener {

            if (binding.checkedTextView2.isChecked){
                binding.checkedTextView2.text="✓✓"
                binding.checkedTextView2.isChecked=false

            }else{
                binding.checkedTextView2.text="✓"
                binding.checkedTextView2.isChecked=true
            }

        }
        binding.imageView13.setOnClickListener {
           var aa=dayofMonths
            Toast.makeText(this@CreateTripFragment.context,"$aa",Toast.LENGTH_SHORT).show()
            val a=binding.checkedTextView2.isChecked
            if (a==true){
             //  Toast.makeText(this@CreateTripFragment.context,"True",Toast.LENGTH_SHORT).show()

            }else if (a==false){
               // Toast.makeText(this@CreateTripFragment.context,"False",Toast.LENGTH_SHORT).show()
            }
        }
        binding.button2.setOnClickListener {
var travel=ArrayList<Int>()
            travel.add(2)
            var dateformat  = SimpleDateFormat("06-05-2023 14:11:11")
            dateformat.timeZone = TimeZone.getTimeZone("UTC")
            var date=dateformat

            var kdi= ApiUtils.getUsersInterface()
            kdi.gettrip(3,travel,"2023-05-07T01:01:00Z","aaa",2,null).enqueue(object:
                Callback<CreateTrips> {
                override fun onResponse(call: Call<CreateTrips>, response: Response<CreateTrips>?) {
                    val intent= Intent(this@CreateTripFragment.context, SignUpSuccess::class.java)
                    startActivity(intent)
                }

                override fun onFailure(call: Call<CreateTrips>, t: Throwable) {
                    TODO("N")
                }
            })
        }
    }

}