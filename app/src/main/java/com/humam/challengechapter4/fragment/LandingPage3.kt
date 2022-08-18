package com.humam.challengechapter4.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.humam.challengechapter4.activity.MenuGame
import com.humam.challengechapter4.activity.MenuGame.Companion.NAME
import com.humam.challengechapter4.databinding.FragmentLandingPage3Binding


class LandingPage3 : Fragment() {

    var binding: FragmentLandingPage3Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLandingPage3Binding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        putName()
    }

    private fun putName() {
            binding?.btnSetName?.setOnClickListener {
                if (binding?.etLandingPage3?.text.toString().isNotEmpty()){
                    navigateToMenuGame()
                } else {
                    Toast.makeText(context, "Please fill your name", Toast.LENGTH_SHORT).show()
                }

            }
        }

    private fun navigateToMenuGame() {
        val intent = Intent (this.context, MenuGame::class.java)
        intent.putExtra(MenuGame?.NAME,"${binding?.etLandingPage3?.text}")
        startActivity(intent)
    }
}