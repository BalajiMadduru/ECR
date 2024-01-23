package com.example.ecr_test;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Map;

public class SaleResponse extends ECRResponse {
    public SaleResponse(float amount) {
        Map map = getHashMap();
        byte[] amountBytes = ByteBuffer.allocate(4).putFloat(amount).array();
        map.put(OFFSET_SALE_AMOUNT,amountBytes);
        map.put(INDEX_RESPONSE_CODE,new byte[]{0x00,0x00});
        try {
            build(map);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void build(Map data) throws Exception {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            os.write(STX);
            os.write(TXN_TYPE_SALE);
            os.write((byte[]) data.get(OFFSET_SALE_AMOUNT));
            os.write((byte[]) data.get(INDEX_RESPONSE_CODE));
            os.write(ETX);
            this.data = os.toByteArray();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }
}
