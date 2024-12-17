package freshman22233.greed.creativeTitleMatchingProblem;
import java.util.regex.*;

/**
 * Use regular expressions to simplify the code
 */
public class Main2 {
    public static String solution(int n, String template_, String[] titles) {
        // Convert the template into a regex
        String regex = templateToRegex(template_);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            boolean match = titles[i].matches(regex);
            sb.append(match ? "True" : "False");
            if (i < n - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private static String templateToRegex(String template) {
        // The wildcard pattern is { ... } with 0 or more chars inside
        // We'll split by these wildcards and replace each with (.*)

        // Use a regex to find occurrences of { ... }
        // We can do this by using a Matcher and building the pattern piece by piece.
        Pattern p = Pattern.compile("\\{[^}]*\\}");
        Matcher m = p.matcher(template);

        int lastEnd = 0;
        StringBuilder regex = new StringBuilder();
        while (m.find()) {
            // Append the literal segment before this wildcard
            String literal = template.substring(lastEnd, m.start());
            regex.append(Pattern.quote(literal));

            // Append the wildcard regex
            regex.append("(.*)");

            lastEnd = m.end();
        }

        // Append the trailing literal (after the last wildcard)
        String trailing = template.substring(lastEnd);
        regex.append(Pattern.quote(trailing));

        // The resulting regex will match the entire string from start to end when using matches()
        return regex.toString();
    }

    public static void main(String[] args) {
        String[] testTitles1 = {"adcdcefdfeffe", "adcdcefdfeff", "dcdcefdfeffe", "adcdcfe"};
        String[] testTitles2 = {"CLSomGhcQNvFuzENTAMLCqxBdj", "CLSomNvFuXTASzENTAMLCqxBdj", "CLSomFuXTASzExBdj", "CLSoQNvFuMLCqxBdj", "SovFuXTASzENTAMLCq", "mGhcQNvFuXTASzENTAMLCqx"};
        String[] testTitles3 = {"abcdefg", "abefg", "efg"};

        System.out.println(solution(4, "ad{xyz}cdc{y}f{x}e", testTitles1).equals("True,False,False,True"));
        System.out.println(solution(6, "{xxx}h{cQ}N{vF}u{XTA}S{NTA}MLCq{yyy}", testTitles2).equals("False,False,False,False,False,True"));
        System.out.println(solution(3, "a{bdc}efg", testTitles3).equals("True,True,False"));
    }
}
