package com.pointlessapps.smis_lab3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pointlessapps.smis_lab3.WordListAdapter.WordViewHolder
import java.util.*

class WordListAdapter(private val wordList: LinkedList<String>) : RecyclerView.Adapter<WordViewHolder>() {

	inner class WordViewHolder(itemView: View, private val adapter: WordListAdapter) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
		val wordItemView: TextView = itemView.findViewById(R.id.word)

		override fun onClick(view: View) {
			wordList[layoutPosition] = "Clicked! ${wordList[layoutPosition]}"
			adapter.notifyDataSetChanged()
		}

		init { itemView.setOnClickListener(this) }
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
			WordViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.wordlist_item, parent, false), this)

	override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
		holder.wordItemView.text = wordList[position]
	}

	override fun getItemCount() = wordList.size
}