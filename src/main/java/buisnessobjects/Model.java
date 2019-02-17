package buisnessobjects;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Model {

    private String brand_path;
    private String complect_path;
    private String brand_name;
    private String complect_name;
    private String complect_add;
    private String year;
    private String key;
    private int price_min;
    private int price_max;
    private String image;

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

    public int getPrice_min() {
        return price_min;
    }

    public void setPrice_min(int price_min) {
        this.price_min = price_min;
    }

    public int getPrice_max() {
        return price_max;
    }

    public void setPrice_max(int price_max) {
        this.price_max = price_max;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFullModelName () {
        return brand_name + " " + complect_name;
    }
}
