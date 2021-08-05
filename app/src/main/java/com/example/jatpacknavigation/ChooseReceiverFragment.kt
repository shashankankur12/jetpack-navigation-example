package com.example.jatpacknavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_choose_receiver.*

class ChooseReceiverFragment : Fragment(), View.OnClickListener {
    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_receiver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btn_next.setOnClickListener(this)
        btn_cancel.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            btn_next.id -> navigateToSendAmount()

            btn_cancel.id -> {
                navController?.popBackStack()
            }
        }
    }

    private fun navigateToSendAmount() {
        val sendMoneyTo = et_receiver_name.text.trim().toString()
        if (sendMoneyTo.isNotEmpty()) {
            val action =
                ChooseReceiverFragmentDirections.actionChooseReceiverFragmentToSendAmountFragment(
                    sendMoneyTo
                )
            navController?.navigate(action)
        }
    }

}