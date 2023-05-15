package com.example.filemanager

import java.io.File

interface OnFileSelectedListener {
    fun onFileClicked(file: File)
    fun onFileLongClicked(file: File, positon:Int)
}