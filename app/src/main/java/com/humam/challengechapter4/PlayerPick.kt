package com.humam.challengechapter4

enum class PlayerPick(val value: Int) {
    BATU(0),
    KERTAS(1),
    GUNTING(2);
    companion object {
        fun fromInt(value: Int) = values().first(){it.value == value}
    }
} //berisi list dari batu, kertas, gunting yang bisa dipilih oleh player dan computer.