package buisnessobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class City {

    private String city_path;
    private String city;
    private String key;
    private String region_name;
    private String region_district_name;

    public City() {
    }

    public String getCity_path() {
        return city_path;
    }

    public void setCity_path(String city_path) {
        this.city_path = city_path;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public String getRegion_district_name() {
        return region_district_name;
    }

    public void setRegion_district_name(String region_district_name) {
        this.region_district_name = region_district_name;
    }

}