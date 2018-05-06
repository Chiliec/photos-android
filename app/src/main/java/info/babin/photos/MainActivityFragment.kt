package info.babin.photos

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MainActivityFragment : Fragment() {

    private val adapter = PhotosAdapter(emptyList())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val fragment = inflater.inflate(R.layout.fragment_main, container, false)

        val recyclerView = fragment.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        val numberOfColumns = 2
        val layoutManager = GridLayoutManager(this.context, numberOfColumns)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        updatePhotos()
        return fragment
    }

    private fun updatePhotos() {
        val ds = DataSource()
        val resourceKey = resources.getString(R.string.yandex_disk_resource_key)
        ds.getPhotos(resourceKey) { photos ->
            activity?.runOnUiThread {
                adapter.photos = photos
                adapter.notifyDataSetChanged()
            }
        }
    }
}
