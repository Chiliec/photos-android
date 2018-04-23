package info.babin.photos

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class PhotosAdapter(private val photos: Array<String>) : RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val textView: TextView = v.findViewById(R.id.photoItemTextView) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): PhotosAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.photo_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = photos[position]
    }

    override fun getItemCount(): Int {
        return photos.size
    }
}
