class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer , HashSet<Integer>> map = new HashMap<>();

        for(int[] seat :reservedSeats){
            int row = seat[0];
            int col = seat[1];

            if(!map.containsKey(row)){
                map.put(row , new HashSet<>());
            }

            map.get(row).add(col);
        }

        int result = (n-map.size())*2;

        for(HashSet<Integer> seats : map.values()){
            boolean left = true;
            boolean middle = true;
            boolean right = true;

            for(int i=2 ; i<=5 ; i++){
                if(seats.contains(i)){
                    left = false;
                    break;
                }
            }

            for(int i=4 ; i<=7 ; i++){
                if(seats.contains(i)){
                    middle = false;
                    break;
                }
            }

            for(int i=6 ; i<=9 ; i++){
                if(seats.contains(i)){
                    right = false;
                    break;
                }
            }

            if(left&&right){
                result+=2;
            }
            else if(left || right || middle){
                result+=1;
            }
        }

        return result;
        
    }
}