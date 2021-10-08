import java.util.Arrays;
import java.util.Random;

public class Main {
    static Random rn = new Random(System.currentTimeMillis());
    public static int getRandomInt(int i){
        return Math.abs(rn.nextInt()) % i + 1;
    }

    final int maxLen = 100000;

    public int[] getIntArray(int len) {
        int[] array = new int[len];
        for(int i=0; i<len; i++){
            array[i]= getRandomInt(100);
        }

        return array;
    }

    public int[][] remake(int[] o, int m, int n) {
        int k=o.length;
        int a[][]=new int[0][0];
        if(k!=(m*n))
            return a;
        a=new int[m][n];
        int g=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                a[i][j]=o[g++];
            }
        }
        return a;
    }

    public void test() {

        int m = getRandomInt(20);
        int n = getRandomInt(20);
        int[] array = getIntArray(m*n);
        Solution solution = new Solution();
        int[][] correct = remake(array, m, n);

        int[][] actual = solution.remake(array, m, n);

        if(!Main.equal(correct, actual)){
            throw new RuntimeException("Test failed");
        }
    }

    public static boolean equal(final int[][] arr1, final int[][] arr2) {
        if (arr1 == null) {
            return (arr2 == null);
        }

        if (arr2 == null) {
            return false;
        }

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!Arrays.equals(arr1[i], arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        try{
            Main main = new Main();
            for (int i=0;i<20;i++){
                main.test();
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
    }
}