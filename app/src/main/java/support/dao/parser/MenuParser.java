package support.dao.parser;

import android.content.Context;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonValue;
import com.labs.bee.app.fo.IConfig;

import java.util.ArrayList;
import java.util.List;

import support.dao.MenuDao;
import support.dao.model.Menu;
import support.tools.util.DataUtil;

/**
 * Created by ary on 6/20/17.
 */

public class MenuParser {

    public static List<Menu> getMenus(String results, Context context) {
        JsonValue jsonValue = Json.parse(results).asObject().get(IConfig.API_ROOT_MENUS);
        JsonArray jsonArray = jsonValue.asArray();

        MenuDao.deleteMenu(context);

        List<Menu> menus = new ArrayList<>();
        for (JsonValue obj : jsonArray) {
            Menu menu = new Menu();
            menu.setId(obj.asObject().getInt("id", 0));
            menu.setName(obj.asObject().getString("name", ""));
            menu.setLikes(obj.asObject().getInt("likes", 0));
            menu.setDistance(obj.asObject().getString("distance", "-"));
            menu.setPrice(obj.asObject().getString("price", "-"));

            menu.setPromo(obj.asObject().getString("promo", "-"));
            menu.setLogoUrl(obj.asObject().getString("logoUrl", ""));
            menu.setImageUrl(obj.asObject().getString("imageUrl", ""));
            menu.setCategory(obj.asObject().getString("category", ""));
            menu.setFavorite(DataUtil.booleanValue(obj.asObject().getInt("isFavorite", 0)));

            menus.add(menu);


            MenuDao.saveMenu(menu, context);
        }
        return menus;
    }
}
