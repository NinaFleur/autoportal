package testdata;

import environment.EnvironmentConfigurator;

public class Urls {

    public static final String BASE_ADMIN_URL = "https://autoportal.com/admin/";


    public static final String ADMIN_GOP_LEADS = BASE_ADMIN_URL + "leads/request/newcars/";
    public static final String ADMIN_BOOKING_LEADS = BASE_ADMIN_URL + "leads/request/booking/";

    public static final String INDEX = EnvironmentConfigurator.getInstance().getMySiteUrl();

    public static final String BASE_NEWCARS_PAGE = INDEX + "newcars/";
    public static final String BRAND_PAGE = BASE_NEWCARS_PAGE + "honda";
    public static final String MODEL_PAGE = BASE_NEWCARS_PAGE + "marutisuzuki/alto-800/";
    public static final String BROCHURE_PAGE = BASE_NEWCARS_PAGE + "tata/tiago/brochures.html";

    public static final String ON_ROAD_PRICE_PAGE = "https://autoportal.com/onroadprice.html";
    public static final String GOP_RESULT_PAGE = BASE_NEWCARS_PAGE + "hyundai/santro/onroadprice-in-newdelhi.html";

    public static final String AVP_DETAIL_PAGE = INDEX + "deals/ford/endeavour-2016-2019/22l-42-at-trend/ghaziabad";
}
