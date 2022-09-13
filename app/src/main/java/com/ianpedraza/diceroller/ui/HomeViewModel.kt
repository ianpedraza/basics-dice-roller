package com.ianpedraza.diceroller.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ianpedraza.diceroller.R
import com.ianpedraza.diceroller.utils.Event
import kotlin.random.Random

class HomeViewModel : ViewModel() {

    private val _diceImageResource: MutableLiveData<Event<Int>> =
        MutableLiveData()

    val diceImageResource: LiveData<Event<Int>>
        get() = _diceImageResource

    fun rollDice() {
        val randomInt = Random.nextInt(6) + 1

        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        _diceImageResource.value = Event(drawableResource)
    }

}