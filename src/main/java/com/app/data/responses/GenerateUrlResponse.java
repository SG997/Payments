package com.app.data.responses;

public class GenerateUrlResponse {

    String url;
    String processId;

    public GenerateUrlResponse(String url, String processId) {
        this.url = url;
        this.processId = processId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }
}
