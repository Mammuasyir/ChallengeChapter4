//package com.humam.challengechapter4.activity
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.FrameLayout
//import android.widget.Toast
//import com.bumptech.glide.Glide
//import com.humam.challengechapter4.PlayerPick
//import com.humam.challengechapter4.Players
//import com.humam.challengechapter4.R
//import com.humam.challengechapter4.databinding.ActivityMainBinding
//import com.humam.challengechapter4.databinding.ActivityPlayerVsComBinding
////import com.humam.challengechapter4.dialog.PemenangDialog
//import kotlin.random.Random
//import kotlin.system.exitProcess
//
//class PlayerVsComActivity : AppCompatActivity() {
//
//    var binding: ActivityPlayerVsComBinding? = null
//    private var userPick: Int = 0
//    private var comPick: Int = 0
//    private var isGameFinished: Boolean = false
//
//    val backGroundNormal = 0
//    val BATU_NUMBER = 0
//    val KERTAS_NUMBER = 1
//    val GUNTING_NUMBER = 2
//
//    companion object{
//        const val NAME="playerName"
//        const val ENEMY="typeEnemy"
//    }
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//
//        super.onCreate(savedInstanceState)
//        binding = ActivityPlayerVsComBinding.inflate(layoutInflater)
//        setContentView(binding?.root)
//
//        supportActionBar?.hide()
//        setPictureTitle()
//        setClickListener()
//        dismissIconClicked()
//        resetGame()
//
//    }
//
//    private fun setPictureTitle() {
//        binding?.apply {
//            Glide.with(this@PlayerVsComActivity)
//                .load("https://i.ibb.co/HC5ZPgD/splash-screen1.png")
//                .into(ivLogo)
//        }
//    }
//
//    private fun dismissIconClicked() {
//        binding?.ivClose?.setOnClickListener {
//            finish()
//            exitProcess(0)
//        }
//    }
//
//    private fun setClickListener() {
//
//        binding?.flBatuPemain1?.setOnClickListener {
//            if (!isGameFinished) {
//                userPick = BATU_NUMBER
//                setPlayerPick(players = Players.PLAYER1, userPick)
//                checkPemenang()
//                openDialogPemenang()
//            }
//        }
//        binding?.flKertasPemain1?.setOnClickListener {
//            if (!isGameFinished) {
//                userPick = KERTAS_NUMBER
//                setPlayerPick(players = Players.PLAYER1, userPick)
//                checkPemenang()
//                openDialogPemenang()
//            }
//        }
//        binding?.flGuntingPemain1?.setOnClickListener {
//            if (!isGameFinished) {
//                userPick = GUNTING_NUMBER
//                setPlayerPick(players = Players.PLAYER1, userPick)
//                checkPemenang()
//                openDialogPemenang()
//            }
//        }
//        binding?.ivRefresh?.setOnClickListener {
//            resetGame()
//        }
//
//    }
//
//    private fun openDialogPemenang() {
////        val dialog = PemenangDialog()
//    }
//
//    private fun setPlayerPick(
//        players: Players,
//        pickPlayer: Int
//    ) {
//        val pick = PlayerPick.fromInt(pickPlayer)
//        var flGunting: FrameLayout? = null
//        var flKertas: FrameLayout? = null
//        var flBatu: FrameLayout? = null
//
//        if (players == Players.PLAYER1) {
//            flGunting = binding?.flGuntingPemain1
//            flKertas = binding?.flKertasPemain1
//            flBatu = binding?.flBatuPemain1
//
//        } else {
//            flGunting = binding?.flGuntingCom
//            flKertas = binding?.flKertasCom
//            flBatu = binding?.flBatuCom
//        }
//        when (pick) {
//            PlayerPick.BATU -> {
//                flBatu?.setBackgroundResource(R.drawable.bg_action_button)
//                flKertas?.setBackgroundResource(backGroundNormal)
//                flGunting?.setBackgroundResource(backGroundNormal)
//            }
//            PlayerPick.KERTAS -> {
//                flKertas?.setBackgroundResource(R.drawable.bg_action_button)
//                flBatu?.setBackgroundResource(backGroundNormal)
//                flGunting?.setBackgroundResource(backGroundNormal)
//            }
//            PlayerPick.GUNTING -> {
//                flGunting?.setBackgroundResource(R.drawable.bg_action_button)
//                flKertas?.setBackgroundResource(backGroundNormal)
//                flBatu?.setBackgroundResource(backGroundNormal)
//            }
//        }
//
//    }
//
//
//    private fun checkPemenang() {
//        val text = binding?.tvResult
//        comPick = Random.nextInt(0, 3)
//        setPlayerPick(players = Players.COMPUTER, comPick)
//        when (comPick) {
//            0 -> {
//                Toast.makeText(applicationContext, "Com memilih Batu", Toast.LENGTH_SHORT).show()
//            }
//            1 -> {
//                Toast.makeText(applicationContext, "Com memilih Kertas", Toast.LENGTH_SHORT).show()
//            }
//            else -> {
//                Toast.makeText(applicationContext, "Com memilih Gunting", Toast.LENGTH_SHORT).show()
//            }
//        }
//        when {
//            (userPick + 1) % 3 == comPick -> {
//                text?.setTextColor(resources.getColor(R.color.teal_200))
//                text?.text = getString(R.string.result_com_win)
//                text?.textSize = 20.0f
//                isGameFinished = true
//
//            }
//            userPick == comPick -> {
//                text?.setTextColor(resources.getColor(R.color.blue))
//                text?.text = getString(R.string.result_draw)
//                text?.textSize = 20.0f
//                isGameFinished = true
//
//            }
//            else -> {
//                text?.setTextColor(resources.getColor(R.color.teal_200))
//                text?.text = getString(R.string.result_player_win)
//                text?.textSize = 20.0f
//                isGameFinished = true
//
//            }
//        }
//    }
//
//    open fun resetGame() {
//        binding?.tvResult?.setText(R.string.vs)
//        binding?.tvResult?.setTextColor(resources.getColor(R.color.red))
//        binding?.tvResult?.textSize = 40.0f
//        binding?.flKertasPemain1?.setBackgroundResource(backGroundNormal)
//        binding?.flBatuPemain1?.setBackgroundResource(backGroundNormal)
//        binding?.flGuntingPemain1?.setBackgroundResource(backGroundNormal)
//        binding?.flKertasCom?.setBackgroundResource(backGroundNormal)
//        binding?.flBatuCom?.setBackgroundResource(backGroundNormal)
//        binding?.flGuntingCom?.setBackgroundResource(backGroundNormal)
//        isGameFinished = false
//
//    }
//
//}