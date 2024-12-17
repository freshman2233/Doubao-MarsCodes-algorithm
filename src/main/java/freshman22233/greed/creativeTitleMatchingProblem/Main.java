package freshman22233.greed.creativeTitleMatchingProblem;

/**
 * 7.creative Title Matching Problem
 *
 * In the advertising platform,
 * in order to give advertisers
 * a certain degree of freedom and efficiency,
 * advertisers are allowed to submit creative ideas
 * in the form of wildcards when creating titles.
 *
 * When serving online,
 * wildcards in creatives
 * (wildcards are strings enclosed by pairs of {},
 * which can contain 0 or more characters)
 * will be replaced based on the bidword triggered
 * by the user's search terms to improve advertising.
 *
 * Deliver experience.
 * For example: "{Doomsday Bloody War}
 * will be released online to give away SSR heroes,
 * and you can assemble an invincible lineup in three days!"
 * will be replaced by
 * "The Age of Empires game
 * will be released online to give away SSR heroes,
 * and you can assemble an invincible lineup in three days!".
 * Given a creative idea containing wildcards and n titles,
 * determine whether this title is generated
 * from the creative replacement.
 */
public class Main {
    public static String solution(int n, String template_, String[] titles) {
        // Parse the template into a list of segments: literals and wildcards
        Pattern pattern = parseTemplate(template_);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            boolean match = matchTitle(pattern, titles[i]);
            sb.append(match ? "True" : "False");
            if (i < n - 1) sb.append(",");
        }
        return sb.toString();
    }

    private static class Pattern{
        //e.g. ["ad", null, "cdc", null, "f", null, "e"] where null indicates wildcard.
        String[] literals;
        boolean startsWithWildcard;
        boolean endsWithWildcard;
        int wildcardCount;
    }

    private static Pattern parseTemplate(String template) {
        /**
         * Scan template character by character
         * Extract literal segment and count how many wildcards
         * We'll have a sequence
         */
        StringBuilder currentLiteral = new StringBuilder();
        java.util.List<String> literalList = new java.util.ArrayList<>();
        int wildcardCount = 0;

        boolean insiderBraces = false;
        for (int i = 0; i < template.length(); i++) {
            char c = template.charAt(i);
            if (c == '{') {
                //start wildcard
                if (!insiderBraces) {
                    literalList.add(currentLiteral.toString());
                    currentLiteral.setLength(0);
                }
                insiderBraces = true;
            } else if (c == '}') {
                //end wildcard
                insiderBraces = false;
                wildcardCount++;
            } else {
                if (!insiderBraces) {
                    currentLiteral.append(c);
                }
            }
        }

        if (!insiderBraces){
            literalList.add(currentLiteral.toString());
        }

        Pattern pattern = new Pattern();
        pattern.literals = literalList.toArray(new String[0]);
        pattern.wildcardCount = wildcardCount;
        pattern.startsWithWildcard = template.charAt(0) == '{';
        pattern.endsWithWildcard = template.charAt(template.length() - 1) == '}';
        return pattern;
    }

    private static boolean matchTitle(Pattern pattern, String candidate) {
        String[] literals = pattern.literals;
        int literalCount = literals.length;
        int pos = 0; // current position in candidate

        // Match all but the last literal normally:
        for (int i = 0; i < literalCount - 1; i++) {
            String lit = literals[i];
            if (i == 0 && !pattern.startsWithWildcard) {
                // The candidate must start with this literal
                if (!candidate.startsWith(lit)) {
                    return false;
                }
                pos = lit.length();
            } else {
                // There's a wildcard before this literal
                // Find this literal after pos
                if (!lit.isEmpty()) {
                    int idx = candidate.indexOf(lit, pos);
                    if (idx == -1) {
                        return false; // can't find next literal
                    }
                    pos = idx + lit.length();
                }
                // If lit is empty, just continue; wildcard absorbs zero chars.
            }
        }

        // Handle the last literal specially:
        String lastLiteral = literals[literalCount - 1];
        if (pattern.endsWithWildcard) {
            // If ends with a wildcard, we just need to find the last literal somewhere after pos
            // The wildcard can absorb whatever comes before it
            if (!lastLiteral.isEmpty()) {
                int idx = candidate.indexOf(lastLiteral, pos);
                if (idx == -1) {
                    return false; // not found at all
                }
                // wildcard absorbs candidate[pos..idx-1]
                // pos moves to idx+lastLiteral.length
                pos = idx + lastLiteral.length();
            }
            // After matching last literal, we don't care if there are leftover chars
            // because there's a trailing wildcard to absorb them.
            return true;
        } else {
            // If not ends with wildcard, the last literal must align at the end of candidate
            // candidate must end with lastLiteral at or after pos
            if (lastLiteral.isEmpty()) {
                // Last literal is empty, so candidate[pos..end] is leftover
                // Since no trailing wildcard, leftover not allowed. Must have pos == candidate.length
                return pos == candidate.length();
            } else {
                // Ensure candidate ends with lastLiteral and starts at some position >= pos
                int endPos = candidate.length() - lastLiteral.length();
                if (endPos < pos) {
                    return false; // not enough space to fit the last literal at the end
                }
                String endSegment = candidate.substring(endPos);
                if (!endSegment.equals(lastLiteral)) {
                    return false; // candidate does not end with lastLiteral
                }
                // Now the wildcard before this last literal absorbs candidate[pos..endPos-1]
                // pos after matching = endPos + lastLiteral.length() = candidate.length()
                // We must have matched exactly till the end
                return true;
            }
        }
    }


    public static void main(String[] args) {
        //  You can add more test cases here
        String[] testTitles1 = {"adcdcefdfeffe", "adcdcefdfeff", "dcdcefdfeffe", "adcdcfe"};
        String[] testTitles2 = {"CLSomGhcQNvFuzENTAMLCqxBdj", "CLSomNvFuXTASzENTAMLCqxBdj", "CLSomFuXTASzExBdj", "CLSoQNvFuMLCqxBdj", "SovFuXTASzENTAMLCq", "mGhcQNvFuXTASzENTAMLCqx"};
        String[] testTitles3 = {"abcdefg", "abefg", "efg"};

        System.out.println(solution(4, "ad{xyz}cdc{y}f{x}e", testTitles1).equals("True,False,False,True"));
        System.out.println(solution(6, "{xxx}h{cQ}N{vF}u{XTA}S{NTA}MLCq{yyy}", testTitles2).equals("False,False,False,False,False,True"));
        System.out.println(solution(3, "a{bdc}efg", testTitles3).equals("True,True,False"));
    }
}
