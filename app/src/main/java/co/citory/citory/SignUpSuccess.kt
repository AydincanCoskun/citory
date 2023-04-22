package co.citory.citory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SignUpSuccess : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_success)
    }
    fun buttonup(view:View){
        val intent= Intent(this,SignIn::class.java)
        startActivity(intent)
        finish()
    }
}