package com.example.workout

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment

class WorkoutListFragment : ListFragment() {

    internal interface Listener {
        fun itemClicked(id: Long)
    }

    private var listener: Listener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val names = Array(Workout.workout.size) { i ->
            Workout.workout[i].name
        }

        val adapter = ArrayAdapter<String>(
            inflater.context, android.R.layout.simple_list_item_1,
            names
        )
        listAdapter = adapter
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Listener
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        listener?.itemClicked(id)
    }

}