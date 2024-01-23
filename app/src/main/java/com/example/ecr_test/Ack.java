package com.example.ecr_test;

import java.io.ByteArrayOutputStream;
import java.util.Map;

public class Ack extends ECRResponse {

    public Ack(byte status) {
        Map map = getHashMap();
        map.put(INDEX_RESPONSE_CODE, new byte[]{status});
        build(map);
    }

    @Override
    protected void build(Map data) {
        try {
            // STX, ETX
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            os.write(STX);
            os.write(TXN_TYPE_ENQUIRY);
            os.write((byte[]) data.get(ECR_STATUS));
            os.write(ETX);
            this.data = os.toByteArray();
        } catch (Exception e) {
            // TODO :
            System.out.print(e.toString());
        }
    }
}
