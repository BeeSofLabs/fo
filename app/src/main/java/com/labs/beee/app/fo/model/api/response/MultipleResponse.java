package com.labs.beee.app.fo.model.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.labs.beee.app.fo.model.pojo.Article;
import com.labs.beee.app.fo.model.pojo.Source;

import java.util.List;


/**
 * Created by arysuryawan on 8/19/17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class MultipleResponse {

    private String status;
    private String source;
    private String sortBy;
    private List<Source> sources;
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }
}
