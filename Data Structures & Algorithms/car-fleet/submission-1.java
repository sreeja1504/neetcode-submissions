class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pair = new int[n][2];
        for(int i=0; i<n; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a,b) -> Integer.compare(a[0], b[0]));
        int fleets;
        Stack<Double> stack = new Stack<>();
        stack.push((double) (target - pair[0][0]) / pair[0][1]);
        fleets = 1;
        for(int i = 1; i < n ; i++) {
            double currentTime = (double) (target - pair[i][0]) / pair[i][1];
            if(stack.peek() > currentTime) {
                stack.push(currentTime);
                fleets++;
            } else {
                while(!stack.isEmpty() && stack.peek() <= currentTime) {
                    stack.pop();
                }
                stack.push(currentTime);

            }
        }
        return stack.size();
        
    }
}
