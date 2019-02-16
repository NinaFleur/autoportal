package buisnessobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Models {

    List<Model> docs;

    public List<Model> getModelsDocs() {
        return docs;
    }
}
