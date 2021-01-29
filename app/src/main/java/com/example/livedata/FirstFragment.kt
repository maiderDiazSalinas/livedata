package com.example.livedata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

class FirstFragment : Fragment() {

    val miViewModel:VM by viewModels()
    var numero:Int=1

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        view.findViewById<Button>(R.id.button_second).setOnClickListener({
            view.findViewById<TextView>(R.id.textview_first).text = miViewModel.datoObservable.value
            miViewModel.datoObservable.value="cambio numero: $numero"
            numero++
        })

        miViewModel.datoObservable.observe(viewLifecycleOwner, Observer {cadena->
            view.findViewById<TextView>(R.id.textview_first).text=cadena
        })
    }
}