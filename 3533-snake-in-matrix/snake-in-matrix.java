class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int r = 0, c = 0;
        
        for (String cmd : commands) {
            if (cmd.equals("UP")) r--;
            else if (cmd.equals("DOWN")) r++;
            else if (cmd.equals("LEFT")) c--;
            else if (cmd.equals("RIGHT")) c++;
        }
        
        return r * n + c;
    }
}
