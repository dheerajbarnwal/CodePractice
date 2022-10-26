The first observation: the sum of a subarray starting at the index ll and ending at index rr (0-based) is a multiple of kk when its remainder modulo kk is 00, i.e. (nums[l] + nums[l + 1] + \dots + nums[r]) \% k = 0(nums[l]+nums[l+1]+⋯+nums[r])%k=0.
​
Let pref[i] denote the sum of the first ii elements of the array numsnums, i.e. pref[i]=nums[0] + nums[1] + \dots + nums[i-1]pref[i]=nums[0]+nums[1]+⋯+nums[i−1]. In particular pref[0]=0.
​
We can represent the sum of the subarray in terms of prefpref: nums[l] + nums[l + 1] + \dots + nums[r]=pref[r+1]-pref[l]nums[l]+nums[l+1]+⋯+nums[r]=pref[r+1]−pref[l]. From the properties of modulo operation, the equality (pref[r+1]-pref[l]) \% k = 0(pref[r+1]−pref[l])%k=0 is equivalent to pref[l] \% k = pref[r+1] \% kpref[l]%k=pref[r+1]%k. The value pref[0] = 0pref[0]=0 allows us to consider subarrays starting at the beginning of the entire array.
​
Now the problem became a little easier. We might try all subarrays of size at least two and check the above condition. However, there are O(nums.length^2)O(nums.length
2
) subarrays and therefore such a solution is too slow.
​
The next observation: for index rr we do not need to check all possible indices ll, we are only interested if there exists such l < rl<r (this inequality ensures that the subarray size is at least two) that pref[l] \% k = pref[r+1] \% kpref[l]%k=pref[r+1]%k. This check can be done using a hash map storing the leftmost index for each remainder of modulo kk. In other words, the value for a key xx is the leftmost index ii such that pref[i] = xpref[i]=x.
​
​