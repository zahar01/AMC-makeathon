package com.example.ecoreport
import java.io.File
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.widget.ImageView
import java.io.ByteArrayOutputStream
import java.time.LocalDate
import java.util.*

class OfflineStorage {

    fun imageToBitmap(image: ImageView): ByteArray {
        val bitmap = (image.getDrawable() as BitmapDrawable).getBitmap()
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream)
        return stream.toByteArray()
    }

    private var _problem = ""
        get() = field

    private var _description = ""
        get() = field

    //TODO() private val _photo = ""

    fun add(typeOfData: typeOfData, smth: String){
        when (typeOfData){
            com.example.ecoreport.typeOfData.PROBLEM -> _problem = smth
            com.example.ecoreport.typeOfData.DESCRIPTION -> _description = smth
        }

    }


//    fun add(typeOfData: typeOfData, ){
//        _description = description
//    }

    fun convertToFile() {
        val fileName = java.util.Calendar.getInstance().toString()
        var file = File("C:\\Users\\zakha\\Desktop\\amc-makeaton\\application\\app\\src\\main\\res\\localStorage\\$fileName").createNewFile()

    }

    fun reset(){
        _problem = ""
        _description = ""
        // photo = null

    }
}