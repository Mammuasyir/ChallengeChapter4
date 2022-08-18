package com.humam.challengechapter4.activity

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.humam.challengechapter4.R
import com.humam.challengechapter4.databinding.ActivityDisplayGameBinding
import com.humam.challengechapter4.databinding.FragmentPemenangDialogBinding
import kotlin.system.exitProcess

class DisplayGame : AppCompatActivity() {
    var binding: ActivityDisplayGameBinding? = null
    var dialogBinding: FragmentPemenangDialogBinding? = null
    var playerName: String? = null
    var typeMusuh:String? = null
    var playerChoice:String? = null
    var enemyChoice:String? = null
    var pemenang:String? = null
    private val choice = arrayListOf("GUNTING","BATU","KERTAS")

    companion object{
        const val NAME="playerName"
        const val MUSUH="typeMusuh"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayGameBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        supportActionBar?.hide()
        setPictureTitle()
        getIntentData()

        closeIconClicked()
        refreshIconClicked()

        //openDialogPemenang()

        clearChoice()
        setPlayerChoice()

    }

    private fun clearChoice() {
        binding?.ivBatuPemain1?.rotation=360F
        binding?.ivBatuPemain1?.setBackgroundColor(Color.TRANSPARENT)

        binding?.ivKertasPemain1?.rotation=360F
        binding?.ivKertasPemain1?.setBackgroundColor(Color.TRANSPARENT)

        binding?.ivGuntingPemain1?.rotation=360F
        binding?.ivGuntingPemain1?.setBackgroundColor(Color.TRANSPARENT)

        binding?.ivBatuMusuh?.rotation=360F
        binding?.ivBatuMusuh?.setBackgroundColor(Color.TRANSPARENT)

        binding?.ivKertasMusuh?.rotation=360F
        binding?.ivKertasMusuh?.setBackgroundColor(Color.TRANSPARENT)

        binding?.ivGuntingMusuh?.rotation=360F
        binding?.ivGuntingMusuh?.setBackgroundColor(Color.TRANSPARENT)

    }

    private fun setPlayerChoice() {
        binding?.ivBatuPemain1?.setOnClickListener {
            playerChoice="BATU"
            if (typeMusuh=="Cpu"){
                setPlayerChoiced()
            }
            setMusuhChoice()

        }
        binding?.ivGuntingPemain1?.setOnClickListener {
            playerChoice="GUNTING"
            if (typeMusuh=="Cpu") {
                setPlayerChoiced()
            }
            setMusuhChoice()

        }
        binding?.ivKertasPemain1?.setOnClickListener {
            playerChoice="KERTAS"
            if (typeMusuh=="Cpu") {
                setPlayerChoiced()
            }
            setMusuhChoice()
        }
    }

    private fun setMusuhChoice() {
        if (typeMusuh=="Cpu"){
            enemyChoice=choice.random()
            when (enemyChoice){
                "GUNTING"->
                {
                    setMusuhGuntingChoiced()
                }
                "BATU"->
                {
                    setMusuhBatuChoiced()
                }
                "KERTAS"->
                {
                    setMusuhKertasChoiced()
                }
            }
            cekPemenang()
            openDialogPemenang()

        }else{
            val snackbar2= binding?.root?.let {
                Snackbar.make(
                    it, "$playerName telah memilih. " +
                            "\n Silahkan $typeMusuh untuk memilih",
                    Snackbar.LENGTH_SHORT)
            }
            snackbar2?.setAction("Close"){
                snackbar2?.dismiss()
            }
            snackbar2?.show()
            binding?.ivBatuMusuh?.setOnClickListener {
                enemyChoice="BATU"
                setMusuhBatuChoiced()
                setPlayerChoiced()
                cekPemenang()
                openDialogPemenang()
            }
            binding?.ivGuntingMusuh?.setOnClickListener {
                enemyChoice="GUNTING"
                setMusuhGuntingChoiced()
                setPlayerChoiced()
                cekPemenang()
                openDialogPemenang()
            }
            binding?.ivKertasMusuh?.setOnClickListener {
                enemyChoice="KERTAS"
                setMusuhKertasChoiced()
                setPlayerChoiced()
                cekPemenang()
                openDialogPemenang()
            }
        }
    }

