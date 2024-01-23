package com.example.ecr_test;


import static com.example.ecr_test.Main.byteArrayToHexString;

import java.nio.ByteBuffer;

public  class SaleRequest extends ECRRequest {
   byte[] amount;
    public SaleRequest(byte[] cmd)  {
        super(cmd);
    }

    @Override
    protected void parse(byte[] ecrCmd) {

        byte[] amount = new byte[6];
        System.arraycopy(ecrCmd, OFFSET_SALE_AMOUNT, amount, 0, 6);
        System.out.println("Amount: " +  byteArrayToHexString(amount));
        this.amount = amount;
    }



    @Override
    protected ECRResponse process() {
        float parsedAmount = ByteBuffer.wrap(amount).getFloat();
        return new SaleResponse(parsedAmount);
    }
}