package com.farahani.elmira.home

import android.os.Bundle
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }
}