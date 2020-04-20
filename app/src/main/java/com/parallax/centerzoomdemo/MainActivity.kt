package com.parallax.centerzoomdemo

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.parallax.centerzoomdemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), RecyclerViewHolder.ItemClickListener {

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: LinearLayoutManager
    private var data: MutableList<Int> = mutableListOf(android.R.drawable.gallery_thumb, android.R.drawable.gallery_thumb)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val hoges = resources.getStringArray(R.array.hoges).toMutableList()

        var binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewAdapter = RecyclerAdapter(this, this, data)
        //viewManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        viewManager = CenterZoomLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        binding.mainRecyclerView.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }

        binding.mainRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                Log.e("x",dx.toString())
                Log.e("y",dy.toString())
                val totalCount = recyclerView.adapter!!.itemCount //合計のアイテム数
                val childCount = recyclerView.childCount // RecyclerViewに表示されてるアイテム数
                val layoutManager = recyclerView.layoutManager
                if (layoutManager is LinearLayoutManager) { // LinearLayoutManager
                    val firstPosition =
                        layoutManager.findFirstVisibleItemPosition() // RecyclerViewの一番上に表示されているアイテムのポジション
                    if (totalCount == childCount + firstPosition) { // ページング処理
                        Log.e("ここきた","fwefewfwefwe")
                        binding.mainRecyclerView.scrollToPosition(0)
                    }
                }
            }


        })



    }



    override fun onItemClick(view: View, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



}