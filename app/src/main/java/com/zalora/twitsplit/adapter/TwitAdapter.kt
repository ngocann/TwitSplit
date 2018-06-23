package com.zalora.twitsplit.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zalora.twitsplit.databinding.RvItemTwitBinding
import com.zalora.twitsplit.model.Twit

class TwitAdapter (private var items : List<Twit>): RecyclerView.Adapter<TwitAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvItemTwitBinding.inflate(inflater,parent, false )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])
    fun setNewData(it: List<Twit>) {
        items = it
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding : RvItemTwitBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(twit: Twit) {
            binding.twit = twit
            binding.executePendingBindings()
        }
    }
}