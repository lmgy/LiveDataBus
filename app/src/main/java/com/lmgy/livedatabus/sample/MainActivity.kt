package com.lmgy.livedatabus.sample

import android.content.Intent
import android.os.Bundle
import android.util.Log.e
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.lmgy.livedatabus.livedatabus.LiveDataBus
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            LiveDataBus.with(Event::class.java).setValueSticky(Event("hello", 1))
            startActivity(Intent(this, SecondActivity::class.java))
        }

        LiveDataBus.with(Event::class.java).observe(this, Observer {
            if (it.id == 2) {
                e("LiveDataBus", "Main" + it.message + System.currentTimeMillis())
                Toast.makeText(this, it.message + System.currentTimeMillis(), Toast.LENGTH_LONG)
                    .show()
            }
        })

    }
}
