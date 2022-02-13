package com.app.data.meshulam;

public class Data {

    long processId;
    String processToken;
    String url;

    public Data() {
    }

    public Data(long processId, String processToken, String url) {
        this.processId = processId;
        this.processToken = processToken;
        this.url = url;
    }

    public long getProcessId() {
        return processId;
    }

    public void setProcessId(long processId) {
        this.processId = processId;
    }

    public String getProcessToken() {
        return processToken;
    }

    public void setProcessToken(String processToken) {
        this.processToken = processToken;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
