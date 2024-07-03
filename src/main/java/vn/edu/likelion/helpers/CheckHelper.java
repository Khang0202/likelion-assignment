package vn.edu.likelion.helpers;

import java.time.LocalDate;

public class CheckHelper {
    public static String checkString(String str) {
        if (str == null || str.isEmpty()) {
            throw new RuntimeException("String can not be null or empty");
        } else {
            return str;
        }
    }

    public static boolean checkLocalDateIsAfter(LocalDate localDate) {
        if (localDate == null) {
            throw new RuntimeException("Date input can not be null");
        } else if (localDate.isAfter(LocalDate.now())) {
            return true;
        } else {
            throw new RuntimeException("Date input must be after now");
        }
    }

    public static boolean checkLocalDateIsBefore(LocalDate localDate) {
        if (localDate == null) {
            throw new RuntimeException("Date input can not be null");
        } else if (localDate.isBefore(LocalDate.now())) {
            return true;
        } else {
            throw new RuntimeException("Date input must be before now");
        }
    }

    public static boolean checkStringIsNumberic(String str){
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new RuntimeException("String is not numeric");
            }
        }
        return true;
    }
}
