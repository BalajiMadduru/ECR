package com.example.ecr_test;

import java.nio.ByteBuffer;

public abstract class ECRRequest implements ECRConstants {

    private byte[] data;

    private byte txnType;

    public ECRRequest(byte[] cmd) {
        txnType = cmd[OFFSET_TXN_TYPE];
        parse(cmd);
    }

    abstract protected void parse(byte[] ecrCmd);

    abstract protected ECRResponse process();

    public byte[] getData(byte txnTypeSale) {
        return data;
    }

    boolean isEnquiry() {
        return txnType == TXN_TYPE_ENQUIRY ? true : false;
    }

    boolean isSale() {
        return txnType == TXN_TYPE_SALE ? true : false;
    }

    boolean isVoid() {
        return txnType == TXN_TYPE_VOID ? true : false;
    }

    boolean isRefund() {
        return txnType == TXN_TYPE_REFUND ? true : false;
    }

    public static ECRRequest fromBytes(byte[] cmd) throws InvalidRequestException {
        ByteBuffer bf = ByteBuffer.wrap(cmd);

        if (bf.get(OFFSET_STX) != STX) {
            throw new InvalidRequestException("Invalid Command");
        }

        if (bf.get(bf.limit() - 1) != ETX) {
            throw new InvalidRequestException("Invalid Command");
        }

        // extract txn type
        byte txnType = bf.get(OFFSET_TXN_TYPE);

        if (txnType == TXN_TYPE_ENQUIRY) {
            return new EnquiryRequest(cmd);
        } else if (txnType == TXN_TYPE_SALE) {
            return new SaleRequest(cmd);
        } else if (txnType == TXN_TYPE_VOID) {
            // TODO :
        } else if (txnType == TXN_TYPE_REFUND) {
            // TODO :
        }

        throw new InvalidRequestException("Invalid Txn Type");
    }
}
