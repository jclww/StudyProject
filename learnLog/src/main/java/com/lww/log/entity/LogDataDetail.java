package com.lww.log.entity;

import com.lww.log.LogError;
import lombok.Data;

@Data
public class LogDataDetail {

    private LogError error;
    private Object extra;
    private String logStatisticsField;

}
