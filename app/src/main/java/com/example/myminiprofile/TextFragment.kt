package com.example.myminiprofile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class TextFragment : Fragment() {

    companion object {
        private const val ARG_TEXT = "arg_text"

        fun newInstance(text: String): TextFragment {
            val fragment = TextFragment()
            val args = Bundle()
            args.putString(ARG_TEXT, text)
            fragment.arguments = args
            return fragment
        }
    }

    private var displayText: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        displayText = arguments?.getString(ARG_TEXT)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_text, container, false)
        view.findViewById<TextView>(R.id.textView).text = displayText
        return view
    }
}
