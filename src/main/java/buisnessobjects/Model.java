package buisnessobjects;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Model {

    private String complect_path;
    private String brand_path;
    private String complect_name;
    private String complect_add;
    private String year;
    private String brand_name;
    private String key;

    public Model() {
    }

    public String getComplect_path() {
        return complect_path;
    }

    public void setComplect_path(String complect_path) {
        this.complect_path = complect_path;
    }

    public String getComplect_name() {
        return complect_name;
    }

    public void setComplect_name(String complect_name) {
        this.complect_name = complect_name;
    }

    public String getComplect_add() {
        return complect_add;
    }

    public void setComplect_add(String complect_add) {
        this.complect_add = complect_add;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getBrand_path() {
        return brand_path;
    }

    public void setBrand_path(String brand_path) {
        this.brand_path = brand_path;
    }
}
