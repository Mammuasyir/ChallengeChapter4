//package com.humam.challengechapter4.dialog
//
//import android.content.Intent
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.DialogFragment
//import com.humam.challengechapter4.R
//import com.humam.challengechapter4.activity.MenuGame
//import com.humam.challengechapter4.activity.PlayerVsComActivity
//import com.humam.challengechapter4.databinding.FragmentPemenangDialogBinding
//
//class PemenangDialog(): DialogFragment() {
//
//    var binding: FragmentPemenangDialogBinding? = null
//    var playerName: String? = null
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentPemenangDialogBinding.inflate(layoutInflater)
//        return binding?.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val width = ViewGroup.LayoutParams.MATCH_PARENT
//        val height = ViewGroup.LayoutParams.WRAP_CONTENT
//        dialog?.window?.setLayout(width, height)
//        binding?.tvPemenang?.text = if (playerName == "player") "Anda Menang" else "Komputer Menang"
//        binding?.tvHasil?.text =
//        binding?.btnUlang?.setOnClickListener {
//            dialog?.dismiss()
//            //ambil function reset game dari activity utama
//            (activity as PlayerVsComActivity).resetGame()
//        }
//        binding?.btnMenu?.setOnClickListener {
//            val intent = Intent(context, MenuGame::class.java)
//            intent.putExtra(MenuGame.NAME, playerName)
//            startActivity(intent)
//        }
//    }
//}