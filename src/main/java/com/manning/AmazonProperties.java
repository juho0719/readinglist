package com.manning;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by juho on 2017. 8. 2..
 */

@Component
@ConfigurationProperties("amazon")
public class AmazonProperties {

    private String associateId;

    public void setAssociateId(String associateId) {
        this.associateId=associateId;
    }

    public String getAssociateId() {
        return associateId;
    }

}
