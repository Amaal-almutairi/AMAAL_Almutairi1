package com.example.amaal_almutairi1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.amaal_almutairi1.myadapter.ItemViewHolder
import kotlinx.android.synthetic.main.item_score.view.*

class myadapter (private val equations:ArrayList<String>):RecyclerView.Adapter<ItemViewHolder> (){
    class ItemViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
     //   private var SCtv1 = itemView.findViewById<TextView>(R.id.tvsc)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_score,parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val points = equations[position]

  holder.itemView.apply {
      tvsc.text=points
  }
    }


    override fun getItemCount()=equations.size
    }


