package com.labs.bee.app.fo;

/**
 * Created by ary on 6/20/17.
 */

public interface IConfig {
    String API_BASE_URL = "https://newsapi.org/v1/";
    String DEFAULT_LOADING = "Loading";

    public String INCOMING_TAB_NAME = "Incoming";
    public String PROCESS_TAB_NAME = "Progress";
    public String OUTCOMING_TAB_NAME = "Outcoming";

    public String INCOMING_STATUS_NAME = "INCOMING";
    public String PROCESS_STATUS_NAME = "PROCESS";
    public String OUTCOMING_STATUS_NAME = "OUTCOMING";

    //    API
    String API_ROOT_MENUS = "menus";
    String API_ROOT_ORDERS = "orders";

}
