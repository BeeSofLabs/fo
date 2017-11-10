package com.labs.beee.app.fo.presenter.dao;

import android.content.Context;

import com.labs.beee.app.fo.ui.base.BaseActivity;
import com.labs.beee.app.fo.ui.base.BaseFragment;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;
import retrofit2.Callback;
import support.util.DeviceUtil;

/**
 * Created by arysuryawan on 8/19/17.
 */

public class BaseDao {

    private String callbackKey;

    private static BaseActivity ac = null;
    private static BaseFragment fm = null;


    public BaseDao(Object obj) {
        if (obj instanceof BaseActivity) this.ac = ac;
        if (obj instanceof BaseFragment) this.fm = fm;
    }

    public BaseDao(Object obj, String keyCallback) {
        if (obj instanceof BaseActivity) {
            this.ac = (BaseActivity) obj;
            this.callbackKey = keyCallback;
        }
        if (obj instanceof BaseFragment) {
            this.fm = (BaseFragment) obj;
            this.callbackKey = keyCallback;
        }
    }


    public static BaseDao getInstance(Object current) {
        return getInstance(current, "");
    }

    public static BaseDao getInstance(Object current, String key) {
        if (current instanceof BaseActivity)
            return new BaseDao(current, key);
        else if (current instanceof BaseFragment)
            return new BaseDao(current, key);
        return null;
    }

    public Callback callback = new Callback() {

        @Override
        public void onResponse(retrofit2.Call call, retrofit2.Response response) {
            if (ac != null)
                BaseActivity.onResponseCallback(call, response, ac, callbackKey);
            else
                BaseFragment.onResponseCallback(call, response, fm, callbackKey);
        }

        @Override
        public void onFailure(retrofit2.Call call, Throwable t) {
            if (ac != null)
                BaseActivity.onFailureCallback(t, ac);
            else
                BaseFragment.onFailureCallback(t, fm);
        }
    };


    public void call() {
    }


    // --- realm db ---
    protected static Realm realm;

    protected BaseDao(Context context) {
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
