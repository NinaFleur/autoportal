package api;

import io.restassured.config.DecoderConfig;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RedirectConfig;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.log4j.Logger;
import utils.LoggerUtil;

import java.util.Map;

import static io.restassured.config.HttpClientConfig.httpClientConfig;
import static io.restassured.config.SSLConfig.sslConfig;
import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static io.restassured.config.LogConfig.logConfig;

public class RestApiClient {

    protected static final Logger LOGGER = LoggerUtil.getInstance();

    public RestApiClient() {
        config = config.decoderConfig(new DecoderConfig("UTF-8"))
                .encoderConfig(new EncoderConfig("UTF-8", "UTF-8"))
                .and().sslConfig(sslConfig().relaxedHTTPSValidation())
                .and().httpClient(httpClientConfig()
                        .setParam("http.connection.timeout", 10 * 60 * 1000)
                        .setParam("http.socket.timeout", 10 * 60 * 1000)
                        .setParam("http.socket.keepalive", true))
                .and().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails())
                .and().redirect(new RedirectConfig().followRedirects(false));
    }

    public ValidatableResponse executeGetRequest(String requestUrl, Map<String, String> headers) {
        return given()
                .headers(headers)
                .when()
                .get(requestUrl)
                .then();
    }

    public ValidatableResponse executeGetRequest(String requestUrl) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(requestUrl)
                .then();
    }
}
