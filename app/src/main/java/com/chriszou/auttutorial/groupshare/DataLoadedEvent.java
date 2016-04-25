package com.chriszou.auttutorial.groupshare;

/**
 * Created by xiaochuang on 4/25/16.
 */
public class DataLoadedEvent {

    private final int code;
    private final Object data;
    private final String errorMsg;

    public DataLoadedEvent(int code, Object data, String errorMsg) {
        this.code = code;
        this.data = data;
        this.errorMsg = errorMsg;
    }

    public DataLoadedEvent(Object data) {
        this(200, data, null);
    }

    public DataLoadedEvent(int code, String msg) {
        this(code, null, msg);
    }

    public boolean successful() {
        return true;
    }
}
