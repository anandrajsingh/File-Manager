package com.example.filemanager.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.filemanager.FileAdapter
import com.example.filemanager.R
import java.io.File

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fileAdapter: FileAdapter
    private lateinit var fileList: List<File>
    private lateinit var linearImage: LinearLayout
    private lateinit var linearVideo: LinearLayout
    private lateinit var linearMusic: LinearLayout
    private lateinit var linearDocs: LinearLayout
    private lateinit var linearDownloads: LinearLayout
    private lateinit var linearApks: LinearLayout

    lateinit var storage: File
    lateinit var data: String
    val items = arrayOf("Details", "Rename", "Delete", "Share")

    lateinit var view: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        view = inflater.inflate(R.layout.fragment_home, container, false)

        linearImage = view.findViewById(R.id.linearImage)
        linearVideo = view.findViewById(R.id.linearVideo)
        linearMusic = view.findViewById(R.id.linearMusic)
        linearDocs = view.findViewById(R.id.linearDocs)
        linearDownloads = view.findViewById(R.id.linearDownloads)
        linearApks = view.findViewById(R.id.linearApk)

        linearImage.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("filetype", "image")
            val categorizedFragment = Ca
        }

        return view
    }
}