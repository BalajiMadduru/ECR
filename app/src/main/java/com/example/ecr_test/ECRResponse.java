package com.example.ecr_test;

import java.util.Map;

public abstract class ECRResponse implements ECRConstants {

    protected byte[] data;

    abstract protected void build(Map data) throws Exception;

    byte[] getData() {
        return data;
    }
}
