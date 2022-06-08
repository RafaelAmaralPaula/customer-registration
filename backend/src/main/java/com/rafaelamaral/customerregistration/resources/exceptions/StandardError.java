package com.rafaelamaral.customerregistration.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {
    private static final Long serialVersionUID = 1L;

    private Instant timesStamp;

    private Integer status;

    private String error;

    private String message;

    private String path;

    public StandardError(){}

    public StandardError(Instant timesStamp, Integer status, String error, String message, String path) {
        this.timesStamp = timesStamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Instant getTimesStamp() {
        return timesStamp;
    }

    public void setTimesStamp(Instant timesStamp) {
        this.timesStamp = timesStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
