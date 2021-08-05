package com.example.jatpacknavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), View.OnClickListener {
    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        btn_send_money.setOnClickListener(this)
        btn_view_balance.setOnClickListener(this)
        btn_transactions.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            btn_send_money.id -> {
                val action = MainFragmentDirections.actionMainFragmentToChooseReceiverFragment()
                navController?.navigate(action)
            }
            btn_view_balance.id -> {
                val action = MainFragmentDirections.actionMainFragmentToViewBalanceFragment()
                navController?.navigate(action)
            }
            btn_transactions.id -> {
                val action = MainFragmentDirections.actionMainFragmentToTransactionFragment()
                navController?.navigate(action)
            }
        }
    }
}