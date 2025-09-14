// Last updated: 9/14/2025, 9:08:51 AM
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        //gready solution
        Arrays.sort(seats);
        Arrays.sort(students);
        int moves = 0;
        int n = seats.length;
        for(int i=0;i<n;i++){
            moves += Math.abs(seats[i]-students[i]);
        }

        return moves;
    }
}