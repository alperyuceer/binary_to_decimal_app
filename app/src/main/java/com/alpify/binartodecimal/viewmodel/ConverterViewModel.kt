package com.alpify.binartodecimal.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ConverterViewModel @Inject constructor() : ViewModel() {
    private val _girilenDeger = MutableStateFlow<String>("")
    val girilenDeger: StateFlow<String> = _girilenDeger

    private val _sonucDeger = MutableStateFlow<String>("")
    val sonucDeger: StateFlow<String> = _sonucDeger

    fun inputDegisti(yeniGirilen: String) {
        _girilenDeger.value = yeniGirilen
        _sonucDeger.value = try {
            if (yeniGirilen.isNotBlank()){
                yeniGirilen.toLong(2).toString()
            } else {
                ""
            }
        } catch (e: Exception){
            "Hatalı Giriş"
        }
    }
}