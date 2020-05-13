import java.util.Stack;

/**
 * @author Zephon
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2020/5/12 上午9:36
 * @Copyright ©
 */
public class Test {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int l = 0,t=0;
        int b = matrix.length-1,r = matrix[0].length-1;
        int k = 0;
        int res[] = new int[(b+1)*(r+1)];
        while(k<res.length){
            for(int i=l;i<=r;i++){
                res[k++] = matrix[t][i];
            }
            if(++t>b)break;
            for(int i=t;i<=b;i++){
                res[k++] = matrix[i][r];
            }
            if(--r<l)break;
            for(int i=r;i>=l;i--){
                res[k++] = matrix[b][i];
            }
            if(--b<t)break;
            for(int i=b;i>=t;i--){
                res[k++] = matrix[i][l];
            }
            if(++l>r)break;
        }
        System.out.println(res);
    }
}