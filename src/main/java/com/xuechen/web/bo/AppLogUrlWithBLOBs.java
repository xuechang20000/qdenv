package com.xuechen.web.bo;

public class AppLogUrlWithBLOBs extends AppLogUrl {
    private String params;

    private String headers;

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers == null ? null : headers.trim();
    }
}