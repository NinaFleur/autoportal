package api;


import buisnessobjects.City;
import buisnessobjects.Model;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static api.ApiEndpoints.*;

public class RestApiExecutor extends RestApiClient {

    public static RestApiExecutor getInstance() {
        return new RestApiExecutor();
    }

    @Step("Execute GET request to the All_CITIES API")
    public ValidatableResponse getCitiesDocsResponse() {
        LOGGER.info("Execute GET request to the All_CITIES API");
        return executeGetRequest(AP_CITIES);
    }

    public List<City> getCitiesDocs() {
        LOGGER.info("Get all the data in the \"docs\" array from the All_CITIES API");
        String apiEndpoint = AP_CITIES;
        ValidatableResponse response = executeGetRequest(apiEndpoint).statusCode(200);
        List<City> docs = new ArrayList<>();

        //Option 2: JsonObject and Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        JSONObject json = new JSONObject(response.extract().body().asString());
        JSONArray jsonArray = json.getJSONObject("response").getJSONArray("docs");
        String jsonResponseAsString = jsonArray.toString();

        try {
            docs = objectMapper.readValue(jsonResponseAsString, objectMapper.getTypeFactory().constructCollectionType(List.class, City.class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return docs;

        //Option 1
        // docs = response.extract().body().as(Response.class).getResponse().getDocs();
        //
        //
        // Option 3: JSONObject and GSON

//        JSONObject json = new JSONObject(response.extract().body().asString());
//        JSONArray jsonArray = json.getJSONObject("response").getJSONArray("docs");
//        String jsonResponseAsString = jsonArray.toString();
//        Gson googleJson = new Gson();
//        docs = Arrays.asList(googleJson.fromJson(jsonResponseAsString, City[].class));
//
//        return docs;
    }

    @Step("Get City data from the array by index")
    public void getCityArrayByIndex(int index) {
        LOGGER.info("Get City data from the array by index");
        getCitiesDocs().get(index);
    }

    @Step("Execute GET request for the ALL_MODELS API")
    public ValidatableResponse getModelsDocsResponse() {
        LOGGER.info("Execute GET request for the ALL_MODELS API");
        return executeGetRequest(AP_CAR_MODELS);
    }

    public List<Model> getModelsDocs() {
        LOGGER.info("Get all the data in the \"docs\" array from the ALL_MODELS API");
        String apiEndpoint = AP_CAR_MODELS;
        ValidatableResponse response = executeGetRequest(apiEndpoint).statusCode(200);
        List<Model> docs = new ArrayList<>();

        JSONObject json = new JSONObject(response.extract().body().asString());
        JSONArray jsonArray = json.getJSONObject("response").getJSONArray("docs");
        String jsonResponseAsString = jsonArray.toString();
        Gson googleJson = new Gson();
        docs = Arrays.asList(googleJson.fromJson(jsonResponseAsString, Model[].class));

        return docs;
    }

    @Step("Get Model data from the array by index")
    public Model getModelByIndex(int index) {
        LOGGER.info("Get Model data from the array by index");
        return getModelsDocs().get(index);
    }

    @Step("Get the Model data from the array by name")
    public Model getModelByName(String name) {
        LOGGER.info("Get the Model data in an array by name");
        List<Model> models = getModelsDocs();
        Model modelDoc = new Model();
        for (Model model : models) {
            if (model.getComplect_name().equals(name)) {
                modelDoc = model;
                break;
            }
        }
        return modelDoc;
    }

    @Step("Execute GET request to the Leads Count API")
    public ValidatableResponse getLeadsCount() {
        LOGGER.info("Hit the Leads Count API");
        return executeGetRequest(LEADS_COUNT);
    }
}


