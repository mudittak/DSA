class Solution {
    public double myPow(double a, long b) {
        
        if(b == 0) return 1;

        if(b < 0) {
            if(a == 0) return Double.NaN;

            a = 1 / a;
            b = -b;
        }

        double call = myPow(a, b / 2);

        if(b % 2 == 0) 
            return call * call;
        else 
            return a * call * call;
    }
}