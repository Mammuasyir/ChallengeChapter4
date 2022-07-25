package com.humam.challengechapter4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import com.humam.challengechapter4.databinding.ActivityMainBinding
import com.humam.challengechapter4.databinding.ActivityMainBinding.inflate
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

    private lateinit var binding: ActivityMainBinding
    private var userPick: Int = 0
    private var comPick: Int = 0
    private var isGameFinished: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        setClickListener()
        resetGame()

    }

    private fun setClickListener() {

        binding.flBatuPemain1.setOnClickListener {
            if (!isGameFinished) {
                userPick = 0
                setPlayerPick(players = Players.PLAYER1, userPick)
                Log.d(TAG, "User Pick:$userPick ")
                checkWinner()
            }
        }
        binding.flKertasPemain1.setOnClickListener {
            if (!isGameFinished) {
                userPick = 1
                setPlayerPick(players = Players.PLAYER1, userPick)
                Log.d(TAG, "User Pick:$userPick ")
                checkWinner()
            }
        }
        binding.flGuntingPemain1.setOnClickListener {
            if (!isGameFinished) {
                userPick = 2
                setPlayerPick(players = Players.PLAYER1, userPick)
                Log.d(TAG, "User Pick: $userPick")
                checkWinner()
            }
        }
        binding.ivRefresh.setOnClickListener {
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
            flGunting = binding.flGuntingPemain1
            flKertas = binding.flKertasPemain1
            flBatu = binding.flBatuPemain1

        } else {
            flGunting = binding.flGuntingCom
            flKertas = binding.flKertasCom
            flBatu = binding.flBatuCom
        }
        when (pick) {
            PlayerPick.ROCK -> {
                flBatu.setBackgroundResource(R.drawable.bg_action_button)
                flKertas.setBackgroundResource(0)
                flGunting.setBackgroundResource(0)
            }
            PlayerPick.PAPER -> {
                flKertas.setBackgroundResource(R.drawable.bg_action_button)
                flBatu.setBackgroundResource(0)
                flGunting.setBackgroundResource(0)
            }
            PlayerPick.SCISSOR -> {
                flGunting.setBackgroundResource(R.drawable.bg_action_button)
                flKertas.setBackgroundResource(0)
                flBatu.setBackgroundResource(0)
            }
        }


    }


    private fun checkWinner() {
        val text = binding.tvResult
        val result: String
        comPick = Random.nextInt(0, 3)
        Log.d(TAG, "Computer Pick: $comPick")
        setPlayerPick(players = Players.COMPUTER, comPick)
        when (comPick) {
            0 -> {

                Toast.makeText(applicationContext, "Com picks Rock", Toast.LENGTH_SHORT).show()
            }
            1 -> {
                Toast.makeText(applicationContext, "Com picks Paper", Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(applicationContext, "Com picks Scissor", Toast.LENGTH_SHORT).show()

            }
        }
        when {
            (userPick + 1) % 3 == comPick -> {
                text.text = getString(R.string.result_com_win)
                isGameFinished = true


            }
            userPick == comPick -> {
                text.text = getString(R.string.result_draw)
                isGameFinished = true

            }
            else -> {
                text.text = getString(R.string.result_player_win)
                isGameFinished = true

            }
        }
    }

    private fun resetGame() {
        binding.tvResult.text = getString(R.string.vs)
        binding.ivKertasPemain1.setBackgroundResource(0)
        binding.ivBatuPemain1.setBackgroundResource(0)
        binding.ivGuntingPemain1.setBackgroundResource(0)
        binding.ivKertasCom.setBackgroundResource(0)
        binding.ivBatuCom.setBackgroundResource(0)
        binding.ivGuntingCom.setBackgroundResource(0)
        isGameFinished = false

    }

}