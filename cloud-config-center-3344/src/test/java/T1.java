import java.util.Scanner;
import java.util.Stack;

/**
 * @author Zephon
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2020/5/11 上午9:57
 * @Copyright ©
 */
public class T1 {
    static Stack<String> stack = new Stack<>();
    static StringBuilder res = new StringBuilder();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n>0){
            int a = in.nextInt();
            String str = in.nextLine();
            switch (a){
                case 1:
                    append(str.trim());
                    break;
                case 2:
                    remove(Integer.parseInt(str.trim()));
                    break;
                case 3:
                    output(Integer.parseInt(str.trim()));
                    break;
                case 4:
                    rollback();
                    break;
                default:
                    break;
            }
            n--;
        }
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
    public static void append(String s){
        stack.push(res.toString());
        res.append(s);
    }
    public static void remove(int k){
        stack.push(res.toString());
        res.replace(res.length()-k,res.length(),"");
    }
    public static void output(int k){
        System.out.println(res.charAt(k-1));
    }
    public static void rollback(){
        res = new StringBuilder(stack.pop());
    }
}
