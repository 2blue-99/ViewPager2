package com.example.bedals_minjock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.text.Editable
import android.text.TextWatcher
import android.widget.Adapter
import androidx.core.text.isDigitsOnly
import androidx.viewpager2.widget.ViewPager2
import com.example.bedals_minjock.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private var currentPosition = Int.MAX_VALUE / 2
    private var myHandler = MyHandler()
    private var intervalTime = 1500.toLong()
    val myDataList = mutableListOf<Data>()
    private lateinit var binding: ActivityMainBinding


//    private val binding: ActivityMainBinding by lazy {
//        ActivityMainBinding.inflate(layoutInflater)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myTag.apply {
            pureumLib(5)
        }

//        myDataList.add(Data(getDrawable(R.drawable.heyin1)!!))
//        myDataList.add(Data(getDrawable(R.drawable.heyin2)!!))
//        myDataList.add(Data(getDrawable(R.drawable.heyin3)!!))
//        myDataList.add(Data(getDrawable(R.drawable.heyin4)!!))

        getList()
        val adapter = ViewPageAdapter()
        adapter.heyinList = myDataList
        binding.myViewPager.adapter = adapter
        binding.myViewPager.setCurrentItem(currentPosition, false)

        binding.myViewPager.apply {
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                    when (state) {
                        // 뷰페이저에서 손 떼었을때 / 뷰페이저 멈춰있을 때
                        ViewPager2.SCROLL_STATE_IDLE -> autoScrollStart(intervalTime)
                        // 뷰페이저 움직이는 중
                        ViewPager2.SCROLL_STATE_DRAGGING -> autoScrollStop()
                    }
                }
            })
        }

    }

    private fun autoScrollStart(intervalTime: Long) {
        myHandler.removeMessages(0) // 이거 안하면 핸들러가 1개, 2개, 3개 ... n개 만큼 계속 늘어남
        myHandler.sendEmptyMessageDelayed(0, intervalTime) // intervalTime 만큼 반복해서 핸들러를 실행하게 함
    }

    private fun autoScrollStop() {
        myHandler.removeMessages(0) // 핸들러를 중지시킴
    }

    private inner class MyHandler : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            if (msg.what == 0) {
                binding.myViewPager.setCurrentItem(binding.myViewPager.currentItem+1, true) // 다음 페이지로 이동
                autoScrollStart(intervalTime) // 스크롤을 계속 이어서 한다.
            }
        }
    }


    // 다른 페이지 갔다가 돌아오면 다시 스크롤 시작
    override fun onResume() {
        super.onResume()
        autoScrollStart(intervalTime)
    }

    // 다른 페이지로 떠나있는 동안 스크롤이 동작할 필요는 없음. 정지
    override fun onPause() {
        super.onPause()
        autoScrollStop()
    }

    private fun getList() {
        myDataList.add(Data(getDrawable(R.drawable.pp1)!!))
        myDataList.add(Data(getDrawable(R.drawable.pp2)!!))
        myDataList.add(Data(getDrawable(R.drawable.pp3)!!))
        myDataList.add(Data(getDrawable(R.drawable.pp4)!!))
        myDataList.add(Data(getDrawable(R.drawable.pp5)!!))
    }

}