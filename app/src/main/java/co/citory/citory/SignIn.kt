package co.citory.citory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import co.citory.citory.databinding.ActivitySignInBinding

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignIn : AppCompatActivity() {
    private  lateinit var binding: ActivitySignInBinding
    private lateinit var firebaseAuth: FirebaseAuth
  //  private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        binding= ActivitySignInBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        firebaseAuth= Firebase.auth
        val curruntUser=firebaseAuth.currentUser

    //    sessionManager = SessionManager(this)






binding.textView10.setOnClickListener {
    val intent=Intent(this,ForgetPass::class.java)
    startActivity(intent)
    finish()
}
binding.textView11.setOnClickListener {
    val intent=Intent(this,SignUp::class.java)
    startActivity(intent)
}
        binding.textView12.setOnClickListener {
            val intent=Intent(this,SignUp::class.java)
            startActivity(intent)
        }
        binding.login.setOnClickListener {
            val email=binding.editTextTextPersonName2.text.toString()

            val pass=binding.passsignin.text.toString()
            if (email.equals("") ||pass.equals("")){

            }
            else{


                firebaseAuth.signInWithEmailAndPassword(email,pass).addOnSuccessListener {

                    val intent= Intent(this,MainActivity::class.java)
                    startActivity(intent)


                }.addOnFailureListener {
                    Toast.makeText(this,"hata var ",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    fun auth(){


    }
}
