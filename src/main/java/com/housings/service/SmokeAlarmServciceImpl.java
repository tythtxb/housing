package com.housings.service;

import com.housings.dao.SmokeAlarmDao;
import com.housings.pojo.SmokeAlarm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmokeAlarmServciceImpl implements SmokeAlarmService{
    @Autowired
    private SmokeAlarmDao smokeAlarmDao;

    @Override
    public int countItem(SmokeAlarm smokeAlarm) {
        return smokeAlarmDao.countItem(smokeAlarm);
    }

    @Override
    public List<SmokeAlarm> queryAll(SmokeAlarm smokeAlarm) {
        return smokeAlarmDao.queryAll(smokeAlarm);
    }

    @Override
    public SmokeAlarm findById(SmokeAlarm smokeAlarm) {
        return smokeAlarmDao.findById(smokeAlarm);
    }

    @Override
    public void insert(SmokeAlarm smokeAlarm) {
        smokeAlarmDao.insert(smokeAlarm);
    }
    @Override
    public void update(SmokeAlarm smokeAlarm) {
        smokeAlarmDao.update(smokeAlarm);
    }
    @Override
    public void delete(SmokeAlarm smokeAlarm) {
        smokeAlarmDao.delete(smokeAlarm);
    }
}
