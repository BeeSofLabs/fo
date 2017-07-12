package core.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.vipulasri.timelineview.TimelineView;
import com.labs.bee.app.fo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ary on 7/12/17.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {


    @Override
    public MenuAdapter.MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_menu_item, parent, false);
        return new MenuViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(MenuAdapter.MenuViewHolder holder, int position) {
        holder.itemMenuName.setText("Menu #"+(position+1));
        if(position == 2) {
            holder.timeMaker.setLineSize(0);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    static class MenuViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_menu_name)
        TextView itemMenuName;

        @BindView(R.id.time_marker)
        TimelineView timeMaker;

        public MenuViewHolder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
