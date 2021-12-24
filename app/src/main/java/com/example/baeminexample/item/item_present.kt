package com.example.baeminexample.item

import android.view.View
import com.example.baeminexample.R
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
class item_present(val presentDto: PresentDto) : BindableItem<ItemScrollPresentBinding>() {


    override fun bind(itemScrollPresentBinding: ItemScrollPresentBinding, position: Int) {
        with(itemScrollPresentBinding) {
            if (presentDto.isLast) this.imageViewIdol.setImageResource(presentDto.LottieView)
            else imageViewIdol.setAnimation(presentDto.LottieView)
                .run { textView35.text = presentDto.text }
        }
    }


    override fun getLayout(): Int {
        return (R.layout.item_scroll_present)
    }

    override fun initializeViewBinding(p0: View): ItemScrollPresentBinding {

        return ItemScrollPresentBinding.bind(p0)
    }
}