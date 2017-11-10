package com.labs.beee.app.fo.presenter.dao;

import android.content.Context;

import com.labs.beee.app.fo.IConfig;

import java.util.ArrayList;
import java.util.List;

import com.labs.beee.app.fo.model.pojo.Order;
import io.realm.RealmResults;

/**
 * Created by ary on 6/20/17.
 */

public class OrderDao extends BaseDao {

    protected OrderDao(Context context) {
        super(context);
    }

    public static OrderDao instanceObject(Context context) {
        return new OrderDao(context);
    }

    public static void saveOrder(Order order, Context context) {
        instanceObject(context);

        if(getObjectByKeyRealm("id", order.getId(), Order.class).size() > 0) return;

        saveToRealm(order);
    }

    public static Order getOrder(Context context) {
        instanceObject(context);
        Order o = null;
        try {
            o = (Order) getObjectsRealm(Order.class).last();
        } catch (Exception e) {
            o = new Order();
        }

        return o;
    }

    public static List<Order> getIncomingOrder(Context context) {
        instanceObject(context);
        RealmResults<Order> data = getObjectByKeyRealm("status", IConfig.INCOMING_STATUS_NAME, Order.class);
        if (data.size() > 0) return data;
        return new ArrayList();
    }
    public static List<Order> getProcessOrder(Context context) {
        instanceObject(context);
        RealmResults<Order> data = getObjectByKeyRealm("status", IConfig.PROCESS_STATUS_NAME, Order.class);
        if (data.size() > 0) return data;
        return new ArrayList();
    }

    public static List<Order> getOutcomingOrder(Context context) {
        instanceObject(context);
        RealmResults<Order> data = getObjectByKeyRealm("status", IConfig.OUTCOMING_STATUS_NAME, Order.class);
        if (data.size() > 0) return data;
        return new ArrayList();
    }

    public static void deleteOrder(Context context) {
        instanceObject(context);
        deleteRealm(Order.class);
    }
}
