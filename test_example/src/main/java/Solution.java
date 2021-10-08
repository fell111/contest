public class Solution {
    public int[][] remake(int[] o, int m, int n){
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
}