package com.example.baeminexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.widget.ViewPager2
import com.example.baeminexample.databinding.ActivityMainBinding
import com.example.baeminexample.dto.PresentDto
import com.example.baeminexample.item.*
import com.simform.refresh.SSPullToRefreshLayout
import com.xwray.groupie.Group
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.viewbinding.BindableItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var linearLayoutManager: LinearLayoutManager

     val headerNum = MutableLiveData<Int>()
     val footerNum = MutableLiveData<Int>()
    val headerSize = getFoodList().size


    private lateinit var staggeredGridLayoutManager: StaggeredGridLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        with(binding) {
            binding.lifecycleOwner = this@MainActivity
            binding.activity = this@MainActivity

            viewPager2.adapter = HeaderAdapter(getFoodList()) // 어댑터 생성
            viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 방향을 가로로


            viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                }

                override fun onPageSelected(position: Int) {
                    headerNum.value = position+1
                    super.onPageSelected(position)
                }

                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                }
            })


            viewPager3.adapter = HeaderAdapter(getFooterViewPager()) // 어댑터 생성
            viewPager3.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 방향을 가로로

            viewPager3.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                }

                override fun onPageSelected(position: Int) {
                    footerNum.postValue(position)
                    super.onPageSelected(position)
                }

                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                }
            })


            val presentAdapter = GroupieAdapter()
            val bulmiAdapter = GroupieAdapter()
            val headerAdapter = GroupieAdapter()
            val mainAdapter = GroupieAdapter()


            presentAdapter.update(getPresentList().map { item_present(it) })
            bulmiAdapter.update(getBulmiList())
            headerAdapter.update(getSaleList())
            mainAdapter.update(getShopList())


            scrollHeader.adapter = headerAdapter
            scrollCenter.adapter = mainAdapter
            scrollPresent.adapter = presentAdapter
            scrollBulmi.adapter = bulmiAdapter


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

    private fun getSaleList(): ArrayList<out Group> {
        return arrayListOf(
            item_header(R.drawable.item_header_scroll_1),
            item_header( R.drawable.item_header_scroll_2),
            item_header(R.drawable.item_header_scroll_1),
            item_header(R.drawable.item_header_scroll_2),
            item_header(R.drawable.item_header_scroll_1),
            item_header(R.drawable.item_header_scroll_2),
            item_header_last(R.drawable.item_header_scroll_last),
        )
    }

    private fun getShopList(): ArrayList<Group> {
        return arrayListOf<Group>(
            item_main( R.drawable.scroll_main_1),
            item_main(R.drawable.scroll_main_2),
            item_main(R.drawable.scroll_main_1),
            item_main(R.drawable.scroll_main_2),
            item_main(R.drawable.scroll_main_1),
            item_main_last(R.drawable.scroll_main_last)
        )
    }

    private fun getPresentList(): ArrayList<PresentDto> {
        return arrayListOf<PresentDto>(
            PresentDto(R.raw.christmassnowball, "스노우볼"),
            PresentDto(R.raw.christmasgiftlottie, "크리스마스트리"),
            PresentDto(R.raw.christmassnowball, "스노우볼"),
            PresentDto(R.raw.christmasgiftlottie, "크리스마스트리"),
            PresentDto(R.drawable.scroll_present_1, "", true),
        )
    }

    private fun getBulmiList(): ArrayList<Group> {
        //같이 넣으려먼 어떻게 해야하는가?
        return arrayListOf(
            item_bulmi(R.drawable.scroll_bulmi_1),
            item_bulmi(R.drawable.scroll_bulmi_2),
            item_bulmi(R.drawable.scroll_bulmi_1),
            item_bulmi(R.drawable.scroll_bulmi_2),
            item_bulmi_last(R.drawable.scroll_bulmi_3)
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
            binding.buttonBaemin -> toast("배달")
            binding.buttonBell -> toast("벨")
            binding.buttonInfo -> toast("정보")
            binding.buttonMenu -> toast("메뉴")
            binding.buttonPozang -> toast("포장")
            binding.buttonShopinglive -> toast("쇼핑라이브")


        }
    }
}





