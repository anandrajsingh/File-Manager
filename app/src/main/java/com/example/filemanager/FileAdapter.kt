package com.example.filemanager

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.io.File
import android.text.format.Formatter

class FileAdapter(private val fileList: List<File>,private val context: Context, private val onFileSelectedListener: OnFileSelectedListener):
    RecyclerView.Adapter<FileAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.file_container, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = fileList.get(position).name
        holder.tvName.isSelected
        var items = 0

        if(fileList.get(position).isDirectory){
            val files = fileList.get(position).listFiles()
            for(singleFile in files){
                if(!singleFile.isHidden){
                    items++
                }
            }
            holder.tvFileSize.text = "$items Files"
        }else{
            holder.tvFileSize.text = Formatter.formatShortFileSize(context, fileList.get(position).length())
        }

        when(fileList.get(position).name.toLowerCase()){
            ".jpeg",".jpg",".png" -> holder.imageFile.setImageResource(R.drawable.ic_image)
            ".pdf" -> holder.imageFile.setImageResource(R.drawable.ic_pdf)
            ".doc" -> holder.imageFile.setImageResource(R.drawable.ic_docs)
            ".mp3", ".wav" -> holder.imageFile.setImageResource(R.drawable.ic_music)
            ".mp4" -> holder.imageFile.setImageResource(R.drawable.ic_play)
            ".apk" -> holder.imageFile.setImageResource(R.drawable.ic_android)
            else -> holder.imageFile.setImageResource(R.drawable.ic_folder)
        }

        holder.cardView.setOnClickListener{
            onFileSelectedListener.onFileClicked(fileList.get(position))
        }
        holder.cardView.setOnLongClickListener{
            onFileSelectedListener.onFileLongClicked(fileList.get(position), position)
            true
        }
    }

    override fun getItemCount() = fileList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageFile: ImageView = itemView.findViewById(R.id.img_fileType)
        val tvName: TextView = itemView.findViewById(R.id.tv_fileName)
        val tvFileSize: TextView = itemView.findViewById(R.id.tv_fileSize)
        val cardView: CardView = itemView.findViewById(R.id.file_container)
    }
}