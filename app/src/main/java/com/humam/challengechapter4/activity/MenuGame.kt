package com.humam.challengechapter4.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.humam.challengechapter4.R
import com.humam.challengechapter4.databinding.ActivityMenuGameBinding

class MenuGame : AppCompatActivity() {

    var binding: ActivityMenuGameBinding? = null
    var playerName: String? = null

    companion object{
        const val NAME = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuGameBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        getIntentData()
    }

    override fun onStart() {
        super.onStart()
        showSnackbar()
        goToGame()
    }

    private fun showSnackbar() {
        val snackbar = binding?.root?.let { Snackbar.make(it,"Selamat datang $playerName", Snackbar.LENGTH_INDEFINITE) }
        snackbar?.setAction("Tutup"){
            snackbar?.dismiss()
        }
        snackbar?.show()
    }

    private fun goToGame() {
        val intent = Intent(this, DisplayGame::class.java)

        binding?.tvPlayerVsPlayer?.text = "$playerName vs Pemain"
        binding?.ivPlayerVsPlayer?.setOnClickListener {
            intent.putExtra(DisplayGame.NAME,"$playerName")
            intent.putExtra(DisplayGame.MUSUH,"Player 2")
            startActivity(intent)
        }

        binding?.tvPlayerVsCom?.text = "$playerName vs Cpu"
        binding?.ivPlayerVsCom?.setOnClickListener {
            intent.putExtra(DisplayGame.NAME, playerName)
            intent.putExtra(DisplayGame.MUSUH, "Cpu")
            startActivity(intent)
        }
    }

    private fun getIntentData() {
        playerName = intent.getStringExtra(NAME).toString()
    }
}