package main;

public class BitConverter {
    public static byte[] getBytes(boolean x) {

        return new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) (x ? 1 : 0)};
    }

    public static byte[] getBytes(char c) {
        return new byte[]{(byte) (c & 0xff), (byte) (c >> 8 & 0xff)};
    }

    public static byte[] getBytes(double x) {
        return getBytes(Double.doubleToRawLongBits(x));
    }

    public static byte[] getBytes(short x) {
        return new byte[]{(byte) (x >>> 8), (byte) x};
    }

    public static byte[] getBytes(int x) {
        return new byte[]{(byte) (x >>> 24), (byte) (x >>> 16),
                (byte) (x >>> 8), (byte) x};
    }

    public static byte[] getBytes(long x) {
        return new byte[]{(byte) (x >>> 56), (byte) (x >>> 48),
                (byte) (x >>> 40), (byte) (x >>> 32), (byte) (x >>> 24),
                (byte) (x >>> 16), (byte) (x >>> 8), (byte) x};
    }

    public static byte[] getBytes(float x) {
        return getBytes(Float.floatToRawIntBits(x));
    }

    public static byte[] getBytes(String x) {
        return x.getBytes();
    }

    public static long doubleToInt64Bits(double x) {
        return Double.doubleToRawLongBits(x);
    }

    public static double int64BitsToDouble(long x) {
        return (double) x;
    }

    public static boolean toBoolean(byte[] bytes) throws Exception {
        boolean f = false;
        if (bytes.length != 8) {
            throw new Exception(
                    "The length of the byte array must be at least 1 byte long.");
        } else {
            int i;
            for (i = 0; i < bytes.length; ++i) {
                if (i < (bytes.length - 1) && bytes[i] != 0) {
                    throw new Exception(
                            "The length of the byte array must be at least 1 byte long.");
                }
                if (i == bytes.length - 1) {
                    if (bytes[i] == 1) {
                        f = true;
                    }
                } else {
                    f = false;
                }

            }
        }
        return f;
    }

    public char toChar(byte[] bytes, int index) throws Exception {
        if (bytes.length != 2)
            throw new Exception(
                    "The length of the byte array must be at least 2 bytes long.");
        return (char) ((0xff & bytes[index]) << 8 | (0xff & bytes[index + 1]) << 0);
    }

}