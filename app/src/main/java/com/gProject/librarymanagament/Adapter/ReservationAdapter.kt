package com.gProject.librarymanagament.Adapter

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.gProject.librarymanagament.LibraryManagement.Reservations
import com.gProject.librarymanagament.Model.Reservation
import com.gProject.librarymanagament.R
import kotlinx.android.synthetic.main.reservation_infor.view.*

class ReservationAdapter(context: Context, val reservations: ArrayList<Reservation>) :
    RecyclerView.Adapter<ReservationAdapter.ViewHolder>() {


    val context = context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val lblBookID = itemView.txtBookId
        val lblReservationID = itemView.txtReservationID
        val labelName = itemView.txtName
        val labelSurname = itemView.txtSurname
        val labelPhone = itemView.txtPhoneNo
        val labelFinishTime = itemView.txtFinish
        val labelStartTime = itemView.txtStart
        val btnDelete = itemView.btnDeleteReservation
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ReservationAdapter.ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.reservation_infor, p0, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return reservations.size
    }

    override fun onBindViewHolder(p0: ReservationAdapter.ViewHolder, p1: Int) {
        val reservation: Reservation = reservations[p1]
        p0.lblReservationID.text = reservation.reservationID.toString()
        p0.labelName.text = reservation.Name.toString()
        p0.labelSurname.text = reservation.Surname.toString()
        p0.labelStartTime.text = reservation.StartTime.toString()
        p0.labelFinishTime.text = reservation.FinishTime.toString()
        p0.labelPhone.text = reservation.Phone.toString()
        p0.lblBookID.text = reservation.Book.toString()

        p0.btnDelete.setOnClickListener {
            val resID = reservation.reservationID
            var alertDialog = AlertDialog.Builder(context).setTitle("Warning")
                .setMessage("Are you sure you want to delete reservation with ID: $resID")
                .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                    if (Reservations.handler.deleteReservation(resID)) {
                        reservations.removeAt(p1)
                        notifyItemRemoved(p1)
                        notifyItemRangeChanged(p1, reservations.size)
                        Toast.makeText(context, "Reservation $resID Deleted", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        Toast.makeText(context, "Error While Deleting", Toast.LENGTH_SHORT).show()
                    }
                })
                .setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->  })
                .setIcon(R.drawable.ic_warning_black_24dp).show()
        }

    }
}
