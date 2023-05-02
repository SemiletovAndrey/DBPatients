package com.example.dbpatients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment(), Callback {
    val patients = arrayListOf<Patient>(
        Patient("Peter", "Doe"),
        Patient("Joe", "Doe"),
        Patient("Sam", "Doe"),
        Patient("Ban", "Doe"),
        Patient("Phill", "Doe"),
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
// Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvList = view.findViewById<RecyclerView>(R.id.rvList)
        rvList.adapter = Adapter(patients, requireContext(), this)
        rvList.layoutManager = LinearLayoutManager(activity)
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = ListFragment()
    }
    override fun onItemSelected(i: Int) {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.flDetails, DetailsFragment.newInstance(patients[i].name, patients[i].lastName))
            .addToBackStack(null)
            .commit()
    }
}