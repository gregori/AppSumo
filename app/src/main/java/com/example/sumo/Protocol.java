package com.example.sumo;

public class Protocol {
    public static byte MOTOR_CONTROL = 1;
    public static byte SET_STRATEGY = 2;
    public static byte START_STOP_ROBOT = 3;
    public static byte SET_ATTAK = 4;
    public static byte SET_RECOVER = 5;
    public static byte SET_SEARCH = 6;


    public static byte[] intToByte(int value) {
        byte data[] = new byte[2];

        data[0] = (byte) (value & 0xff);
        data[1] = (byte) ((value >> 8) & 0xff);
        return data;
    }

    public static int map(int x, int in_min, int in_max, int out_min, int out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }
}