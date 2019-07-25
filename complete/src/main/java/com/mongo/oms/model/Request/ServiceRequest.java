package com.mongo.oms.model.Request;

import java.io.Serializable;

public class ServiceRequest<T> implements Serializable {

    private T payload;

    public ServiceRequest() {
    }

    public T getPayload() {
        return this.payload;
    }

    public void setPayload(final T payload) {
        this.payload = payload;
    }
}