    private fun cekPemenang() {
        when(playerChoice){
            "GUNTING"-> {
                when (enemyChoice) {
                    "GUNTING" -> pemenang = "SERI"
                    "KERTAS" -> pemenang = playerName
                    "BATU" -> pemenang = typeMusuh
                }
            }
            "KERTAS" ->{
                when(enemyChoice){
                    "GUNTING"-> pemenang=typeMusuh
                    "KERTAS" -> pemenang="SERI"
                    "BATU" -> pemenang = playerName
                }
            }
            "BATU"->{
                when(enemyChoice){
                    "GUNTING"-> pemenang = playerName
                    "KERTAS" -> pemenang = typeMusuh
                    "BATU" -> pemenang = "SERI"
                }
            }
        }
    }

    //method untuk merotasi gambar yang dipilih (player)
    private fun setPlayerChoiced() {
        when(playerChoice){
            "GUNTING"->setPlayerGuntingChoiced()
            "BATU"->setPlayerBatuChoiced()
            "KERTAS"->setPlayerKertasChoiced()
        }
    }

    private fun setPlayerKertasChoiced() {
        binding?.ivKertasPemain1?.rotation=30F
        binding?.ivKertasPemain1?.setBackgroundColor(Color.BLUE)
    }

    private fun setPlayerGuntingChoiced() {
        binding?.ivGuntingPemain1?.rotation=30F
        binding?.ivGuntingPemain1?.setBackgroundColor(Color.BLUE)
    }

    private fun setPlayerBatuChoiced() {
        binding?.ivBatuPemain1?.rotation=30F
        binding?.ivBatuPemain1?.setBackgroundColor(Color.BLUE)
    }

    //method untuk merotasi gambar yang dipilih (enemy)
    private fun setMusuhKertasChoiced() {
        binding?.ivKertasMusuh?.rotation=30F
        binding?.ivKertasMusuh?.setBackgroundColor(Color.BLUE)
        showPlayerChoice()
    }

    private fun setMusuhGuntingChoiced() {
        binding?.ivGuntingMusuh?.rotation=30F
        binding?.ivGuntingMusuh?.setBackgroundColor(Color.BLUE)
        showPlayerChoice()
    }

    private fun setMusuhBatuChoiced() {
        binding?.ivBatuMusuh?.rotation=30F
        binding?.ivBatuMusuh?.setBackgroundColor(Color.BLUE)
        showPlayerChoice()
    }

    private fun showPlayerChoice() {
        Toast.makeText(this, "$playerName memilih $playerChoice\n " +
                "$typeMusuh memilih $enemyChoice", Toast.LENGTH_SHORT).show()
    }

    private fun setPictureTitle() {
        binding?.apply {
            Glide.with(this@DisplayGame)
                .load("https://i.ibb.co/HC5ZPgD/splash-screen1.png")
                .into(ivLogo)
        }
        Log.d("setPictureTitle","setPictureTitle berhasil")
    }

    private fun getIntentData() {
        playerName = intent.getStringExtra(NAME).toString()
        typeMusuh = intent.getStringExtra(MUSUH).toString()
        binding?.tvPlayer1?.text= playerName
        binding?.tvMusuh?.text= typeMusuh
        Log.d("getIntenData","getIntentData berhasil")
    }

    private fun closeIconClicked() {
        binding?.ivCLose?.setOnClickListener {
            finish()
            exitProcess(0)
        }
    }

    private fun refreshIconClicked() {
        binding?.ivRefresh?.setOnClickListener {
            clearChoice()
        }

    }

    private fun openDialogPemenang() {
        dialogBinding = FragmentPemenangDialogBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(this)
            .apply {
                setView(dialogBinding?.root)
            }
            .create()

        if (pemenang == "SERI"){
            dialogBinding?.tvHasil?.isVisible=false
            dialogBinding?.tvPemenang?.text="SERI"
        }else{
            dialogBinding?.tvHasil?.isVisible=true
            dialogBinding?.tvPemenang?.text = pemenang
        }
        dialogBinding?.btnUlang?.setOnClickListener{
            dialog.dismiss()
            clearChoice()
        }
        dialogBinding?.btnMenu?.setOnClickListener{
            val intent= Intent(this, MenuGame::class.java)
            intent.putExtra(MenuGame.NAME,playerName)
            startActivity(intent)
        }
        dialog.show()
    }
}