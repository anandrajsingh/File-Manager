package com.example.filemanager

import android.content.Context
import android.content.Intent
import androidx.core.content.FileProvider
import java.io.File
import java.io.IOException

class FileOpener {
    companion object{
        fun openFile(context: Context, file: File){
            try{
                val selectedFile = file
                val uri = FileProvider.getUriForFile(context, context.packageName + ".provider", file)

                val intent = Intent(Intent.ACTION_VIEW)

                when  {
                    uri.toString().contains(".doc") -> intent.setDataAndType(uri, "application/msword")
                    uri.toString().contains(".pdf") -> intent.setDataAndType(uri, "application/pdf")
                    uri.toString().contains(".mp3") || uri.toString().contains(".wav") -> intent.setDataAndType(uri, "application/wav")
                    uri.toString().contains(".wav") -> intent.setDataAndType(uri, "application/wav")
                    uri.toString().contains(".jpeg") || uri.toString().contains(".jpg")
                            || uri.toString().contains(".png") -> intent.setDataAndType(uri, "image/jpeg")
                    uri.toString().contains(".mp4") -> intent.setDataAndType(uri, "video/*")
                    else -> {
                        intent.setDataAndType(uri, "*/*")
                    }
                }
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                context.startActivity(intent);
            }catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}