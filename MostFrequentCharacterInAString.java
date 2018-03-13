import java.util.HashMap;
import java.util.Map;

public class MostFrequentCharacterInAString {

    public char findMostFrequent(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int count = 0;
        char res = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Character.toLowerCase(c); // 不区分大小写
            if (!Character.isLetterOrDigit(c)) 	continue; // 去掉其他字符
            if (c == ' ') 	continue; //去掉空格加这个
            map.put(c, map.getOrDefault(c, 0)+1);
            if (map.get(c) > count) {
                count = map.get(c);
                res = c;
            }
        }
        return res;
    }


//    Follow Up:
//    优化时间，count维持两个，频率第一大，第二大，1-2如果>=剩下的，就可以了。

    public char findMostFrequent2(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int max1 = 0, max2 = 0;
        char result = ' ';
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!Character.isLetter(cur)) {
                continue;
            }
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            if (map.get(cur) > max1) {
                max2 = max1;
                max1 = map.get(cur);
                result = cur;
            } else if (map.get(cur) > max2) {
                max2 = map.get(cur);
            }
            if (max1 - max2 > s.length() - i) {
                return result;
            }
        }
        System.out.println(map);
        return result;
    }

    public static void main(String[] args) {
        MostFrequentCharacterInAString sol = new MostFrequentCharacterInAString();
        String s = "SSSSSssAA";
        System.out.println(sol.findMostFrequent(s));
        System.out.println(sol.findMostFrequent2(s));
    }
}
