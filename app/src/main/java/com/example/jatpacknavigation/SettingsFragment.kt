package com.example.jatpacknavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_about_app.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            btn_about_app.id->{
                val action= SendAmountFragmentDirections.actionGlobalAboutFragment()
                findNavController().navigate(action)
            }
        }
    }
}