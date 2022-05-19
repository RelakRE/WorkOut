package com.example.workout

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), WorkoutListFragment.Listener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun itemClicked(id: Long) {
        val fragContainer = findViewById<FrameLayout>(R.id.fragment_container)
        if (fragContainer != null) {
            val transaction = supportFragmentManager.beginTransaction()
            val frag = WorkoutDetailFragment()
            frag.setWorkout(id.toInt())
            transaction.replace(R.id.fragment_container, frag)
            transaction.addToBackStack(null)
            transaction.commit()
        }else {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(DetailsActivity.EXTRA_WORKOUT_ID, id)
            startActivity(intent)
        }
    }
}