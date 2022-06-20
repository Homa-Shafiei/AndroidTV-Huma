package shafiei.homa.huma.ui;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import shafiei.homa.huma.model.Movie;
import shafiei.homa.huma.model.MovieList;
import shafiei.homa.huma.R;
import shafiei.homa.huma.presenter.MoviePresenter;
import shafiei.homa.huma.view.TvRecyclerview.FocusHighlightHelper;
import shafiei.homa.huma.view.TvRecyclerview.GridObjectAdapter;
import shafiei.homa.huma.view.TvRecyclerview.RowItem;
import shafiei.homa.huma.view.TvRecyclerview.VerticalGridView;

public class MainGridFragment extends Fragment {

    List<Movie> movies = MovieList.INSTANCE.getList();
    VerticalGridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid_movie, container, false);

        gridView = view.findViewById(R.id.gridView);
        setData();
        return view;
    }

    private class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.right = 30;
            outRect.bottom = 30;
        }
    }

    public void setData() {
        gridView.addItemDecoration(new SpaceItemDecoration());
        gridView.setNumColumns(4);
        GridObjectAdapter adapter = new GridObjectAdapter(new MoviePresenter(getContext(), movies));
        gridView.setFocusZoomFactor(FocusHighlightHelper.ZOOM_FACTOR_SMALL);
        gridView.setAdapter(adapter);
        for (int count = 0; count < 10; count++) {
            for (int i = 0; i < movies.size(); i++) {
                RowItem rowItem = new RowItem();
                rowItem.setPos(i);
                adapter.add(rowItem);
            }
        }
    }
}
