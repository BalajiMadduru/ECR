package com.example.ecr_test;

import java.util.HashMap;
import java.util.Map;

public interface ECRConstants {
    byte STX = 0x02;
    byte ETX = 0x03;

    byte TXN_TYPE_ENQUIRY = 0x00;
    byte TXN_TYPE_SALE = 0x01;
    byte TXN_TYPE_VOID = 0x02;
    byte TXN_TYPE_REFUND = 0x03;

    // data indexes
    Integer ECR_STATUS = 1;

    // cmd index
    int OFFSET_STX = 0;
    int OFFSET_TXN_TYPE = 1;
    int OFFSET_SALE_AMOUNT = 2;

    // response cmd index
    int INDEX_RESPONSE_CODE = 1;


    // status codes
    byte STATUS_SUCCESS = 0x00;
    byte STATUS_INVALID_CMD = 0x01;

    default Map getHashMap() {
        return new HashMap<Integer, byte[]>();
    }
}
