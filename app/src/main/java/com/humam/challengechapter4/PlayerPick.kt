package com.humam.challengechapter4

enum class PlayerPick(val value: Int) {
    ROCK(0),
    PAPER(1),
    SCISSOR(2);
    companion object {
        fun fromInt(value: Int) = values().first(){it.value == value}
    }
}