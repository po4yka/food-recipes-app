package com.po4yka.foodrecipes.ui.fragments.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import coil.load
import com.po4yka.foodrecipes.R
import com.po4yka.foodrecipes.models.Result
import com.po4yka.foodrecipes.util.Constants.Companion.RECIPE_RESULT_KEY
import kotlinx.android.synthetic.main.fragment_overview.view.*
import org.jsoup.Jsoup

class OverviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_overview, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable(RECIPE_RESULT_KEY)

        if (myBundle != null) {
            view.main_imageView.load(myBundle.image)
            view.title_textView.text = myBundle.title
            view.likes_textView.text = myBundle.aggregateLikes.toString()
            view.time_textView.text = myBundle.readyInMinutes.toString()
            myBundle.summary.let {
                val summary = Jsoup.parse(it).text()
                view.summary_textView.text = summary
            }

            if (myBundle.vegetarian) {
                view.vegetarian_imageView.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
                view.vegetarian_textView.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
            }

            if (myBundle.vegan) {
                view.vegan_imageView.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
                view.vegan_textView.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
            }

            if (myBundle.glutenFree) {
                view.gluten_free_imageView.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
                view.gluten_free_textView.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
            }

            if (myBundle.dairyFree) {
                view.dairy_free_imageView.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
                view.dairy_free_textView.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
            }

            if (myBundle.veryHealthy) {
                view.healthy_imageView.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
                view.healthy_textView.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
            }

            if (myBundle.cheap) {
                view.cheap_imageView.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
                view.cheap_textView.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
            }
        } else {
            Toast.makeText(
                requireContext(),
                "Something went wrong with getting recipe information",
                Toast.LENGTH_SHORT
            ).show()
        }

        return view
    }
}