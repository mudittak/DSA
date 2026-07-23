class Solution {
    public int maximumCount(int[] arr) {
        int n = arr.length;
        int lo = 0;
        int hi = n-1;
        int negcount = 0;
        int poscount = 0;

        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(arr[mid]>=0) hi=mid-1;
            else {
                lo= mid+1;
            }
        }
        negcount = lo;
        
         lo = 0;
         hi = n-1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(arr[mid]<=0) lo=mid+1;
            else {
                hi= mid-1;
            }
        }
        poscount = n-lo;   
        return Math.max(negcount, poscount);
    }
}