package com.example.baeminexample.item

import android.view.View
import com.example.baeminexample.R
import com.example.baeminexample.databinding.ItemBulmiLastBinding
import com.example.baeminexample.databinding.ItemScrollBulmiBinding
import com.xwray.groupie.viewbinding.BindableItem

/**
 * baemin example
 * Class: item_bulmi_last
 * Created by 82102 on 2021-12-24.
 *
 * Description:
 */
class item_bulmi_last(val image: Int ) : BindableItem<ItemBulmiLastBinding>() {

    override fun bind(itemScrollBulmiBinding: ItemBulmiLastBinding, position: Int) {
        with(itemScrollBulmiBinding) {
            imageViewIdol.setImageResource(image)

        }
    }


    override fun getLayout(): Int {
        return (R.layout.item_bulmi_last)
    }

    override fun initializeViewBinding(p0: View): ItemBulmiLastBinding {

        return ItemBulmiLastBinding.bind(p0)
    }
}