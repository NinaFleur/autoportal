package api;


import buisnessobjects.City;
import buisnessobjects.Model;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.restassured.response.ValidatableResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static api.ApiEndpoints.AP_CAR_MODELS;
import static api.ApiEndpoints.AP_CITIES;

public class RestApiExecutor extends RestApiClient {

    public static RestApiExecutor getInstance() {
        return new RestApiExecutor();
    }

    public ValidatableResponse getCitiesDocsResponse() {
        return executeGetRequest(AP_CITIES);
    }

    public List<City> getCitiesDocs() {
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

    public void getCityArrayByIndex(int index) {
        getCitiesDocs().get(index);
        System.out.println("This is an array with City data " + getCitiesDocs().get(index));
    }

    public ValidatableResponse getModelsDocsResponse() {
        LOGGER.info("Get 200 Model API response");
        return executeGetRequest(AP_CAR_MODELS);
    }

    public List<Model> getModelsDocs() {
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

    public Model getModelByIndex(int index) {
        System.out.println("This is an array with Model data " + getModelsDocs().get(index));
        return getModelsDocs().get(index);
    }

    public Model getModelByName(String name) {
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


}


