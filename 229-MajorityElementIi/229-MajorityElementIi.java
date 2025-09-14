// Last updated: 9/14/2025, 9:15:25 AM
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //Boyer moore approach
        List<Integer> ans = new ArrayList<Integer>();

        //voters 
        int voter1 = -1;
        int voter2 = -1;

        //count of the vote
        int count1 = 0;
        int count2 = 0;

        //traversing the array
        for(int i:nums){
            if(voter1 == i) count1++;
            else if(voter2 == i) count2++;

            else if(count1 == 0){
                voter1 = i;
                count1 = 1;
            }
            else if(count2 == 0){
                voter2 = i;
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for(int i:nums){
            if(voter1 == i) count1++;
            if(voter2 == i) count2++;
        }

        System.out.println(voter1 +" "+voter2);
        int len  = nums.length;
        if(count1 > len/3) ans.add(voter1);
        if(count2 > len/3 && voter1!=voter2) ans.add(voter2);

        return ans;
    }

}

//TC : O(n)
//Sc : O(1)