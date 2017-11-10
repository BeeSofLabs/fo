package com.labs.beee.app.fo.ui.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.labs.beee.app.fo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.labs.beee.app.fo.ui.component.FontManager;


/**
 * Created by ary on 7/12/17.
 */

public class MenuShopAdapter extends RecyclerView.Adapter<MenuShopAdapter.MenuViewHolder> {
    private Activity activity;
    private View layout;

    public MenuShopAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public MenuShopAdapter.MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_menu_item, parent, false);
        return new MenuViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(MenuShopAdapter.MenuViewHolder holder, int position) {
        holder.itemMenuName.setText("Menu #"+(position+1));
        holder.menuRemoveButton.setTypeface(FontManager.getTypeface(activity, FontManager.FONTAWESOME));

        if(position == 1) {
            holder.timelineCircle.setImageResource(R.drawable.circle_green);
            holder.timelineVerticalLine.setBackgroundColor(activity.getResources().getColor(R.color.app_orange));
        }
        if(position == 2) {
            holder.timelineVerticalLine.setVisibility(View.GONE);
            holder.delimiterBottomLine.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    static class MenuViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_menu_name)
        TextView itemMenuName;

        @BindView(R.id.delimiter_bottom_line)
        View delimiterBottomLine;
        @BindView(R.id.timeline_circle)
        ImageView timelineCircle;
        @BindView(R.id.timeline_vertical_line)
        View timelineVerticalLine;

        @BindView(R.id.button_menu_remove)
        Button menuRemoveButton;

        public MenuViewHolder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
