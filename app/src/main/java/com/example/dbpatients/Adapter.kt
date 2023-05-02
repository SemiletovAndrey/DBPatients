package com.example.dbpatients

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class Adapter(val patients: ArrayList<Patient>, val context: Context, val callback: Callback) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_patient, parent, false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = patients[position].name
        holder.lastName.text = patients[position].lastName
        holder.itemRoot.setOnClickListener { callback.onItemSelected(position) }
    }
    override fun getItemCount(): Int {
        return patients.size
    }
}
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name : TextView = itemView.findViewById(R.id.tvListName)
    val lastName: TextView = itemView.findViewById(R.id.tvListLastName)
    val itemRoot: ConstraintLayout = itemView.findViewById(R.id.clItemRoot)
}
interface Callback{
    fun onItemSelected(i: Int)
}