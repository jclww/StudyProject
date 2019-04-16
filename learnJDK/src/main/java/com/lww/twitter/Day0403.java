package com.lww.twitter;

public class Day0403 {
    public static void main(String[] args) {
        CharSequence A = "21";
        String B = "21".substring(0);
        System.out.println(B == A);
    }

    /**
     * Returns true if one string is rotation of another, nulls are not
     * considered rotation of each other
     * eg:
     * abcd => dabc
     *
     * @param str
     * @param rotated
     * @return true if rotated is rotation of String str
     */
    public static boolean isRotatedVersion(String str, String rotated) {
        boolean isRotated = false;

        if (str == null || rotated == null) {
            return false;

        } else if (str.length() != rotated.length()) {
            isRotated = false;

        } else {
            String concatenated = str + str;
            isRotated = concatenated.contains(rotated);
        }

        return isRotated;
    }


    /**
     * Return true if rotated is rotation of input String
     *
     * @param input
     * @param rotated
     * @return true if one String is rotation of other
     */
    public static boolean isRotated(String input, String rotated) {

        if (input == null || rotated == null) {
            return false;

        } else if (input.length() != rotated.length()) {
            return false;

        }

        int index = rotated.indexOf(input.charAt(0));
        if (index > -1) {

            if (input.equalsIgnoreCase(rotated)) {
                return true;
            }

            int finalPos = rotated.length() - index;
            return rotated.charAt(0) == input.charAt(finalPos)
                    && input.substring(finalPos).equals(
                    rotated.substring(0, index));
        }
        return false;

    }
}
