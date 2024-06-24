package vn.edu.likelion.assignment.helpers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeFormat {
    public static final String PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(PATTERN);

    /**
     * Parses a string representing a date into a LocalDate object using the provided DateTimeFormatter.
     * PATTERN: yyyy-MM-dd HH:mm:ss
     * @param date The string containing the date to be parsed.
     *             It should match the format specified by the DateTimeFormatter.
     * @return A LocalDate object parsed from the input string.
     * @throws DateTimeParseException If the input string cannot be parsed into a valid LocalDate
     *                          according to the DateTimeFormatter's format.
     */
    public static LocalDate parseStringToLocalDate(String date) {
        try {
            return LocalDate.from(dateTimeFormatter.parse(date));
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Failed to parse date string: " + date, e);
        }
    }

    /**
     * Parses a string representing a date and time into a LocalDateTime object using the provided DateTimeFormatter.
     * PATTERN: yyyy-MM-dd HH:mm:ss
     * @param date The string containing the date and time to be parsed.
     *             It should match the format specified by the DateTimeFormatter.
     * @return A LocalDateTime object parsed from the input string.
     * @throws DateTimeParseException If the input string cannot be parsed into a valid LocalDateTime
     *                          according to the DateTimeFormatter's format.
     */
    public static LocalDateTime parseStringToLocalDateTime(String date) {
        try {
            return LocalDateTime.from(dateTimeFormatter.parse(date));
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Failed to parse date and time string: " + date, e);
        }
    }






}
