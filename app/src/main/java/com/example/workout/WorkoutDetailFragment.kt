package com.example.workout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class WorkoutDetailFragment : Fragment() {

    private var workoutId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            workoutId = savedInstanceState.getInt("workoutId")
        }else{
            val stopwach = StopwatchFragment()
            val ft = childFragmentManager.beginTransaction()
            ft.add(R.id.stopwatch_container, stopwach)
            ft.addToBackStack(null)
            ft.commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    fun setWorkout(id: Int) {
        workoutId = id
    }

    override fun onStart() {
        super.onStart()
        val viewTitle = view?.findViewById<TextView>(R.id.textTittle)
        viewTitle!!.text = Workout.workout[workoutId].name
        val viewDescription = view?.findViewById<TextView>(R.id.textDetail)
        viewDescription!!.text = Workout.workout[workoutId].description
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("workOutId", workoutId)
        super.onSaveInstanceState(outState)
    }

}