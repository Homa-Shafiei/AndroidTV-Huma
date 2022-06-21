package shafiei.homa.huma.presenter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import shafiei.homa.huma.R
import shafiei.homa.huma.model.Movie
import shafiei.homa.huma.view.TvRecyclerview.Presenter
import shafiei.homa.huma.view.TvRecyclerview.RowItem

class MoviePresenter(context: Context, private val newsList: List<Movie>) : Presenter(context) {
    override fun onCreateView(): View {
        return LayoutInflater.from(context).inflate(R.layout.row_movie, null)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val rowItem = item as RowItem
        val title = viewHolder.view.findViewById<View>(R.id.tv_movie_title) as TextView
        val desc = viewHolder.view.findViewById<View>(R.id.tv_movie_desc) as TextView
        val icon = viewHolder.view.findViewById<View>(R.id.imv_movie_icon) as ImageView
        title.text = newsList[rowItem.pos].title
        desc.text = newsList[rowItem.pos].description
        Glide.with(context)
            .load(newsList[rowItem.pos].cardImageUrl)
            .into(icon)
        viewHolder.view.isSelected = true
        viewHolder.view.isFocusable = true
        val params = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT,
            1.0f
        )
        viewHolder.view.layoutParams = params
        viewHolder.view.setOnClickListener {}
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {}
}