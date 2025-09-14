// Last updated: 9/14/2025, 9:12:42 AM
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            int next = asteroids[i];
            if(stack.isEmpty()){
                stack.push(next);
                continue;
            }

            //asteroids goes in same direction so no collision
            if(stack.peek() >0 && next > 0 || stack.peek()<0 && next<0){
                stack.push(next);
                continue;
            }

            //asteroids goes in opposite direction
            if(stack.peek()<0 && next > 0){
                stack.push(next);
                continue;
            }
            boolean need2addnext = false;
            while(stack.peek()>0 && next < 0){
                if(stack.peek() < Math.abs(next)){
                    stack.pop();
                    if(stack.isEmpty()){
                        // stack.push(next);
                        need2addnext = true;
                        break;
                    }
                    need2addnext = true;
                }
                else if(stack.peek() == Math.abs(next)){
                    stack.pop();
                    need2addnext = false;
                    break;
                }else{
                    need2addnext = false;
                    break;
                }
            }
            if(need2addnext){
                stack.push(next);
            }
        }
        // System.out.println(stack);
        int []ans = new int[stack.size()];
        int i=0;
        for(int x:stack){
            ans[i++] = x;
        }
        return ans;
    }
}
