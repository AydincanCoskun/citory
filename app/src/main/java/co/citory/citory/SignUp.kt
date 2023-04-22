package co.citory.citory

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import co.citory.citory.databinding.ActivitySignUpBinding
import co.citory.citory.model.Country
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    private lateinit var auth:FirebaseAuth
    private  var countryModels:ArrayList<Country>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        var view=binding.root
        setContentView(view)
        auth=Firebase.auth

        binding.button4.setOnClickListener {
            Country()
        }



        binding.imageButton2.setOnClickListener {
            val intent=Intent(this,SignIn::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun signUpSave(country_id:Int){
var name=binding.namesngup.text.toString()
        var lastname=binding.namesngup2.text.toString()
        var email=binding.emailsngup.text.toString()
        var editTextDate=binding.editTextDate.text.toString()

        var passsngup=binding.passsngup.text.toString()
        var passagain=binding.passagain.text.toString()
        if (passsngup==passagain){
            SignUpPost(name,lastname,email,passsngup,country_id,editTextDate)
        }else{
            Toast.makeText(this@SignUp,"Password Alanları Eşleşmemektedir",Toast.LENGTH_LONG).show()
        }

    }

    fun SignUpPost(name:String,last:String,email:String,pass:String,country_id:Int,dob:String){
        var kdi=ApiUtils.getUsersInterface()
        kdi.UserSave("aydxz","cxzzxc","cn@gg.com","12345678Aa.",3,"1999-08-03").enqueue(object:Callback<CRUDcevap>{
            override fun onResponse(call: Call<CRUDcevap>, response: Response<CRUDcevap>?) {
                auth.createUserWithEmailAndPassword("cn@gg.com","12345678Aa.").addOnSuccessListener {
                    val intent= Intent(this@SignUp,SignUpSuccess::class.java)
                    startActivity(intent)
                }

            }

            override fun onFailure(call: Call<CRUDcevap>, t: Throwable) {
                TODO("N")
            }
        })





    }
    fun testd(){

    }


    fun Country(){
        val colors = ArrayList<String>()
       // colors.add("Country")
       val kdi=ApiUtils.getUsersInterface()
        kdi.getCountry().enqueue(object:Callback<Country>{
            override fun onResponse(call: Call<Country>, response: Response<Country>) {
           if (response!=null){
               var listCount:List<String>
               val liste= response.body()?.results
               if (liste != null) {
                   for(k in liste){
colors.add(k.country_name)
                       Log.e("id",(k.id).toString())
                       Log.e("id",(k.country_code).toString())
Log.e("id",(k.country_name).toString())


                   }
                   countryAdapter(colors)
               }
           }

            }

            override fun onFailure(call: Call<Country>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
}




    fun Countryİd(id:Int){
signUpSave(id)
    }
    fun countryAdapter(a:ArrayList<String>){


        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, a)
        binding.spinner.setAdapter(adapter)
        binding.spinner.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var b=a[position]

                val kdi=ApiUtils.getUsersInterface()
                kdi.getCountry().enqueue(object:Callback<Country>{
                    override fun onResponse(call: Call<Country>, response: Response<Country>) {
                        if (response!=null){
                            val liste= response.body()?.results
                            if (liste != null) {
                                for(k in liste){
                                    if (k.country_name=="$b"){
                                        Countryİd(k.id)
                                      //  binding.textView20.text="${k.id.toString()}"


                                    }
                                }
                            }
                        }

                    }

                    override fun onFailure(call: Call<Country>, t: Throwable) {
                        TODO("Not yet implemented")
                    }
                })






            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }
}