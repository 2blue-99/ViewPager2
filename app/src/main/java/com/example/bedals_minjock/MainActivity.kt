package com.example.bedals_minjock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.viewpager2.widget.ViewPager2
import com.example.bedals_minjock.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var nowLocation = Int.MAX_VALUE/2
    val myDataList = mutableListOf<Data>()
    private lateinit var binding: ActivityMainBinding

//    private val binding: ActivityMainBinding by lazy {
//        ActivityMainBinding.inflate(layoutInflater)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        getIdolList()

        myDataList.add(Data(getDrawable(R.drawable.heyin1)!!))
        myDataList.add(Data(getDrawable(R.drawable.heyin2)!!))
        myDataList.add(Data(getDrawable(R.drawable.heyin3)!!))
        myDataList.add(Data(getDrawable(R.drawable.heyin4)!!))

        initViewPager()

//        binding.myViewPager.adapter = ViewPageAdapter(getIdolList()) // 어댑터 생성
//        binding.myViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 방향을 가로로
    }

    fun initViewPager(){
        val adapter = ViewPageAdapter()
        adapter.heyinList = myDataList
        binding.myViewPager.adapter = adapter
        binding.myViewPager.apply {
        }
    }

}