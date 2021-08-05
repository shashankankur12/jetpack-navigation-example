package com.example.jatpacknavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_confirm_dialog.*

class ConfirmDialogFragment : BottomSheetDialogFragment(), View.OnClickListener {
    val confirmDialogFragmentArgs:ConfirmDialogFragmentArgs by navArgs()
    var receiverName = ""
    var amount:Long =0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirm_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        receiverName= confirmDialogFragmentArgs.receivername
        amount= confirmDialogFragmentArgs.amount

        tv_message.text= "Do you want to send Rp $amount to $receiverName"
        btn_no.setOnClickListener(this)
        btn_yes.setOnClickListener(this)

    }

    override fun onClick(view: View?) {

        when(view?.id){
            btn_no.id ->{
                dismiss()
            }
            btn_yes.id ->{
                dismiss()
                Toast.makeText(requireContext(), "$amount has been sent to $receiverName", Toast.LENGTH_SHORT).show()
            }
        }
    }
}