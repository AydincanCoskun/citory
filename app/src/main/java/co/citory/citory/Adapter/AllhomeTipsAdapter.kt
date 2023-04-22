package co.citory.citory.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.citory.citory.databinding.RecyclerAllTipsBinding

import co.citory.citory.databinding.RecyclerHomeAllTipsBinding
import co.citory.citory.model.AllTipsList
import com.squareup.picasso.Picasso

class AllhomeTipsAdapter (private val postList: ArrayList<AllTipsList>) : RecyclerView.Adapter<AllhomeTipsAdapter.PostHolder>(){
    class PostHolder(val binding: RecyclerHomeAllTipsBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val binding= RecyclerHomeAllTipsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AllhomeTipsAdapter.PostHolder(binding)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.binding.textView15name.text=postList.get(position).flaneur_first_name
        holder.binding.textView23last.text=postList.get(position).flaneur_last_name
        holder.binding.textView121tips.text=postList.get(position).tip
        holder.binding.textView25city.text=postList.get(position).flaneur_city
        holder.binding.textView24count.text=postList.get(position).flaneur_country
        Picasso.get().load(postList.get(position).flaneur_pic).into(holder.binding.imageView121imgpic)
    }

    override fun getItemCount(): Int {

        return postList.size
    }


}