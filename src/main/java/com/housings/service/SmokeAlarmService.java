package com.housings.service;

import com.housings.pojo.SmokeAlarm;

import java.util.List;

public interface SmokeAlarmService {
    int countItem(SmokeAlarm smokeAlarm);

    List<SmokeAlarm> queryAll(SmokeAlarm smokeAlarm);

    SmokeAlarm findById(SmokeAlarm smokeAlarm);

    void insert(SmokeAlarm smokeAlarm);

    void update(SmokeAlarm smokeAlarm);

    void delete(SmokeAlarm smokeAlarm);
}
