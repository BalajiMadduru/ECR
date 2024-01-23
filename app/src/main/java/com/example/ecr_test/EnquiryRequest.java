package com.example.ecr_test;
public class EnquiryRequest extends ECRRequest {

    public EnquiryRequest(byte[] cmd) {
        super(cmd);
    }

    @Override
    protected void parse(byte[] ecrCmd) {
        // Do nothing
    }

    @Override
    protected ECRResponse process() {
        // TODO :
        // DO terminal specific check and ack back
        return new Ack(STATUS_SUCCESS);
    }
}
