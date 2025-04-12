package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.model.DressType
import com.example.myapplication.model.ImageData
import com.example.myapplication.model.ImageListFactory

class ImageViewModel : ViewModel() {
    private val _imageList = ImageListFactory.makeImageList()

    val imageList = _imageList

    fun toggleDress(index: Int, checked: Boolean) {
        val old = _imageList[index]
        _imageList[index] = old.copy(
            dressType = if (checked) old.originalDressType else DressType.UNDRESSED
        )
    }
}
