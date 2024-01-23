package com.example.ecr_test;

public class Main {

    public static void main(String[] args) {
        String cmd = "020100001000000003";
        try {
            ECRRequest request = ECRRequest.fromBytes(hexStringToByteArray(cmd));
            if (request != null) {
                ECRResponse response = request.process();
                if (response != null) {
                    System.out.println(byteArrayToHexString(response.getData()));
                } else {
                    System.out.println("The response is null");
                }
            } else {
                System.out.println("Failed to create ECRRequest from the command");
            }
        } catch (InvalidRequestException e) {
            System.out.println("Invalid Request: " + e.getMessage());
        }
    }

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static String byteArrayToHexString(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
}
