package vn.edu.likelion.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormat {
    public static final String PATTERN = "yyyy-MM-dd";
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(PATTERN);

    /**
     * Parses a string representing a date into a LocalDate object using the provided DateTimeFormatter.
     * PATTERN: yyyy-MM-dd
     *
     * @param date The string containing the date to be parsed.
     *             It should match the format specified by the DateTimeFormatter.
     * @return A LocalDate object parsed from the input string.
     * @throws DateTimeParseException If the input string cannot be parsed into a valid LocalDate
     *                                according to the DateTimeFormatter's format.
     */
    public static LocalDate parseStringToLocalDate(String date) {
        try {
            return LocalDate.from(dateTimeFormatter.parse(date));
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Failed to parse date string: " + date, e);
        }
    }
}
