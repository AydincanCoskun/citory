package co.citory.citory.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.citory.citory.databinding.RecyclerAllTipsBinding
import co.citory.citory.model.AllTipsList
import com.squareup.picasso.Picasso

class AllTipsAdapter(private val postList: ArrayList<AllTipsList>) :RecyclerView.Adapter<AllTipsAdapter.PostHolder>(){
    class PostHolder(val binding: RecyclerAllTipsBinding) :RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
     val binding=RecyclerAllTipsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    return PostHolder(binding)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
     holder.binding.textView23name.text=postList.get(position).flaneur_first_name
        holder.binding.textView23name2.text=postList.get(position).flaneur_last_name
        holder.binding.textView26tip.text=postList.get(position).tip
        holder.binding.textView24city.text=postList.get(position).flaneur_city
   Picasso.get().load(postList.get(position).flaneur_pic).into(holder.binding.imageView10pic)
    }


    override fun getItemCount(): Int {
      return postList.size

    }
}