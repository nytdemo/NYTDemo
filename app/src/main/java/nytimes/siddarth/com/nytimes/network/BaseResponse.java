package nytimes.siddarth.com.nytimes.network;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import nytimes.siddarth.com.nytimes.model.NewsData;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse {


    private String status;



    public List<NewsData> getResults() {
        return results;
    }

    public void setResults(List<NewsData> results) {
        this.results = results;
    }

    @JsonProperty("results")
    private List<NewsData> results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
