package shafiei.homa.huma.presenter;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;
import java.util.Random;
import shafiei.homa.huma.model.Movie;
import shafiei.homa.huma.R;
import shafiei.homa.huma.view.TvRecyclerview.Presenter;
import shafiei.homa.huma.view.TvRecyclerview.RowItem;

public class MoviePresenter extends Presenter {

    private final Context context;
    private final List<Movie> newsList;

    public MoviePresenter(Context context, List<Movie> news) {
        super(context);
        this.context = context;
        this.newsList = news;
    }

    @Override
    public View onCreateView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.row_movie, null);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        RowItem rowItem = (RowItem) item;
        TextView title = (TextView) viewHolder.view.findViewById(R.id.tv_movie_title);
        TextView desc = (TextView) viewHolder.view.findViewById(R.id.tv_movie_desc);
        ImageView icon = (ImageView) viewHolder.view.findViewById(R.id.imv_movie_icon);
        title.setText(newsList.get(rowItem.getPos()).getTitle());
        desc.setText(Html.fromHtml(newsList.get(rowItem.getPos()).getDescription()).toString());
        Glide.with(getContext())
                .load(newsList.get(rowItem.getPos()).getCardImageUrl())
                .into(icon);

        viewHolder.view.setSelected(true);
        viewHolder.view.setFocusable(true);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
                1.0f
        );
        viewHolder.view.setLayoutParams(params);

        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }

    public static int getRandColor() {
        Random random = new Random();
        return Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

}
