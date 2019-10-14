import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class TEST {

    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static void main(String[] args) {
        System.out.println("hello");

    }

    public static String formatDateString(long timeMillis, String pattern) {
        return formatDateString(new Date(timeMillis), pattern);
    }

    public static String formatDateString(Date date, String pattern) {
        String s = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            s = sdf.format(date);
        } catch (Exception e) {
        }
        return s;
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    public static byte[] hexStringToByteArray2(String input) {
        if (input.length() % 2 != 0) {
            System.out.println("hexStringToByteArray return null : " + input.length());
            return null;
        }
        byte[] result = new byte[input.length() / 2];
        for (int i = 0; i < input.length(); i += 2) {
            result[i / 2] = (byte) Integer.parseInt(input.substring(i, i + 2),
                    16);
        }
        return result;
    }

    private String getDataString(byte[] b, int offset, int length) {
        String s = null;
        try {
            byte[] data = new byte[length];
            System.arraycopy(b, offset, data, 0, length);

            s = new String(data, "utf-8");
        } catch (Exception e) {
        }
        return s;
    }
}
