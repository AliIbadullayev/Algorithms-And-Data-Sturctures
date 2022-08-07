#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    static vector<string> summaryRanges(vector<int>& nums) {
        vector<string> res;
        if (nums.empty()) return res;
        int start = nums[0];
        int n = nums.size();
        for (int i = 0; i < n ; i++){
            if (n == i+1 || nums[i] != nums[i+1] - 1 ){
                if (start == nums[i])
                    res.push_back(to_string(start));
                else
                    res.push_back(to_string(start)+"->"+to_string(nums[i]));
                if (n != i+1)
                start = nums[i+1];
            }
        }
        return res;
    }
};
int main(){
    vector<int> nums = {-1};
    vector<string> strings = Solution::summaryRanges(nums);
    for (const string& a: strings){
        cout<<a<<endl;
    }
    return 0;
}
