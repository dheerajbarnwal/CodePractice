Approach 1: Greedy
​
Intuition
​
Representing a given integer as a Roman Numeral requires finding a sequence of the above 13 symbols, where their corresponding values add up to the integer. This sequence must be in order from largest to smallest, based on symbol value. To remind you, these are the symbol values.
​
Symbol mapping
​
As explained in the overview, the representation should use the largest possible symbols, working from the left. Therefore, it makes sense to use a Greedy algorithm. A Greedy algorithm is an algorithm that makes the best possible decision at the current time; in this case taking out the largest possible symbol it can.
​
So to represent a given integer, we look for the largest symbol that fits into it. We subtract that, and then look for the largest symbol that fits into the remainder, and so on until the remainder is 0. Each of the symbols we take out are appended onto the output Roman Numeral string.
​
For example, suppose we need to make the number 671.
​
The largest symbol that fits into 671 is D (which is worth 500). The next symbol up, CM, is worth 900 and so is too big to fit. Therefore, we now have the following.
​
Roman Numeral so far: D
Integer remainder: 671 - 500 = 171
​
We now repeat the process with 171. The largest symbol that fits into it is C (worth 100).