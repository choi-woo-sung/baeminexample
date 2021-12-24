package com.example.baeminexample.item

import android.text.Layout
import android.view.View
import android.view.ViewGroup
import com.example.baeminexample.R
import com.example.baeminexample.databinding.ItemScrollBulmiBinding
import com.example.baeminexample.databinding.ItemScrollCenterBinding
import com.example.baeminexample.databinding.ItemScrollHeaderBinding
import com.example.baeminexample.databinding.ItemScrollPresentBinding
import com.example.baeminexample.dto.PresentDto
import com.xwray.groupie.viewbinding.BindableItem

/**
 * baemin example
 * Class: item_present
 * Created by 82102 on 2021-12-24.
 *
 * Description:
 */
class item_main(val image: Int ) : BindableItem<ItemScrollCenterBinding>() {


    override fun bind(itemScrollBulmiBinding: ItemScrollCenterBinding, position: Int) {
        with(itemScrollBulmiBinding) {
            imageViewIdol.setImageResource(image)

        }
    }


    override fun getLayout(): Int {
        return (R.layout.item_scroll_center)
    }

    override fun initializeViewBinding(p0: View): ItemScrollCenterBinding {

        return ItemScrollCenterBinding.bind(p0)
    }
}