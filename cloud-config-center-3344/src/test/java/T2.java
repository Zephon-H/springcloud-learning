import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Zephon
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2020/5/11 上午9:57
 * @Copyright ©
 */
public class T2 {
    static Set<String> set = new HashSet<>();
    static int count = 0;
    static int maxLen = 0;
    static int minLen = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String article = in.nextLine();
        int n = in.nextInt();
        String[] words = new String[n];
        in.nextLine();
        for (int i = 0; i < n; i++) {
            words[i] = in.nextLine();
        }
        for (String word : words) {
            set.add(word);
            maxLen = Math.max(maxLen, word.length());
            minLen = Math.min(minLen, word.length());
        }
        solution(article);
        System.out.println(count);
    }

    public static void solution(String article) {
        
    }
    public static boolean judge(String str){
        return set.contains(str);
    }
}

