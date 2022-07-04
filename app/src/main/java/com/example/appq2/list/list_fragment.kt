package com.example.appq2.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appq2.R
import com.example.appq2.WheaterViewModel


class list_fragment : Fragment() {

    private lateinit var mWheaterViewModel: WheaterViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list_fragment, container, false)



        //RecyclerView
        val adapter = ListAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycle_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        // WheaterViewModel
        mWheaterViewModel = ViewModelProvider(this)[WheaterViewModel::class.java]

        mWheaterViewModel.readAllData.observe(viewLifecycleOwner,Observer{weather ->
            adapter.setData(weather)

        })
        return view
    }


}