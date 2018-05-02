package info.babin.photos

import android.content.Intent
import android.content.res.Resources
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.load.engine.DiskCacheStrategy

class PhotosAdapter(private val photos: Array<String>) : RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val imageView = v.findViewById(R.id.imageView) as ImageView
        var imageUrl = ""
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): PhotosAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.photo_item, parent, false)
        val viewHolder = ViewHolder(v)
        val halfDisplaySize = Resources.getSystem().displayMetrics.widthPixels / 2
        viewHolder.imageView.layoutParams.height = halfDisplaySize
        viewHolder.imageView.layoutParams.width = halfDisplaySize
        viewHolder.imageView.setOnClickListener({ _ ->
            val intent = Intent(parent.context, DetailActivity::class.java)
            intent.putExtra("photo_url", viewHolder.imageUrl)
            parent.context.startActivity(intent)
        })
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val url = photos[position]
        holder.imageUrl = url
        GlideApp
            .with(holder.imageView)
            .load(url)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return photos.size
    }
}
