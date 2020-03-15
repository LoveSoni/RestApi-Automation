package Utilities;

import org.json.simple.JSONObject;

import java.util.Map;

public class Api {
    private String httpMethod;

    private String baseUrl;

    private Map<String,String> queryParams;

    private Map<String,String> headers;

    private JSONObject requestJson;

    public Api(String httpMethod, String baseUrl, Map<String, String> queryParams, Map<String, String> headers, JSONObject requestJson) {
        this.httpMethod = httpMethod;
        this.baseUrl = baseUrl;
        this.queryParams = queryParams;
        this.headers = headers;
        this.requestJson = requestJson;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(Map<String, String> queryParams) {
        this.queryParams = queryParams;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public JSONObject getRequestJson() {
        return requestJson;
    }

    public void setRequestJson(JSONObject requestJson) {
        this.requestJson = requestJson;
    }
}
