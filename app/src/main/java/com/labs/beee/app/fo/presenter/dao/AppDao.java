package com.labs.beee.app.fo.presenter.dao;

import android.content.Context;

import app.beelabs.com.codebase.base.BaseDao;
import app.beelabs.com.codebase.support.util.DeviceUtil;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by arysuryawan on 12/20/17.
 */

public class AppDao extends BaseDao {

    // --- realm db config ---
    protected static Realm realm;

    public AppDao(Context context) {
        super(context);
        setupRealm(context);
    }

    protected Realm setupRealm(Context context) {
        Realm.init(context);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .name("foodpicker.realm")
                .encryptionKey(DeviceUtil.encryptedKey64())
                .build();

        // Get a Realm instance for this thread
        realm = Realm.getInstance(realmConfig);

        return realm;
    }

    protected static RealmObject saveToRealm(RealmObject object) {
        realm.beginTransaction();
        RealmObject obj = realm.copyToRealm(object);
        realm.commitTransaction();


        return obj;
    }

    protected static RealmResults getObjectsRealm(Class clazz) {
        RealmResults objects = realm.where(clazz).findAll();

        return objects;
    }


    protected static RealmResults getObjectByKeyRealm(String key, int value, Class clazz) {
        RealmResults items = realm.where(clazz)
                .beginGroup()
                .equalTo(key, value)
                .endGroup()
                .findAll();

        return items;
    }

    protected static RealmResults getObjectByKeyRealm(String key, boolean value, Class clazz) {
        RealmResults items = realm.where(clazz)
                .beginGroup()
                .equalTo(key, value)
                .endGroup()
                .findAll();

        return items;
    }

    protected static RealmResults getObjectByKeyRealm(String key, String value, Class clazz) {
        RealmResults items = realm.where(clazz)
                .beginGroup()
                .equalTo(key, value)
                .endGroup()
                .findAll();

        return items;
    }

    protected static void closeRealm() {
        if (realm != null)
            realm.close();
    }

    protected static void deleteRealm(Class clazz) {
        try {
            realm.beginTransaction();
            realm.delete(clazz);
            realm.commitTransaction();
        } catch (Exception e) {
        }
    }
}