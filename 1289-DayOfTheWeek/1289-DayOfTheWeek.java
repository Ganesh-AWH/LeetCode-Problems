// Last updated: 9/14/2025, 9:10:47 AM
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        int []mon = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        String []dayOfWeek = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        //bacause 1 jan 1971 is Friday
        int sum = 4;
        //years to days
        for(int i=1971;i<year;i++){
            //check if it is leap year
            if((i%4==0 && i%100!=0) || (i%400==0)){
                sum+=366;
            }else{
                sum+=365;
            }
        }

        //month to days
        for(int i=1;i<month;i++){
            if(i==2 && ((year%4==0 && year%100!=0) || (year%400==0))) sum++;
            sum+=mon[i];
        }
        sum += day;

        return dayOfWeek[sum%7];
    }
}