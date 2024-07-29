package vn.edu.likelion.project.day19072024.helper;

import java.util.Base64;

public class Encode {

    public static String encode(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    public static String decode(String str) {
        return new String(Base64.getDecoder().decode(str));
    }
}
