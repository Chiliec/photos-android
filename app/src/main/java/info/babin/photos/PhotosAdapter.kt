package info.babin.photos

import android.content.res.Resources
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.load.engine.DiskCacheStrategy

class PhotosAdapter(private val photos: Array<String>) : RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {

    private val countPhotosInRow = 2

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val imageView = v.findViewById(R.id.imageView) as ImageView
        val imageView2 = v.findViewById(R.id.imageView2) as ImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): PhotosAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.photo_item, parent, false)

        val halfDisplaySize = Resources.getSystem().displayMetrics.widthPixels / 2

        val viewHolder = ViewHolder(v)
        viewHolder.imageView.layoutParams.width = halfDisplaySize
        viewHolder.imageView.layoutParams.height = halfDisplaySize
        viewHolder.imageView2.layoutParams.width = halfDisplaySize
        viewHolder.imageView2.layoutParams.height = halfDisplaySize

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val url = photos[position]
        GlideApp
            .with(holder.imageView)
            .load(url)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.imageView)
        if (position < photos.size) {
            val url2 = photos[position + 1]
            GlideApp
                .with(holder.imageView2)
                .load(url2)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageView2)
        }
    }

    override fun getItemCount(): Int {
        var count = photos.size / countPhotosInRow
        if (photos.size % 2 != 0) {
            count += 1
        }
        return count
    }
}
