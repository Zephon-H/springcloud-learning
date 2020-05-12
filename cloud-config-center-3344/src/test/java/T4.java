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
public class T4 {
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        sb = new StringBuilder(str);
        int n = in.nextInt();
        while(n>0){
            int op = in.nextInt();
            int num = in.nextInt();
            String tmp = in.nextLine();
            if(op==2){
                diff(num,Integer.parseInt(tmp.trim()));
            }else{
                modify(num,tmp.trim().charAt(0));
            }
            n--;
        }
    }
    static Set<Character> set = new HashSet<>();
    public static void diff(int start,int end){
        set.clear();
        for (char c : sb.substring(start-1,end).toCharArray()) {
            set.add(c);
        }
        System.out.println(set.size());
    }
    public static void modify(int k,char c){
        sb.replace(k-1,k,String.valueOf(c));
    }
}
