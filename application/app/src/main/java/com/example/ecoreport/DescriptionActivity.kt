package com.example.ecoreport

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Path
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_description.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*


class DescriptionActivity : AppCompatActivity() {
    companion object{
        const val problemName = "problemName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        problem.text = intent.getStringExtra(problemName)
    }

    fun takePhoto(view: View) {
        val takePhotoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        startActivityForResult(takePhotoIntent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK)
        {
            val pUri = data?.extras?.get("data") as Path
            println(pUri)
            val thumbnailBitmap = data?.extras?.get("data") as Bitmap

            photo.setImageBitmap(thumbnailBitmap)
        }
    }


}