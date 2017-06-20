package core.tools.util;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.security.MessageDigest;
import java.util.Random;
import java.util.UUID;

/**
 * Created by ary on 6/20/17.
 */

public class DeviceUtil {

    public static String getUUID() {

        return UUID.randomUUID().toString();
    }


    public static byte[] encryptedKey64() {
        // security key to encrypted the Realm
        byte[] key = new byte[64];
        new Random(42).nextBytes(key);
        return key;
    }

    // generate random string in 15 chars
    public static String randomString() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random r = new Random(); // perhaps make it a class variable so you don't make a new one every time
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            char c = chars.charAt(r.nextInt(chars.length()));
            sb.append(c);
        }
        return sb.toString();
    }

    public static String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

//    public static Location getDropboxLocation(Context context){
//        GPSTracker gpsTracker = new GPSTracker(context);
//        if(gpsTracker.canGetLocation()){
//            gpsTracker.getLocation().getLatitude();
//            gpsTracker.getLocation().getLongitude();
//        };
//        return gpsTracker.getLocation();
//    }
//    public static Location setupGPS(Activity activity) {
//        Location location = null;
//        LocationManager service = (LocationManager) activity.getSystemService(LOCATION_SERVICE);
//
//
//        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            boolean enabled = service.isProviderEnabled(LocationManager.GPS_PROVIDER);
//            if (!enabled) {
//                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//                activity.startActivity(intent);
//            } else {
//                Criteria criteria = new Criteria();
//                String provider = service.getBestProvider(criteria, false);
//                location = service.getLastKnownLocation(provider);
//            }
//        }
//
//
//        return location;
//    }


    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
