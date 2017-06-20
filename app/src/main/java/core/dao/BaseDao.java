package core.dao;

import android.content.Context;

import core.tools.util.DeviceUtil;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by ary on 6/19/17.
 */

public class BaseDao {

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
