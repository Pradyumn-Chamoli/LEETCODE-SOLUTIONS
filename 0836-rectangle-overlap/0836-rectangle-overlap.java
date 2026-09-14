class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0];
        int x2 = rec1[2];
        int y1 = rec1[1];
        int y2 = rec1[3];
        int a1 = rec2[0];
        int a2 = rec2[2];
        int b1 = rec2[1];
        int b2 = rec2[3];

        if((x1<a2 && x2>a1) && (y1<b2 && y2>b1)){
            return true;
        }

        return false;
        
    }
}