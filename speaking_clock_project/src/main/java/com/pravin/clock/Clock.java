package com.pravin.clock;

/**
 * Clock class 
 * 
 * @author pravin.dilpak
 * @since 05-07-2023
 *
 */
public class Clock 
{
	private final int hours;
    private final int minutes;
    private String result;

    private static final String[] TENS = {
            "oh ", "", "twenty ", "thirty ", "forty ", "fifty "
    };

    private static final String[] ONES = {
            "twelve ", "one ", "two ", "three ", "four ", "five ",
            "six ", "seven ", "eight ", "nine ", "ten ", "eleven ",
            "twelve ", "thirteen ", "fourteen ", "fifteen ",
            "sixteen ", "seventeen ", "eighteen ", "nineteen "
    };

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    /**
     *
     * @param  hour the initial string hour entered.
     */
    public Clock(String hour) {

        try {
            hour.trim().split(":");
        } catch (NumberFormatException e) {
            throw new NumberFormatException("You need to pass a valid 24 hour format hour");
        }

        String[] hours = hour.trim().split(":");

        try {
            Integer.parseInt(hours[0]);
            Integer.parseInt(hours[1]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("You need to pass a valid 24 hour format hour");
        }

        this.hours = Integer.parseInt(hours[0]);
        this.minutes = Integer.parseInt(hours[1]);
        this.result = "";
    }

    /**
     * Calls the method {@link #convertToWords} in order to convert the {@code int}
     * hours and minute and prints it in words.
     */
    public void displayTime() {

        String hourInWords = convertToWords(this.getHours(), this.getMinutes());

        if (hourInWords.equals("")) {
            System.out.println("It was not possible to convert the hour passed to words");
        } else {
            this.setResult(hourInWords);
            printResult();
        }
    }

    /**
     * Converts given hour and minutes to a hour in words.
     *
     * @param hour      hour
     * @param minutes   minutes
     * @return          hour
     */
    private String convertToWords(int hour, int minutes) {

        StringBuilder result = new StringBuilder();

        if (this.getMinutes() == 0) {

            if (this.getHours() == 12) {
                return result.append("It's Midday").toString();
            }

            if (this.getHours() == 24) {
                return result.append("It's Midnight").toString();
            }

            result.append("It's ").append(ONES[hour % 12]);

        } else if (minutes % 10 == 0) {
            result.append("It's ").append(ONES[hour % 12]).append(TENS[minutes / 10]);
        } else if (minutes < 10 || minutes > 20) {
            result.append("It's ").append(ONES[hour % 12]).append(TENS[minutes / 10]).append(ONES[minutes % 10]);
        } else {
            // minutes > 10 && minutes < 20
            result.append("It's ").append(ONES[hour % 12]).append(ONES[minutes]);
        }

        return result.toString();
    }

    /**
     * Prints the result of Clock.
     */
    private void printResult() {
        System.out.println(this.getResult());
    }
}
