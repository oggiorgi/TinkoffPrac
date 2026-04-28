package com.example.kotlinclasshomework.event

import com.example.kotlinclasshomework.R


class EventGenerator {
    private val imageIdList: List<Int> = listOf(
        R.drawable.basketball,
        R.drawable.form1,
        R.drawable.badi
    )
    fun generateEvents(count:Int): List<Event> =
        (0..count).map{index ->
            Event(
                imageResId = imageIdList.random(),
                name = "Событие $index",
                time = "${(12..23).random()}:${(10..59).random()}"
            )
        }

    companion object
}