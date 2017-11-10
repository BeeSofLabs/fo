package com.labs.beee.app.fo.presenter.dao.parser;

import android.content.Context;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonValue;
import com.labs.beee.app.fo.IConfig;

import java.util.ArrayList;
import java.util.List;

import com.labs.beee.app.fo.presenter.dao.OrderDao;
import com.labs.beee.app.fo.model.pojo.Order;

/**
 * Created by ary on 6/20/17.
 */

public class OrderParser {

    public static List<Order> setOrders(String results, Context context) {
        JsonValue jsonValue = Json.parse(results).asObject().get(IConfig.API_ROOT_ORDERS);
        JsonArray jsonArray = jsonValue.asArray();

        OrderDao.deleteOrder(context);

        List<Order> orders = new ArrayList<>();
        for (JsonValue obj : jsonArray) {
            Order order = new Order();
            order.setId(obj.asObject().getInt("id", 0));
            order.setPerson(obj.asObject().getString("person", ""));
            order.setPersonUrl(obj.asObject().getString("person_url", ""));
            order.setLocation(obj.asObject().getString("location", ""));
            order.setFoodNum(obj.asObject().getInt("food", 0));
            order.setDrinkNum(obj.asObject().getInt("drink", 0));
            order.setStatus(obj.asObject().getString("status", ""));

            orders.add(order);


            OrderDao.saveOrder(order, context);
        }
        return orders;
    }
}
