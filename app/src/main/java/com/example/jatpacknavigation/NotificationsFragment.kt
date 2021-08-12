package com.example.jatpacknavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_notifications.*

class NotificationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lv_notifications.adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, getNotifications())

    }

    private fun getNotifications(): List<String> {
        val notifications = mutableListOf<String>()

        for (i in 1..20) {
            notifications.add("Notification # $i")
        }
        return notifications
    }

}