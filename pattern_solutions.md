## 448. Find All Numbers Disappeared in an Array  
Here at begin we must sort given array then to add to result list the numbers which are not on their correct positions. 
1. Number in array on current position must be at his original place ([2,3,2,1] must be [1,2,2,3])
2. The looking at changed array and add to new list this nubmers  
Using 2 «for» cycle  

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List result = new ArrayList(); 
  
        for (int i = 0; i < nums.length; i++){
           while (nums[i] != i+1 && nums[i] != nums[nums[i]-1]){
               int temp = nums[i];
               nums[i] = nums[temp-1];
               nums[temp-1] = temp;
           }
        }
        for (int i = 0; i < nums.length; i++){
           if (nums[i]!=i+1){
               result.add(i+1);
           } 
        }
        return result;
    }
}

## 136. Single Number
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

I used here bitwise operation XOR 
The table of it is so 
```
A	B	AxorB
0	0	0
1	0	1
0	1	1
1	1	0
```
If we make xor with all number in array we get next: \
Given array:`[3,4,2,3,2]` \
Make XOR: `3^4^2^3^2 = (3^3)^(4^0)^(2^2) = 4` (because `4 xor 0 = 4` );
``` java 
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        int n = nums.length;
        if (n == 1){
            return nums[0];
        }
        
        for (int i = 0; i<n; i++){
            result ^= nums[i]; 
        }
        return result;
    }
}
```

> **TODO** In this variant we can realize sorting of numbers. While «current» number in massive is lower than «current+1» make `result += nums[i]`, else `result -= nums[i]`
``` java 
// this works only for positive numbers in array
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++){
           while (nums[i] != i+1 && nums[i] != nums[nums[i]-1]){
               int temp = nums[i];
               nums[i] = nums[temp-1];
               nums[temp-1] = temp;
           }
        }

        result = nums[0];
        for (int i = 1; i < nums.length; i++){
           if (nums[i-1]<nums[i]){
                result += nums[i];
           } else {
                result -= nums[i];
           }
        }
        
        return result ;
    }
}
``` 
## 70. Climbing Stairs
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

There is 2 ways to solve this problem:
1. Recursively 
2. Using principies of dynamic programming

### 1. At each n stairs the number of distinc ways equal to count of ways on previos stainrs count (n-1) and count of (n-2): 
ways(3) = ways (3-1) + ways (3-2) = 2 + 1 = 3 
ways(4) = ways (3) + ways(2) = 5 
This is the concept of Fibonacci numbers 
``` java
class Solution {
    public int climbStairs(int n) {
         if (n < 2) {return 1;}
         else  return climbStairs(n-1) + climbStairs(n-2);
    }
}
```
### 2. The second way is using the principies of dynamic programming. At all it is using the same principe: Fibonacci numbers: 
We create 2 variables which meaning the numbers of previous and current count of ways:
for example if we had n=3 then we will do following:\
n = 1: current = 1, previous = 0, total = 1\
n = 2: current = current + previous = 1+0 = 1, previous = current = 1, total = 2\
n = 3: current = current + previous = 1+1 = 2, previous = current = 1, total = 3
``` java 
class Solution {
    public int climbStairs(int n) {
        int current = 1, previous = 0;
        int total = 0;
        while (n-- > 0){
            total = current+previous;
            previous = current;
            current = total;
        }
        return total;
    }
}
``` 
