package com.pointlessapps.smis_lab4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		supportFragmentManager.beginTransaction()
				.replace(android.R.id.content, SettingsFragment())
				.commit()
	}

	companion object {
		const val KEY_PREF_EXAMPLE_SWITCH = "example_switch"
	}
}