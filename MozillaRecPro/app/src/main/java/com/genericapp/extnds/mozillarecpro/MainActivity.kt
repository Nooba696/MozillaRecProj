package com.genericapp.extnds.mozillarecpro

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.genericapp.extnds.mozillarecpro.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(action_bar)
        apiService.itemQuery().enqueue(object : Callback<Table> {
            override fun onResponse(call: Call<Table>, response: Response<Table>) {
                progress_bar.visibility = View.GONE
                initUi(response.body().products!!)
            }

            override fun onFailure(call: Call<Table>, t: Throwable) {

            }
        })

    }

    private fun initUi(items: List<Item>) {

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.Companion.VERTICAL_LIST))
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.adapter = RecyclerViewAdaptar(this, items)
    }
}
