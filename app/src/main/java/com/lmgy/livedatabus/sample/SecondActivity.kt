package com.lmgy.livedatabus.sample

import android.os.Bundle
import android.util.Log.e
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.lmgy.livedatabus.livedatabus.LiveDataBus
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        LiveDataBus.with(StringEvent::class.java).observe(this, Observer {
            if (it.id == 1) {
                e("LiveDataBus", "Second" + it.message + System.currentTimeMillis())
                Toast.makeText(this, it.message + System.currentTimeMillis(), Toast.LENGTH_LONG)
                    .show()
            }
        }, true)

        button.setOnClickListener {
            LiveDataBus.with(StringEvent::class.java).post(StringEvent("return", 2))
            finish()
        }
    }

}
