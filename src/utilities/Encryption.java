package utilities;

import java.io.*;
import java.security.*;

/**
 *
 * @author nieschri125
 * @info correct hash for "test" is : A94A8FE5CCB19BA61C4C0873D391E987982FBBD3
 * @purpose To generate a hash from a given password.
 *
 */
public class Encryption {

    public static void main(String arg[]) {
        try {
            System.out.print("Please enter your password: ");
            String pass = Keyboard.readString();
            String hash = makeHash(pass);
            System.out.println("The computed hash is: " + hash);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // compute hash
    public static String makeHash(String password) throws UnsupportedEncodingException, Exception {
        String input = password;
        String hash = byteArrayToHexString(computeHash(input));
        return hash;
    }

    /*
     * convert string to hex
     * 
    public String toHex(String arg) throws UnsupportedEncodingException {
    return String.format("%x", new BigInteger(arg.getBytes("ASCII")));
    }
     */
    // convert sha1 bytes to hex string
    private static String byteArrayToHexString(byte[] b) {
        StringBuffer sb = new StringBuffer(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            int v = b[i] & 0xff;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString().toUpperCase();
    }

    // make sha1 encrypted hash of password
    private static byte[] computeHash(String x) throws Exception {
        MessageDigest d = null;
        d = MessageDigest.getInstance("SHA-1");
        d.reset();
        d.update(x.getBytes());
        return d.digest();
    }
}
