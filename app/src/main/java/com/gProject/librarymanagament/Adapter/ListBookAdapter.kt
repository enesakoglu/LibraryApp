package com.gProject.librarymanagament.Adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import com.gProject.librarymanagament.Model.Book
import com.gProject.librarymanagament.R

class ListBookAdapter(internal var activity: Activity,
                      internal var lstBook: List<Book>,
                      internal var txtBookName: EditText,
                      internal var txtCategory: EditText,
                      internal var txtAuthor: EditText,
                      internal var txtLocation: EditText): BaseAdapter() {

    internal var inflater:LayoutInflater

    init {
        inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView:View
        rowView = inflater.inflate(R.layout.a,null)
        return rowView


    }

    override fun getItem(position: Int): Any {
        return lstBook[position]
    }

    override fun getItemId(position: Int): Long {
        return lstBook[position].id.toLong()
    }

    override fun getCount(): Int {
        return lstBook.size
    }



}