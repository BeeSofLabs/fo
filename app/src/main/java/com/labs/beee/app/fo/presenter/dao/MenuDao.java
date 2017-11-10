package com.labs.beee.app.fo.presenter.dao;

import android.content.Context;

import com.labs.beee.app.fo.model.pojo.Menu;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmResults;

/**
 * Created by ary on 6/20/17.
 */

public class MenuDao extends BaseDao {

    protected MenuDao(Context context) {
        super(context);
    }

    public static MenuDao instanceObject(Context context) {
        return new MenuDao(context);
    }

    public static void saveMenu(Menu menu, Context context) {
        instanceObject(context);

        if (getObjectByKeyRealm("id", menu.getId(), Menu.class).size() > 0) return;

        saveToRealm(menu);
    }

    public static Menu getMenu(Context context) {
        instanceObject(context);
        Menu user = null;
        try {
            user = (Menu) getObjectsRealm(Menu.class).last();
        } catch (Exception e) {
            user = new Menu();
        }

        return user;
    }

    public static List<Menu> getMenuFavorites(Context context) {
        instanceObject(context);
        RealmResults<Menu> data = getObjectByKeyRealm("isFavorite", true, Menu.class);
        if (data.size() > 0) return data;
        return new ArrayList();
    }

    public static void deleteMenu(Context context) {
        instanceObject(context);
        deleteRealm(Menu.class);
    }
}
