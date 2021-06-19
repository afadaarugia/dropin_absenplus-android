package com.britech.absendulu.model.bixbox;

import com.google.gson.annotations.SerializedName;

public class Mobile {

    @SerializedName("msisdn")
    String msisdn;

    @SerializedName("content")
    String content;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
