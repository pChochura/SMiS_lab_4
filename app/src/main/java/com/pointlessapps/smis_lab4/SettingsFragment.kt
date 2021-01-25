package com.pointlessapps.smis_lab4

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat;

class SettingsFragment : PreferenceFragmentCompat() {
	private var mParam1: String? = null
	private var mParam2: String? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		mParam1 = arguments?.getString(ARG_PARAM1)
		mParam2 = arguments?.getString(ARG_PARAM2)
	}

	override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
		setPreferencesFromResource(R.xml.preferences, rootKey)
	}

	companion object {
		private const val ARG_PARAM1 = "param1"
		private const val ARG_PARAM2 = "param2"

		fun newInstance(param1: String?, param2: String?): SettingsFragment {
			val fragment = SettingsFragment()
			val args = Bundle()
			args.putString(ARG_PARAM1, param1)
			args.putString(ARG_PARAM2, param2)
			fragment.arguments = args
			return fragment
		}
	}
}