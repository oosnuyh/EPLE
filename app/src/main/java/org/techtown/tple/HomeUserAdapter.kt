package org.techtown.tple

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeUserAdapter(private val context: Context, private val dataList: MutableList<DataHomeUser>
): RecyclerView.Adapter<HomeUserAdapter.ItemViewHolder>() {
    var mPosition = 0


    private fun setPosition(position:Int){
        mPosition = position
    }


    inner class ItemViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView){
        private val HomeUserimg = itemView.findViewById<ImageView>(R.id.HomeUserImage)
        val HomeUsername = itemView.findViewById<TextView>(R.id.HomeUserName)

        fun bind(dataHomeUser: DataHomeUser, context: Context){
            if(dataHomeUser.userImg !=null){
                val resourceld = context.resources.getIdentifier(dataHomeUser.userImg.toString(), "drawable",context.packageName)
                if(resourceld>0){
                    HomeUserimg.setImageResource(resourceld)
                }
                else{
                    HomeUserimg.setImageResource(R.mipmap.ic_launcher_round)
                }
            }
            else{
                HomeUserimg.setImageResource(R.mipmap.ic_launcher_round)
            }
            HomeUsername.text = dataHomeUser.userName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_homeuser,parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position], context)

    }
    override fun getItemCount(): Int {
        return dataList.size
    }
}