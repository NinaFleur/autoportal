package api;

import api.RestApiExecutor;
import org.springframework.expression.ParseException;
import org.testng.annotations.BeforeClass;

    public class BaseApiTest {
        public RestApiExecutor restApiExecutor;

        @BeforeClass(alwaysRun = true)
        public void beforeClassInit() throws ParseException {
            restApiExecutor = RestApiExecutor.getInstance();
        }
    }

