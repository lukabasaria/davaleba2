package com.example.davaleba2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ProfileFragment : Fragment() {

    private lateinit var firstNameTextView: TextView
    private lateinit var lastNameTextView: TextView
    private lateinit var gpaTextView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        firstNameTextView = view.findViewById(R.id.text_view_first_name)
        lastNameTextView = view.findViewById(R.id.text_view_last_name)
        gpaTextView = view.findViewById(R.id.text_view_gpa)

        val args = arguments
        if (args != null) {
            firstNameTextView.text = args.getString("firstName")
            lastNameTextView.text = args.getString("lastName")
            gpaTextView.text = args.getString("gpa")
        }

        return view
    }
}
