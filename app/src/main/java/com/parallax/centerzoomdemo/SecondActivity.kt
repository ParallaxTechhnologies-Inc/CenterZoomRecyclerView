package com.parallax.centerzoomdemo

import android.R
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.parallax.centerzoomdemo.databinding.ActivitySecondBinding
import com.yarolegovich.discretescrollview.transform.Pivot
import com.yarolegovich.discretescrollview.transform.ScaleTransformer


class SecondActivity: AppCompatActivity() , RecyclerViewHolder.ItemClickListener {
    private var data: MutableList<Int> = mutableListOf(R.drawable.gallery_thumb, R.drawable.gallery_thumb)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding: ActivitySecondBinding = DataBindingUtil.setContentView(this, com.parallax.centerzoomdemo.R.layout.activity_second)

        //binding.picker.addScrollListener(this)
        //binding.picker.addOnItemChangedListener(this)
        binding.picker.scrollToPosition(1)
        binding.picker.setAdapter( RecyclerAdapter(this, this, data))
        binding.picker.setItemTransformer(
            ScaleTransformer.Builder()
                .setMaxScale(1.05f)
                .setMinScale(0.8f)
                .setPivotX(Pivot.X.CENTER) // CENTER is a default one
                .setPivotY(Pivot.Y.BOTTOM) // CENTER is a default one
                .build()
        )

    }

    override fun onItemClick(view: View, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}