class Solution {
    public void rotate(int[][] arr) {
 int n = arr.length;
        // transpose
        for(int i=0;i<n;i++){ 
            for(int j=0;j<i;j++){ 
               int temp = arr[i][j];
               arr[i][j] = arr[j][i];
               arr[j][i] = temp;
            }
        }
        // reverse each row
        for(int row=0;row<n;row++){
            int i=0, j=n-1;
            while(i<j){
                int temp = arr[row][i];
                arr[row][i] = arr[row][j];
                arr[row][j] = temp;
                i++;
                j--;
            }
        }
    }
}
