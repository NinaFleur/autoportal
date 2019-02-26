package api;

import org.testng.annotations.Test;

public class AvpApiTest extends BaseApiTest {

    @Test(description = "Get all stocks available")
    public void getAllStocks() {
        restApiExecutor.executeGetRequest("http://lms.autoportal.com//api/v1/stock/get")
    .statusCode(200);
    }
}
