class Solution {
    public int compress(char[] chars) {
        int idx = 0;
        int i = 0;
        while(i < chars.length){
            int j = i;
            while(j<chars.length && chars[i]==chars[j]){
                j++;
            }
            chars[idx++] =chars[i];
            int len =j - i;
            if(len>1){
                String s= String.valueOf(len);
                for(char c: s.toCharArray()){
                    chars[idx++]= c;

                }
            }
            i = j;
        }
        return idx;

        
    }
}