package seed;

import android.content.Context;

import java.util.List;

import support.dao.OrderDao;
import support.dao.model.Order;
import support.dao.parser.OrderParser;

/**
 * Created by ary on 6/24/17.
 */

public class OrderDummy {

    private static String getJson() {
        return "{" +
                "\"orders\": [" +
                "{ \"id\": 1, \"status\": \"INCOMING\", \"person\": \"Andrew N\", \"person_url\": \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjM0OTg4ODkwMV5BMl5BanBnXkFtZTgwOTgzMTYzOTE@._V1_UY317_CR2,0,214,317_AL_.jpg\", \"location\": \"Jl. Dharma Putra 2 NO 23\", \"food\": 3, \"drink\": 2}," +
                "{ \"id\": 2, \"status\": \"PROCESS\", \"person\": \"Bu Neny\", \"person_url\": \"https://ichef-1.bbci.co.uk/news/1024/cpsprodpb/E225/production/_93339875_obamalaughing.jpg\", \"location\": \"Jl. Kostrad\", \"food\": 2, \"drink\": 2}," +
                "{ \"id\": 5, \"status\": \"PROCESS\", \"person\": \"Bu Dimas\", \"person_url\": \"http://islamidia.com/wp-content/uploads/2016/08/gambar-lukisan-Habib-Rizieq.jpg\", \"location\": \"Kuningan, Setia Budi\", \"food\": 1, \"drink\": 1}," +
                "{ \"id\": 3, \"status\": \"OUTCOMING\", \"person\": \"Kris Farhan\", \"person_url\": \"https://vignette4.wikia.nocookie.net/guns-n-roses/images/c/c7/Axl_rose.png/revision/latest?cb=20140927214017\", \"location\": \"Jl. Kosambi Bandung, 12240\", \"food\": 2, \"drink\": 1}" +
                "]}";


    }

    private static List<Order> setOrders(Context context) {
        return OrderParser.setOrders(getJson(), context);
    }

    public static List<Order> getIncomingOrder(Context context) {
        setOrders(context);
        return OrderDao.getIncomingOrder(context);
    }

    public static List<Order> getProcessOrder(Context context){
        setOrders(context);
        return OrderDao.getProcessOrder(context);
    }

    public static List<Order> getOutcomingOrder(Context context){
        setOrders(context);
        return OrderDao.getOutcomingOrder(context);
    }
}
