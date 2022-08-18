package com.humam.challengechapter4.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.humam.challengechapter4.fragment.LandingPage1
import com.humam.challengechapter4.fragment.LandingPage2
import com.humam.challengechapter4.fragment.LandingPage3

class LandingPageAdapter(fragment: FragmentActivity): FragmentStateAdapter(fragment) {

    val NUM_PAGES = 3
    override fun getItemCount(): Int {
        return NUM_PAGES
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                LandingPage1()
            }
            1 -> {
                LandingPage2()
            }
            else -> {
                LandingPage3()
            }
        }
    }
}