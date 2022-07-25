package com.humam.challengechapter4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import android.widget.Toast
import com.humam.challengechapter4.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null
    private var userPick: Int = 0
    private var comPick: Int = 0
    private var isGameFinished: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        supportActionBar?.hide()
        setClickListener()
        resetGame()

    }

    private fun setClickListener() {

        binding?.flBatuPemain1?.setOnClickListener {
            if (!isGameFinished) {
                userPick = 0
                setPlayerPick(players = Players.PLAYER1, userPick)
                checkPemenang()
            }
        }
        binding?.flKertasPemain1?.setOnClickListener {
            if (!isGameFinished) {
                userPick = 1
                setPlayerPick(players = Players.PLAYER1, userPick)
                checkPemenang()
            }
        }
        binding?.flGuntingPemain1?.setOnClickListener {
            if (!isGameFinished) {
                userPick = 2
                setPlayerPick(players = Players.PLAYER1, userPick)
                checkPemenang()
            }
        }
        binding?.ivRefresh?.setOnClickListener {
            resetGame()
        }

    }

    private fun setPlayerPick(
        players: Players,
        pickPlayer: Int
    ) {
        val pick = PlayerPick.fromInt(pickPlayer)
        var flGunting: FrameLayout? = null
        var flKertas: FrameLayout? = null
        var flBatu: FrameLayout? = null

        if (players == Players.PLAYER1) {
            flGunting = binding?.flGuntingPemain1
            flKertas = binding?.flKertasPemain1
            flBatu = binding?.flBatuPemain1

        } else {
            flGunting = binding?.flGuntingCom
            flKertas = binding?.flKertasCom
            flBatu = binding?.flBatuCom
        }
        when (pick) {
            PlayerPick.BATU -> {
                flBatu?.setBackgroundResource(R.drawable.bg_action_button)
                flKertas?.setBackgroundResource(0)
                flGunting?.setBackgroundResource(0)
            }
            PlayerPick.KERTAS -> {
                flKertas?.setBackgroundResource(R.drawable.bg_action_button)
                flBatu?.setBackgroundResource(0)
                flGunting?.setBackgroundResource(0)
            }
            PlayerPick.GUNTING -> {
                flGunting?.setBackgroundResource(R.drawable.bg_action_button)
                flKertas?.setBackgroundResource(0)
                flBatu?.setBackgroundResource(0)
            }
        }

    }


    private fun checkPemenang() {
        val text = binding?.tvResult
        comPick = Random.nextInt(0, 3)
        setPlayerPick(players = Players.COMPUTER, comPick)
        when (comPick) {
            0 -> {
                Toast.makeText(applicationContext, "Com memilih Batu", Toast.LENGTH_SHORT).show()
            }
            1 -> {
                Toast.makeText(applicationContext, "Com memilih Kertas", Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(applicationContext, "Com memilih Gunting", Toast.LENGTH_SHORT).show()
            }
        }
        when {
            (userPick + 1) % 3 == comPick -> {
                text?.setTextColor(resources.getColor(R.color.teal_200))
                text?.text = getString(R.string.result_com_win)
                text?.textSize = 20.0f
                isGameFinished = true

            }
            userPick == comPick -> {
                text?.setTextColor(resources.getColor(R.color.blue))
                text?.text = getString(R.string.result_draw)
                text?.textSize = 20.0f
                isGameFinished = true

            }
            else -> {
                text?.setTextColor(resources.getColor(R.color.teal_200))
                text?.text = getString(R.string.result_player_win)
                text?.textSize = 20.0f
                isGameFinished = true

            }
        }
    }

    private fun resetGame() {
        binding?.tvResult?.setText(R.string.vs)
        binding?.tvResult?.setTextColor(resources.getColor(R.color.red))
        binding?.tvResult?.textSize = 40.0f
        binding?.flKertasPemain1?.setBackgroundResource(0)
        binding?.flBatuPemain1?.setBackgroundResource(0)
        binding?.flGuntingPemain1?.setBackgroundResource(0)
        binding?.flKertasCom?.setBackgroundResource(0)
        binding?.flBatuCom?.setBackgroundResource(0)
        binding?.flGuntingCom?.setBackgroundResource(0)
        isGameFinished = false

    }

}