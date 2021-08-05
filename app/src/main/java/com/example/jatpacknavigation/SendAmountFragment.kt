package com.example.jatpacknavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_send_amount.*

class SendAmountFragment : Fragment(), View.OnClickListener {
    private val sendAmountFragmentArgs: SendAmountFragmentArgs by navArgs()
    var navController: NavController? = null
    private var receiverName = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_send_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        receiverName = sendAmountFragmentArgs.receiverName
        tv_receiver.text = "Send cash to $receiverName"
        btn_send.setOnClickListener(this)
        btn_cancel.setOnClickListener(this)
        btn_done.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            btn_send.id -> {
                openDialog()
            }
            btn_cancel.id -> {
                navController?.popBackStack()
            }
            btn_done.id -> {
                val action=SendAmountFragmentDirections.actionSendAmountFragmentToMainFragment2()
                navController?.navigate(action)
            }
        }
    }

    private fun openDialog() {
        val amount = et_amount.text.trim().toString().toLong()

        if (amount > 0) {
            val action =
                SendAmountFragmentDirections.actionSendAmountFragmentToConfirmDialogFragment(receiverName, amount)
            navController?.navigate(action)
        }
    }
}