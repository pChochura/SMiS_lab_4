package com.pointlessapps.smis_lab3

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
	private lateinit var mRecyclerView: RecyclerView
	private val mWordList = LinkedList<String>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		setSupportActionBar(findViewById(R.id.toolbar))
		findViewById<View>(R.id.fab).setOnClickListener {
			val wordListSize = mWordList.size
			mWordList.addLast("+ Word $wordListSize")
			mRecyclerView.adapter!!.notifyItemInserted(wordListSize)
			mRecyclerView.smoothScrollToPosition(wordListSize)
		}
		(0..19).forEach { mWordList.addLast("Word $it") }

		mRecyclerView = findViewById(R.id.recyclerview)
		mRecyclerView.adapter = WordListAdapter(mWordList)
		mRecyclerView.layoutManager = LinearLayoutManager(this)
	}

	override fun onCreateOptionsMenu(menu: Menu) = true.also {
		menuInflater.inflate(R.menu.menu_main, menu)
	}

	override fun onOptionsItemSelected(item: MenuItem) =
			if (item.itemId == R.id.action_settings) {
				true
			} else {
				super.onOptionsItemSelected(item)
			}
}