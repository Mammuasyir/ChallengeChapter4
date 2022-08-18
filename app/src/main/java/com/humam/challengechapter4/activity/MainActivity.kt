package com.humam.challengechapter4.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.humam.challengechapter4.R
import com.humam.challengechapter4.adapter.LandingPageAdapter
import com.humam.challengechapter4.databinding.ActivityMainBinding
import com.humam.challengechapter4.databinding.FragmentLandingPage3Binding
import com.humam.challengechapter4.fragment.LandingPage3
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    val Page1 = 0
    val Page2 = 1
    val Page3 = 2

    var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.hide()

        initLandingPage()
    }

    private fun initLandingPage() {
        val LandingPageAdapter = LandingPageAdapter(this)
        binding?.vpLandingPage?.adapter = LandingPageAdapter

        //menjalankan view pagernya
        binding?.vpLandingPage?.currentItem = Page1

        binding?.vpLandingPage?.apply {
            adapter = LandingPageAdapter
            registerOnPageChangeCallback(object  : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    when{
                        (position == Page1) -> {
                            binding?.tvNext?.visibility = View.VISIBLE
                            binding?.tvNext?.isEnabled = true
                            binding?.tvPrev?.visibility= View.INVISIBLE
                            binding?.tvPrev?.isEnabled= true
                        }
                        (position < (LandingPageAdapter.itemCount - 1)) ->{
                            binding?.tvNext?.visibility = View.VISIBLE
                            binding?.tvNext?.isEnabled = true
                            binding?.tvPrev?.visibility= View.VISIBLE
                            binding?.tvPrev?.isEnabled=true
                        }
                        (position == (LandingPageAdapter.itemCount - 1)) ->{
                            binding?.tvNext?.visibility = View.INVISIBLE
                            binding?.tvNext?.isEnabled = false
                            binding?.tvPrev?.visibility= View.INVISIBLE
                            binding?.tvPrev?.isEnabled= false
                        }
                    }
                    super.onPageSelected(position)
                }
            })
        }

        binding?.vpLandingPage?.let { binding?.wormDotsIndicator?.setViewPager2(it) }
        binding?.tvNext?.setOnClickListener{
            if (binding?.vpLandingPage?.currentItem == Page1 || binding?.vpLandingPage?.currentItem == Page2){
                binding?.vpLandingPage?.setCurrentItem(binding?.vpLandingPage?.currentItem!! +1,true)
            }

            binding?.tvPrev?.setOnClickListener{
                if (binding?.vpLandingPage?.currentItem == Page2){
                    binding?.vpLandingPage?.setCurrentItem(binding?.vpLandingPage?.currentItem!! -1,true)
                }
            }

        }
    }

}