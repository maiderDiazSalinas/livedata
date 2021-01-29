package com.example.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VM:ViewModel() {
    val datoObservable:MutableLiveData<String> = MutableLiveData<String>()

    init{
        datoObservable.value=""
    }

}