package com.zero.wordle.view

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.zero.wordle.R
import com.zero.wordle.databinding.WordleFragmentBinding


class WordleFragment: Fragment() {

    var binding: WordleFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        Log.i("Debugging", "Enter here")
        binding = WordleFragmentBinding.inflate(inflater, container, false)
        uiSet()

        return binding!!.root
    }

    private fun uiSet(){
        setWordleLine()
        generateKeys()
    }

    private fun setWordleLine( ){
        for(x in 0..4){
            var text = "wordRow$x"
            val resourceId = resources.getIdentifier(text, "id", requireContext().packageName)
            for (i in 0..4){
                var generateText = TextView(this.context).apply {
                    width = 200
                    height = 200
                    setTextColor(Color.parseColor("#000000"))
                    text = "A"
                    setBackgroundResource(R.drawable.black)
                }
                binding!!.root.findViewById<LinearLayout>(resourceId).addView(generateText)
            }
        }
    }

    private fun generateKeys(){
        val alphabet = ('A'..'Z') // Range of letters from A to Z

        var i = 0
        var x = 0

        //generating alphabets
        for (letter in alphabet) {
            if(i % 7 == 0){
                x++
            }

            val resourceId = resources.getIdentifier(
                "buttonAlphabet$x", "id", requireContext().packageName)

            val button = Button(context).apply {
                text = letter.toString()
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    height = 150
                    width = 150
                }

                // Set click listener, background color, etc.
            }

            // Add the button to your desired layout
            Log.i("Debugging", "$resourceId   buttonAlphabet$x")
            binding!!.root.findViewById<LinearLayout>(resourceId).addView(button)
            i++
            //binding!!.buttonAlphabet0.addView(button)
        }

        //delete button
        val deleteButton = Button(context).apply {
            text = "Delete"
        }
        binding!!.buttonAlphabet4.addView(deleteButton)

        //submit button
        val submit = Button(context).apply {
            text = "Submit"
        }
        binding!!.buttonEtc.addView(submit)
    }

}