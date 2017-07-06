package core.adapter;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.CircularImageView;
import com.labs.bee.app.fo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import core.dao.model.Order;
import seed.OrderDummy;

/**
 * Created by ary on 6/20/17.
 */

public class MessageProcessAdapter extends RecyclerView.Adapter<MessageProcessAdapter.NotifViewHolder> {

    private Activity activity;
    private List<Order> items;

    public MessageProcessAdapter(Activity activity) {
        this.activity = activity;
        this.items = (new OrderDummy()).getProcessOrder(activity);
    }

    @Override
    public NotifViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_order_notification, parent, false);

        return new NotifViewHolder(v);
    }


    @Override
    public void onBindViewHolder(NotifViewHolder holder, int position) {
        Order order = (Order) items.get(position);


        Picasso.with(activity)
                .load(order.getPersonUrl())
                .into(holder.notifOwnerAvatar);
        holder.notifOwner.setText(order.getPerson());
        holder.notifLocation.setText(order.getLocation());

        holder.notifOrderFoodNum.setText("Food  " + order.getFoodNum());
        holder.notifOrderDrinkNum.setText("Drink  " + order.getDrinkNum());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class NotifViewHolder extends RecyclerView.ViewHolder {
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


        public NotifViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
