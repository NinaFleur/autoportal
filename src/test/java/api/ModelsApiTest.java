package api;


import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

public class ModelsApiTest extends BaseApiTest {

    @Test(description = "Verify body in Models API response")
    public void test() {
        restApiExecutor.getModelsDocsResponse()
                .statusCode(200)
                .root("response")
                .body("status", equalTo("success"),
                        "numFound", instanceOf(Integer.class),
                        "start", instanceOf(Integer.class)
                );
    }

    @Test()
    public void getModelArray() {
        restApiExecutor.getModelByIndex(0);
    }
}
