package com.gProject.librarymanagament.LibraryManagement;

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.widget.LinearLayout
import com.gProject.librarymanagament.Adapter.ReservationAdapter
import com.gProject.librarymanagament.Model.DatabaseForLibrary
import com.gProject.librarymanagament.Model.Reservation
import com.gProject.librarymanagament.R
import kotlinx.android.synthetic.main.activity_reservations.*

class Reservations : AppCompatActivity(){

    companion object {
        lateinit var handler: DatabaseForLibrary
    }

    var reservationList = ArrayList<Reservation>()
    lateinit var adapter : RecyclerView.Adapter<*>
    lateinit var rv : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservations)

        handler = DatabaseForLibrary(this)
        viewReservations()

        txtSearchReservation.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val filteredReservations = ArrayList<Reservation>()
                if (!txtSearchReservation.text.isEmpty()){
                    for ( i in 0..reservationList.size-1){
                        if (reservationList.get(i).Book!!.toString().toLowerCase().contains(s.toString().toLowerCase())){
                            filteredReservations.add(reservationList[i])
                        }
                    }
                    adapter = ReservationAdapter(this@Reservations,filteredReservations)
                    rv.adapter = adapter
                }else{
                    adapter = ReservationAdapter(this@Reservations,reservationList)
                    rv.adapter = adapter
                }
            }
        })
    }

    fun viewReservations(){
        reservationList = handler.viewAllReservation(this)
        adapter = ReservationAdapter(this,reservationList)
        rv = findViewById(R.id.view)
        rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false) as RecyclerView.LayoutManager
        rv.adapter = adapter
    }

    override fun onResume() {
        viewReservations()
        super.onResume()
    }
}
