// Last updated: 9/14/2025, 9:14:14 AM
class Solution {
public:
    vector<string> fizzBuzz(int n) {
        vector<std::string> v;
        int i = 1;
        while(i<n+1){
            if(i%3==0 && i%5==0){
                v.push_back("FizzBuzz");
            }else if(i%3==0){
                v.push_back("Fizz");
            }else if(i%5==0){
                v.push_back("Buzz");
            }else{
                v.push_back(to_string(i));
            }
            i+=1;
        }
        return v;

    }
};