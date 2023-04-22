package co.citory.citory

import android.app.Application
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import co.citory.citory.databinding.ActivityMain2Binding.inflate
import co.citory.citory.databinding.FragmentSettingsBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_settings.view.*


class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    private lateinit var button : Button
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(layoutInflater)
        val view = binding.root
        firebaseAuth= Firebase.auth
        val curruntUser=firebaseAuth.currentUser
        if (curruntUser!=null){
            binding.buttonnn.text="Profile"
        }

binding.buttonnn.setOnClickListener {

   val intent=Intent(this@SettingsFragment.context,SignIn::class.java)
   startActivity(intent)

}

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}