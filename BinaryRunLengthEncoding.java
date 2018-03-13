public class BinaryRLE {

    public String getBRLE(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                count++;
            }
            sb.append(count);
            count = 1;
        }
        return sb.toString();
    }

    public String getBRLE2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                count++;
            }
            if (s.charAt(i) == '1') {
                sb.append("+").append(count);
            } else {
                sb.append("-").append(count);
            }
            count = 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BinaryRLE sol = new BinaryRLE();
        String s = "1111000011001001000";
        System.out.println(sol.getBRLE(s));
        System.out.println(sol.getBRLE2(s));
    }
}
