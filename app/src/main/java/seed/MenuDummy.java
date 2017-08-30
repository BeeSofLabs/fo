package seed;

import android.content.Context;

import java.util.List;

import com.labs.bee.app.fo.presenter.dao.MenuDao;
import com.labs.bee.app.fo.model.pojo.Menu;
import com.labs.bee.app.fo.presenter.dao.parser.MenuParser;

/**
 * Created by ary on 6/20/17.
 */

public class MenuDummy {

    private static String getJson() {
        return "{" +
                "\"menus\": [" +
                "{ \"id\": 1, \"name\": \"Chocolate Cake Aroma\", \"likes\": 10, \"category\": \"food\", \"distance\": \"30 min\", \"price\": \"IDR 25.000,00\", \"stock\": 3, \"promo\": \"15%\", \"logoUrl\": \"http://orig04.deviantart.net/9ba5/f/2011/171/c/6/chocolate_logo_by_jwd987-d3jeqe5.jpg\", \"imageUrl\": \"http://www.kulinologi.biz/acrobat/rudy/gambar/pudingcoklat.jpg\", \"isFavorite\": 1 }," +
                "{ \"id\": 2, \"name\": \"Es Puding Pak Cole\",  \"likes\": 5, \"category\": \"food\", \"distance\": \"1 hour\", \"price\": \"IDR 12.500,00\", \"stock\": 5, \"promo\": \"5%\", \"logoUrl\": \"http://pescaicecream.com/wp-content/uploads/2013/09/logo-pesca.png\", \"imageUrl\": \"https://img-global.cpcdn.com/003_recipes/40b444c2c0a648a9/1200x630cq70/photo.jpg\", \"isFavorite\": 1 }," +
                "{ \"id\": 3, \"name\": \"Es Cendol\",  \"likes\": 3, \"category\": \"drink\", \"distance\": \"1 hour\", \"price\": \"IDR 12.500,00\", \"stock\": 2, \"order\": 0, \"promo\": \"5%\", \"logoUrl\": \"https://scontent.cdninstagram.com/t51.2885-19/11116777_685980598191677_315483432_a.jpg\", \"imageUrl\": \"https://assets-pergikuliner.com/rucimSW-q4enWC_565SVcSrb2Wc=/385x290/smart/https://assets-pergikuliner.com/uploads/image/picture/375639/picture-1478587020.jpg\", \"isFavorite\": 1 }" +
                "]}";
    }

    public static List<Menu> getMenus(Context context) {
        return MenuParser.getMenus(getJson(), context);
    }

    public static List<Menu> getMenuFavorites(Context context) {
        return MenuDao.getMenuFavorites(context);
    }
}
