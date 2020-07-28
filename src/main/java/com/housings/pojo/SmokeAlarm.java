package com.housings.pojo;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SmokeAlarm extends BaseObject {
    private Integer id;
    private String installDate;
    private String saAddress;
    private String userId;
    private String detectionDate;
    private String smokeConcentration;
    private String detectionDesc; //上次自检详细情况

}
