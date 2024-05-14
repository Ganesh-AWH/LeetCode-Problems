class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //solving using gready approach 
        //makes series of decision based on certain criteria
        Arrays.sort(g);
        Arrays.sort(s);

        // use two pointers
        int i=0;
        int j=0;

        while(i<g.length){
            //if the size of cookes cannot able to satisfy the lower greedy child then increase the size
            while(j<s.length && s[j] < g[i]){
                j++;
            }
            if(j<s.length){
                //the childrens are satisfied
                i++;
                j++;
            }else{
                break;
            }
            
        }

        return i;
    }
}