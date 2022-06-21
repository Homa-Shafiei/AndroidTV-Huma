package shafiei.homa.huma.ui

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import kotlinx.android.synthetic.main.fragment_grid_movie.*
import shafiei.homa.huma.R
import shafiei.homa.huma.model.MovieList
import shafiei.homa.huma.presenter.MoviePresenter
import shafiei.homa.huma.view.TvRecyclerview.FocusHighlightHelper
import shafiei.homa.huma.view.TvRecyclerview.GridObjectAdapter
import shafiei.homa.huma.view.TvRecyclerview.RowItem

class GridMovieFragment : Fragment() {

    private var movies = MovieList.list

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_grid_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
    }

    private fun setData() {
        gridView.addItemDecoration(SpaceItemDecoration())
        gridView.setNumColumns(4)
        val adapter = GridObjectAdapter(MoviePresenter(requireContext(), movies))
        gridView.setFocusZoomFactor(FocusHighlightHelper.ZOOM_FACTOR_SMALL)
        gridView.setAdapter(adapter)
        for (count in 0..9) {
            for (i in movies.indices) {
                val rowItem = RowItem()
                rowItem.pos = i
                adapter.add(rowItem)
            }
        }
    }

    private inner class SpaceItemDecoration : ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            outRect.right = 30
            outRect.bottom = 30
        }
    }
}