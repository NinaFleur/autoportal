package api;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;


public class CitiesApiTest extends BaseApiTest {

    @Test()
    public void test() {
        restApiExecutor.getCitiesDocsResponse()
                .statusCode(200)
                .root("response")
                .body(
                        "status", equalTo("success"),
                        "numFound", instanceOf(Integer.class),
                        "start", instanceOf(Integer.class)
                );
    }

}
