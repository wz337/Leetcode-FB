//For example, if the input string is “wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6”.
public class RunLengthEncoding {

    public String getRLE(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(s.charAt(i-1));
                sb.append(count);
                count = 1;
            }
        }
        return sb.toString();
    }

    public String getRLE2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                count++;
            }
            sb.append(s.charAt(i)).append(count);
            count = 1;
        }
        return sb.toString();
    }

    public static void main (String[] args) {
        RunLengthEncoding sol = new RunLengthEncoding();
        String s = "wwwwaaadexxxxxx";
        System.out.println(sol.getRLE(s));
        System.out.println(sol.getRLE2(s));
        s = "abc";
        System.out.println(sol.getRLE(s));
        System.out.println(sol.getRLE2(s));
    }
}
