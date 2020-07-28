package com.housings.dao;

import com.housings.pojo.SmokeAlarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Repository
@Mapper
public interface SmokeAlarmDao {
    int countItem(SmokeAlarm smokeAlarm);

    List<SmokeAlarm> queryAll(SmokeAlarm smokeAlarm);

    SmokeAlarm findById(SmokeAlarm smokeAlarm);

    void insert(SmokeAlarm smokeAlarm);

    void update(SmokeAlarm smokeAlarm);

    void delete(SmokeAlarm smokeAlarm);
}
