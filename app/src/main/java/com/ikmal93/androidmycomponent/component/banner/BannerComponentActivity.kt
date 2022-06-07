package com.ikmal93.androidmycomponent.component.banner

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.ikmal93.androidmycomponent.R
import com.ikmal93.androidmycomponent.databinding.BannerComponentActivityBinding

class BannerComponentActivity : AppCompatActivity() {

    private lateinit var binding: BannerComponentActivityBinding
    private var bannerListItem: MutableList<BannerModel> = mutableListOf()
    private lateinit var bannerSliderAdapter: BannerSliderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BannerComponentActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        bannerListItem.addAll(
            mutableListOf(
                BannerModel(
                    "Turtle",
                    "https://images.pexels.com/photos/847393/pexels-photo-847393.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"
                ),
                BannerModel(
                    "Chameleon",
                    "https://images.pexels.com/photos/567540/pexels-photo-567540.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"
                ),
                BannerModel(
                    "Tiger",
                    "https://images.pexels.com/photos/302304/pexels-photo-302304.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"
                ),
                BannerModel(
                    "Frog",
                    "https://images.pexels.com/photos/76957/tree-frog-frog-red-eyed-amphibian-76957.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"
                ),
                BannerModel(
                    "Lion",
                    "https://images.pexels.com/photos/33045/lion-wild-africa-african.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"
                ),
                BannerModel(
                    "Rhino",
                    "https://images.pexels.com/photos/16040/pexels-photo.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"
                ),
                BannerModel(
                    "Cat",
                    "https://images.pexels.com/photos/617278/pexels-photo-617278.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"
                )
            )
        )
        binding.apply {
            bannerSliderAdapter = BannerSliderAdapter(bannerListItem)
            vpImageSlider.adapter = bannerSliderAdapter
            vpImageSlider.currentItem = 0
            addBottomDots(llDots, bannerSliderAdapter.itemCount, 0)
            vpImageSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    addBottomDots(llDots, bannerSliderAdapter.itemCount, position)
                }
            })
        }
    }


    fun addBottomDots(layout_dots: LinearLayoutCompat, size: Int, current: Int) {
        val dots = arrayOfNulls<AppCompatImageView>(size)
        layout_dots.removeAllViews()
        for (i in dots.indices) {
            dots[i] = AppCompatImageView(this)
            val width_height = 16
            val params =
                LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams(width_height, width_height))
            params.setMargins(10, 10, 10, 10)
            dots[i]!!.layoutParams = params
            dots[i]!!.setImageResource(R.drawable.shape_circle)
            dots[i]!!
                .setColorFilter(
                    ContextCompat.getColor(this, R.color.overlay_dark_10),
                    PorterDuff.Mode.SRC_ATOP
                )
            layout_dots.addView(dots[i])
        }
        if (dots.isNotEmpty()) {
            dots[current]!!
                .setColorFilter(
                    ContextCompat.getColor(this, R.color.colorPrimaryLight),
                    PorterDuff.Mode.SRC_ATOP
                )
        }
    }
}