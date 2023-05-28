package com.zero.wordle.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.zero.wordle.R

class WordleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Debugging", "Enter B")
        setContentView(R.layout.wordle_activity)
        Log.i("Debugging", "Enter B")
        addFragment(WordleFragment::class.java)
    }

    fun addFragment(newFragment: Class<*>, bundle: Bundle?=null, addToBackStack: String?=null){
        val transaction = supportFragmentManager.beginTransaction()
            .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out,
                android.R.animator.fade_in, android.R.animator.fade_out)

        Log.i("Debugging", "Enter A")
        transaction.add(
            R.id.wordleFragmentContainer,
            newFragment as Class<out Fragment>,
            bundle,
            null
        )

        transaction.addToBackStack(addToBackStack)
        transaction.commit()
    }

}