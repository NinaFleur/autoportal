package api;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

public class LeadsCountTest extends BaseApiTest {

    @Test(description = "Count how many Newcars Leads were created per Feb")
    public void leadsCountNewcars() {
        restApiExecutor.getLeadsCount()
                .statusCode(200)
                .body("status", equalTo("ok"),
                        "count" , nullValue());



    }
}
