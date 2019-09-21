package cn.edu.kust.medium;

import java.util.Arrays;

/**
 * 393. UTF-8 Validation
 * pass
 */
public class ValidUTF8 {

    int byte1 = 0x80;
    int byte2 = 0xE0C0;
    int byte3 = 0xF0C0C0;
    int byte4 = 0xF8C0C0C0;

    public boolean validUtf8(int[] data) {
        if (data ==null || data.length == 0) {
            return true;
        }

        if ((data[0] & 0xFFFFFFF8) == 0xF0) {
            if (data.length < 4) {
                return false;
            }
            int utfChar = data[0];
            utfChar = (utfChar << 8) + data[1];
            utfChar = (utfChar << 8) + data[2];
            utfChar = (utfChar << 8) + data[3];
            return is4ByteChar(utfChar) && validUtf8(Arrays.copyOfRange(data, 4, data.length));
        }

        if ((data[0] & 0xFFFFFFF0) == 0xE0) {
            if (data.length < 3) {
                return false;
            }

            int utfChar = data[0];
            utfChar = (utfChar << 8) + data[1];
            utfChar = (utfChar << 8) + data[2];
            return is3ByteChar(utfChar) && validUtf8(Arrays.copyOfRange(data, 3, data.length));
        }

        if ((data[0] & 0xFFFFFFE0) == 0xC0) {
            if (data.length < 2) {
                return false;
            }

            int utfChar = data[0];
            utfChar = (utfChar << 8) + data[1];
            return is2ByteChar(utfChar) && validUtf8(Arrays.copyOfRange(data, 2, data.length));
        }

        return is1ByteChar(data[0]) && validUtf8(Arrays.copyOfRange(data, 1, data.length));
    }

    private boolean is1ByteChar(int utfChar) {
        if (utfChar > 0x7F) {
            return false;
        }

        if ((utfChar & byte1) == 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean is2ByteChar(int utfChar) {
        if (utfChar < 0x80 && utfChar > 0x7FF) {
            return false;
        }

        if ((utfChar & byte2) == 0xC080) {
            return true;
        } else {
            return false;
        }
    }

    private boolean is3ByteChar(int utfChar) {
        if (utfChar < 0x800 && utfChar > 0xFFFF) {
            return false;
        }

        if ((utfChar & byte3) == 0xE08080) {
            return true;
        } else {
            return false;
        }
    }

    private boolean is4ByteChar(int utfChar) {
        if (utfChar < 0x10000 && utfChar > 0x10FFFF) {
            return false;
        }

        if ((utfChar & byte4) == 0xF0808080) {
            return true;
        } else {
            return false;
        }
    }
}
