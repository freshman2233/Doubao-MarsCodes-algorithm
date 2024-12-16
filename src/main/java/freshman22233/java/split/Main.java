package freshman22233.java.split;

/**
 * Java String split() Method with Examples
 * In Java, the string split() method is used to split a string
 * into an array of substrings
 * based on matches of the given regular expression or specified delimiter.
 * This method returns a string array containing the required substring.
 *
 * Example: Here, we will Split a String having multiple delimiters or regex into an array of Strings.
 *split( String regex, int limit)
 *     limit > 0: Splits up to limit-1 times, with the rest in the last element.
 *     limit < 0: Splits as many times as possible.
 *     limit = 0: Splits as many times as possible but discards trailing empty strings.
 */
public class Main {
    public static void main(String[] args) {


        // input string having spaces, comma etc.
        String s = "This is,comma.fullstop  whitespace";

        // The regex [,\\.\\s] splits the string by
        // commas (,), spaces (\\s), and periods (\\.)
        String regex = "[,\\s\\.]";

        // using split() method
        String[] arr = s.split(regex);

        // Print each element of the resulting array
        for (String s1 : arr) {
            System.out.println(s1);
        }



        // Custom input string
        String s1 = "geeks@for@geeks";

        // taking small limit 2-1 = 1
        String[] arr1 = s.split("@", 2);

        for (String a : arr1)
            System.out.println(a);
    }
}

