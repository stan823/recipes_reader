package baking_app.sbrzezinski.com.bakingapp.ui.adapters.recipes_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import baking_app.sbrzezinski.com.bakingapp.R;

/**
 * Created by Stanislaw Brzezinski  on 28/03/2018 16:52.
 */

public class RecipesViewHolder extends RecyclerView.ViewHolder {

    private final ImageView imageHolder;
    private final TextView nameHolder;
    private final View card;

    public RecipesViewHolder(View itemView) {
        super(itemView);
        card=itemView.findViewById(R.id.card);
        nameHolder = itemView.findViewById(R.id.tv_name);
        imageHolder = itemView.findViewById(R.id.iv_image);
    }

    public View getCard() {
        return this.card;
    }

    public void setImage(String imageUrl) {

        // setting up image - if url is empty, then remove image
        if (imageUrl!=null && !imageUrl.isEmpty()) {
            Context context = itemView.getContext();
            if (context != null) {
                Picasso.with(context)
                        .load(imageUrl)
                        .into(imageHolder);
            }
        }else{
            imageHolder.setImageDrawable(null);
        }
    }

    public void setName(String name) {
        nameHolder.setText(name);
    }
}
