package com.topnews.service.model;

import java.util.List;

public class NewsResponse {

    public String status;
    public int totalResults;
    public String code;
    public String message;

    public List<Article> articles;
}