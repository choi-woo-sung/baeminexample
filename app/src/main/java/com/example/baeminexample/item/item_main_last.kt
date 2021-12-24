package com.example.baeminexample.item

import android.text.Layout
import android.view.View
import android.view.ViewGroup
import com.example.baeminexample.R
import com.example.baeminexample.databinding.*
import com.example.baeminexample.dto.PresentDto
import com.xwray.groupie.viewbinding.BindableItem

/**
 * baemin example
 * Class: item_present
 * Created by 82102 on 2021-12-24.
 *
 * Description:
 */
class item_main_last(val image: Int ) : BindableItem<ItemScrollCenterLastBinding>() {


    override fun bind(itemScrollBulmiBinding: ItemScrollCenterLastBinding, position: Int) {
        with(itemScrollBulmiBinding) {
            imageViewIdol.setImageResource(image)

        }
    }


    override fun getLayout(): Int {
        return (R.layout.item_scroll_center_last)
    }

    override fun initializeViewBinding(p0: View): ItemScrollCenterLastBinding {

        return ItemScrollCenterLastBinding.bind(p0)
    }
}