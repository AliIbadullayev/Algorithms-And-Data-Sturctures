#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        vector<string> res;
        if (nums.empty()) return res;
        int start = nums[0], end = nums[0];
        for (int i = 0; i < nums.size(); i++){
            if (end + 1 == nums[i+1]){
                end = nums[i+1];
            } else {
                if (end == start) res.push_back(to_string(end));
                else res.push_back(to_string(start) + "->" + to_string(end)) ;
                start = nums[i+1];
                end = nums[i+1];
            }
        }
        return res;
    }
};
int main(){
    Solution solution;
    vector<int> nums = {-1};
    vector<string> strings = solution.summaryRanges(nums);
    for (const string& a: strings){
        cout<<a<<endl;
    }
    return 0;
}
