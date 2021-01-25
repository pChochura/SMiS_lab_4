package com.pointlessapps.smis_lab4

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setSupportActionBar(findViewById(R.id.toolbar))
		findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
			Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
					.setAction("Action", null).show()
		}
		PreferenceManager.setDefaultValues(this, R.xml.preferences, false)
		val sharedPref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
		val switchPref = sharedPref.getBoolean(SettingsActivity.KEY_PREF_EXAMPLE_SWITCH, false)
		Toast.makeText(this, switchPref.toString(), Toast.LENGTH_SHORT).show()
	}

	override fun onCreateOptionsMenu(menu: Menu): Boolean {
		menuInflater.inflate(R.menu.menu_main, menu)
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		if (item.itemId == R.id.action_settings) {
			startActivity(Intent(this, SettingsActivity::class.java))
			return true
		}
		return super.onOptionsItemSelected(item)
	}
}