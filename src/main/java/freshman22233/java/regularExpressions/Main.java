package freshman22233.java.regularExpressions;

import java.util.regex.Pattern;

/**
 * Regular Expressions in Java
 * Regular Expressions or Regex (in short) in Java
 * is an API for defining String patterns
 * that can be used for
 * searching, manipulating, and editing a string in Java.
 * Email validation and passwords are a few areas of strings
 * where Regex is widely used to define the constraints.
 * Regular Expressions in Java are provided under java.util.regex package.
 * https://www.geeksforgeeks.org/regular-expressions-in-java/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Pattern.matches("geekforge*ks","geekforgeeks"));
    }
}
