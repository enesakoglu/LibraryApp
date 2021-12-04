package com.gProject.librarymanagament.Fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.gProject.librarymanagament.R
import com.gProject.librarymanagament.UserManagement.Books_for_user
import com.gProject.librarymanagament.UserManagement.MakeReservation


class FragmentUserManagement : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.fragment_fragment_user_management, container, false)

        val button : Button = view.findViewById(R.id.buttonBooks)
        val buttonMakeReservation : Button = view.findViewById(R.id.buttonMakeReservation)

        buttonMakeReservation.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, MakeReservation::class.java)
            startActivity(intent)
        })

        button.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, Books_for_user::class.java)
            startActivity(intent)
        })

        return view
    }


}
