package com.example.workout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailsActivity : AppCompatActivity() {
    companion object{
        val EXTRA_WORKOUT_ID = "id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val frag = supportFragmentManager.findFragmentById(R.id.detail_frag)
                as WorkoutDetailFragment

        val workoutId = intent.extras!!.getLong(EXTRA_WORKOUT_ID).toInt()
        frag.setWorkout(workoutId)
    }
}