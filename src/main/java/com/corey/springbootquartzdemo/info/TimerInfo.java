package com.corey.springbootquartzdemo.info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TimerInfo {

    private int totalFireCount;
    private boolean runForever;
    private long repeatIntervalMs;
    private long initialOffSetMs;
    private String callBackData;
    
}
