package com.itis.androidsemfour.adapter.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.itis.androidsemfour.R
import com.itis.androidsemfour.data.response.City
import com.itis.androidsemfour.databinding.ItemCityBinding

private const val TEMP_50 = 50.0
private const val TEMP_30 = 30.0
private const val TEMP_20 = 20.0
private const val TEMP_15 = 15.0
private const val TEMP_10 = 10.0
private const val TEMP_10_MINUS = -10.0
private const val TEMP_20_MINUS = -20.0
private const val TEMP_40_MINUS = -40.0


class CityHolder(
    private val binding: ItemCityBinding,
    private val action: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private var city: City? = null

//    private val options = RequestOptions()
//        .priority(Priority.HIGH)
//        .diskCacheStrategy(DiskCacheStrategy.ALL)

    fun bind(item: City) {
        this.city = item
        with(binding) {
            tvName.text = item.name
            val tvTempText = item.main.temp.toString() + "°C"
            tvTemp.text = tvTempText
            temperatureColors(item.main.temp, binding.tvTemp)

            itemView.setOnClickListener {
                action(item.id)
            }
//            glide.load(generateIcon(item.weather[0].icon))
//                .apply(options)
//                .into(ivImage)
        }
    }

//    private fun generateIcon(iconId: String): String {
//        return "http://openweathermap.org/img/wn/$iconId@2x.png"
//    }

    private fun temperatureColors(temp: Double, textView: TextView) {
        when (temp) {
            in TEMP_30..TEMP_50 -> textView.setTextColor(
                ContextCompat.getColor(
                    textView.context,
                    R.color.temp_50
                )
            )
            in TEMP_20..TEMP_30 -> textView.setTextColor(
                ContextCompat.getColor(
                    textView.context,
                    R.color.temp_30
                )
            )
            in TEMP_15..TEMP_20 -> textView.setTextColor(
                ContextCompat.getColor(
                    textView.context,
                    R.color.temp_20
                )
            )
            in TEMP_10..TEMP_15 -> textView.setTextColor(
                ContextCompat.getColor(
                    textView.context,
                    R.color.temp_15
                )
            )
            in 0.0..TEMP_10 -> textView.setTextColor(
                ContextCompat.getColor(
                    textView.context,
                    R.color.temp_10
                )
            )
            in TEMP_10_MINUS..0.0 -> textView.setTextColor(
                ContextCompat.getColor(
                    textView.context,
                    R.color.temp_0
                )
            )
            in TEMP_20_MINUS..TEMP_10_MINUS -> textView.setTextColor(
                ContextCompat.getColor(
                    textView.context,
                    R.color.temp_10_minus
                )
            )
            in TEMP_40_MINUS..TEMP_20_MINUS -> textView.setTextColor(
                ContextCompat.getColor(
                    textView.context,
                    R.color.temp_20_minus
                )
            )
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            action: (Int) -> Unit
        ) = CityHolder(
            ItemCityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), action
        )
    }
}
