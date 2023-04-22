package co.citory.citory.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import co.citory.citory.R
import co.citory.citory.databinding.RecyclerAllTipsBinding

import co.citory.citory.databinding.SearchItemBinding

import co.citory.citory.model.SearchModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_all_tips.view.*

class SearchAdapter (private var postList: ArrayList<SearchModel>) : RecyclerView.Adapter<SearchAdapter.PostHolder>(){
    class PostHolder(val binding: SearchItemBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val binding=SearchItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostHolder(binding)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        Picasso.get().load(postList.get(position).image).into(holder.binding.imageView15)


        holder.binding.textView42.text=postList.get(position).city_name
        var boolen=postList.get(position).active
        if (boolen==false){
            holder.binding.textView42.setBackgroundColor(Color.parseColor("#707070"))
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }
    fun setFilteredList(postList:List<SearchModel>){
        this.postList = postList as ArrayList<SearchModel>
        notifyDataSetChanged()
    }
}