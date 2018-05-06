package info.babin.photos

import android.os.Bundle
import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import com.bumptech.glide.load.engine.DiskCacheStrategy

class DetailActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        if (intent.hasExtra("photo_url")) {
            val url = intent.getStringExtra("photo_url")
            val image = findViewById<ImageView>(R.id.detailImageView)
            GlideApp
                .with(image)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(ColorDrawable(Color.RED))
                .into(image)
            image.setOnClickListener { this.onBackPressed() }
        }
    }
}
