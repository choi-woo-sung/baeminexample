package com.example.baeminexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.baeminexample.databinding.ActivityMainBinding
import com.simform.refresh.SSPullToRefreshLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        with(binding) {
            viewPager2.adapter = HeaderAdapter(getFoodList()) // 어댑터 생성
            viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 방향을 가로로
            viewPager3.adapter = HeaderAdapter(getFooterViewPager()) // 어댑터 생성
            viewPager3.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 방향을 가로로

            scrollHeader.adapter = ScrollHeaderAdapter(getSaleList())
            scrollCenter.adapter = ScrollMainAdapter(getShopList())
            scrollPresent.adapter = ScrollPresentAdapter(getPresentList())
            scrollBulmi.adapter = ScrollBulmiAdapter(getBulmiList())

            linearLayoutManager = LinearLayoutManager(this@MainActivity)
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL)
            scrollHeader.layoutManager = linearLayoutManager

            linearLayoutManager = LinearLayoutManager(this@MainActivity)
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL)
            scrollCenter.layoutManager = linearLayoutManager

            linearLayoutManager = LinearLayoutManager(this@MainActivity)
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL)
            scrollPresent.layoutManager = linearLayoutManager

            linearLayoutManager = LinearLayoutManager(this@MainActivity)
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL)
            scrollBulmi.layoutManager = linearLayoutManager

            buttonBaedal.setOnClickListener(this@MainActivity)
            expandable.setOnClickListener(this@MainActivity)
            buttonBaemin.setOnClickListener(this@MainActivity)
            buttonBell.setOnClickListener(this@MainActivity)
            buttonInfo.setOnClickListener(this@MainActivity)
            buttonMenu.setOnClickListener(this@MainActivity)
            buttonPozang.setOnClickListener(this@MainActivity)
            buttonShopinglive.setOnClickListener(this@MainActivity)


            ssPullRefresh?.apply {
                setRefreshTargetOffset(800f)
                setOnRefreshListener(object : SSPullToRefreshLayout.OnRefreshListener {
                    override fun onRefresh() {
                        // This is demo code to perform
                        CoroutineScope(Dispatchers.Main).launch {
                            delay(1000)
                            ssPullRefresh.setRefreshing(false) // This line stops layout refreshing
                        }
                    }
                })

            }
        }
    }

    // 뷰 페이저에 들어갈 아이템
    private fun getFoodList(): ArrayList<Int> {
        return arrayListOf<Int>(
            R.drawable.item_header_1,
            R.drawable.item_header_2,
            R.drawable.item_header_1,
            R.drawable.item_header_2,
            R.drawable.item_header_1,
            R.drawable.item_header_2
        )
    }

    private fun getSaleList(): ArrayList<Int> {
        return arrayListOf<Int>(
            R.drawable.item_header_scroll_1,
            R.drawable.item_header_scroll_2,
            R.drawable.item_header_scroll_1,
            R.drawable.item_header_scroll_2,
            R.drawable.item_header_scroll_1,
            R.drawable.item_header_scroll_2,
            R.drawable.item_header_scroll_last
        )
    }

    private fun getShopList(): ArrayList<Int> {
        return arrayListOf<Int>(
            R.drawable.scroll_main_1,
            R.drawable.scroll_main_2,
            R.drawable.scroll_main_1,
            R.drawable.scroll_main_2,
            R.drawable.scroll_main_1,
            R.drawable.scroll_main_2
        )
    }

    private fun getPresentList(): ArrayList<Int> {
        return arrayListOf<Int>(
            R.drawable.scroll_present_1,
            R.drawable.scroll_present_2,
            R.drawable.scroll_present_1,
            R.drawable.scroll_present_2,
            R.drawable.scroll_present_1,
            R.drawable.scroll_present_2
        )
    }

    private fun getBulmiList(): ArrayList<Int> {
        return arrayListOf<Int>(
            R.drawable.scroll_bulmi_1,
            R.drawable.scroll_bulmi_2,
            R.drawable.scroll_bulmi_1,
            R.drawable.scroll_bulmi_2,
            R.drawable.scroll_bulmi_1,
            R.drawable.scroll_bulmi_2
        )
    }

    private fun getFooterViewPager(): ArrayList<Int> {
        return arrayListOf<Int>(
            R.drawable.footer_viewpager_1,
            R.drawable.footer_viewpager_2,
            R.drawable.footer_viewpager_1,
            R.drawable.footer_viewpager_2,
            R.drawable.footer_viewpager_1,
            R.drawable.footer_viewpager_2,
        )
    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.buttonBaedal -> toast("배달")
            binding.expandable -> if (binding.expandable.isExpanded) {
                binding.expandable.collapse()
            } else {
                binding.expandable.expand()
            }
            binding. buttonBaemin->toast("배달")
                    binding.buttonBell-> toast("벨")
                    binding.buttonInfo-> toast("정보")
                    binding.buttonMenu-> toast("메뉴")
                    binding.buttonPozang -> toast("포장")
                    binding.buttonShopinglive -> toast("쇼핑라이브")


        }
    }
}





