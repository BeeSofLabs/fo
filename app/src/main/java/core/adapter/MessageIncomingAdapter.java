package core.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.CircularImageView;
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
                .inflate(R.layout.row_order_notification, parent, false);

        return new MenuViewHolder(v);
    }

    public void onBindViewHolder(MenuViewHolder holder, int position) {
        Menu m = (Menu) items.get(position);



        Picasso.with(activity)
                .load("https://pbs.twimg.com/profile_images/378800000554670519/3f5a4f607f364dc4e1b5a1f1f3a0609b.jpeg")
                .into(holder.notifOwnerAvatar);
        holder.notifOwner.setText("Mr. Andrew");
        holder.notifLocation.setText("Location at Jl. Sultan Iskandar Muda 2, 23");
        holder.notifOrderDrinkNum.setText(""+3);
        holder.notifOrderFoodNum.setText(""+2);
//        holder.itemCategory.setImageResource(m.getCategory().equals("drink") ? R.mipmap.ic_drink_white : R.mipmap.ic_food_white);
//        holder.itemMenuImage.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    static class MenuViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.notif_owner_avatar)
        CircularImageView notifOwnerAvatar;

        @BindView(R.id.notif_owner)
        TextView notifOwner;

        @BindView(R.id.notif_location)
        TextView notifLocation;

        @BindView(R.id.notif_order_food_num)
        TextView notifOrderFoodNum;

        @BindView(R.id.notif_order_drink_num)
        TextView notifOrderDrinkNum;


        public MenuViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
