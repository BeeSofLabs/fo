package core.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.labs.bee.app.fo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import core.dao.model.Menu;
import seed.MenuDummy;

/**
 * Created by ary on 6/20/17.
 */

public class MessageIncomingAdapter extends BaseAdapter {

    private Activity activity;
    private List<Menu> items;

    public MessageIncomingAdapter(Activity activity) {
        this.activity = activity;
        this.items = new MenuDummy().getMenus(activity);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_menu_item, parent, false);

        return new MenuViewHolder(v);
    }

    public void onBindViewHolder(MenuViewHolder holder, int position) {
        Menu m = (Menu) items.get(position);

//        String formatLikes = activity.getResources().getString(R.string.format_likes, m.getLikes() + "");

//        holder.itemMenuImage.setImageResource(m.getImageUrl());

        Picasso.with(activity)
                .load(m.getImageUrl())
                .into(holder.itemMenuImage);

        Picasso.with(activity)
                .load(m.getLogoUrl())
                .into(holder.itemLogo);
        holder.itemMenuName.setText(m.getName());
//        holder.itemMenuLikes.setText(formatLikes);
        holder.itemMenuPrice.setText(m.getPrice());
        holder.itemDistance.setText(m.getDistance());
//        holder.itemCategory.setImageResource(m.getCategory().equals("drink") ? R.mipmap.ic_drink_white : R.mipmap.ic_food_white);
//        holder.itemMenuImage.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    static class MenuViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_menu_image)
        ImageView itemMenuImage;

        @BindView(R.id.item_category)
        ImageView itemCategory;

        @BindView(R.id.item_logo)
        ImageView itemLogo;

        @BindView(R.id.item_menu_name)
        TextView itemMenuName;

        @BindView(R.id.item_menu_price)
        TextView itemMenuPrice;

        @BindView(R.id.item_menu_likes)
        TextView itemMenuLikes;

        @BindView(R.id.item_distance)
        TextView itemDistance;

        public MenuViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
