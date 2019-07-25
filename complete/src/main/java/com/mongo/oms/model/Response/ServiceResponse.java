package com.mongo.oms.model.Response;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

public class ServiceResponse<T> implements Serializable {
    private HttpStatus status;
    private List<String> error;
    private T payload;

    public ServiceResponse() {
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public List<String> getError() {
        return this.error;
    }

    public T getPayload() {
        return this.payload;
    }

    public void setStatus(final HttpStatus status) {
        this.status = status;
    }

    public void setError(final List<String> error) {
        this.error = error;
    }

    public void setPayload(final T payload) {
        this.payload = payload;
    }
}