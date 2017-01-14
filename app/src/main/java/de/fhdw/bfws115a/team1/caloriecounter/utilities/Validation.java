package de.fhdw.bfws115a.team1.caloriecounter.utilities;

public class Validation {

    /**
     * Checks if a string is larger than a defined integer value.
     *
     * @param maxLength The maximum length of the given string.
     * @param string    The given string which is checked.
     * @return 'False' if the string is larger than the maximum value. Returns 'true' if this is not.
     */
    public static boolean checkLenght(int maxLength, String string) {
        if (string.length() > maxLength) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks if an integer value is higher that 0. Returns 'false' if this is not true.
     *
     * @param numberValue The value of a number field.
     * @return 'True' if the number value is higher than 0. Returns 'false' if this is not true.
     */
    public static boolean checkNumberValue(int numberValue) {
        if (numberValue > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if an integer value is higher that 0. Returns 'false' if this is not true.
     *
     * @param numberValue The value of a number field.
     * @return 'True' if the number value is higher than 0. Returns 'false' if this is not true.
     */
    public static boolean checkNumberValue(double numberValue) {
        if (numberValue > 0.0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if a String is empty.
     *
     * @param string The String to check.
     * @return 'True' if the String is empty, respectively 'False' if the String is not empty.
     */
    public static boolean checkIfEmpty(String string) {
        if (string.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
}