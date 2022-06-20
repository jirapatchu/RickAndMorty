package com.praditsoft.myapplication

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleViewAdapter(private val mList: List<CharacterModel>) : RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_view, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val characterViewModel = mList!![position]

        // sets the image to the imageview from our itemHolder class
        //holder.imageView.setImageResource(characterViewModel.image)

        val imageURL = characterViewModel.image
        var image: Bitmap? = null
        try {
            val `in` = java.net.URL(imageURL).openStream()
            image = BitmapFactory.decodeStream(`in`)
            holder.imageView.setImageBitmap(image)
        } catch (e: Exception) {
            Log.d("Adapter", e.toString())
        }


        // sets the text to the textview from our itemHolder class
        holder.textViewName.text = characterViewModel.name
        holder.textViewStatus.text = characterViewModel.status
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.thumbnail)
        val textViewName: TextView = itemView.findViewById(R.id.name)
        val textViewStatus: TextView = itemView.findViewById(R.id.status)
    }
}