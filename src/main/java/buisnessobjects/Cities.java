package buisnessobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Cities {

    public List<City> docs;

    public List<City> getCitiesDocs() {
        return docs;
    }
}
