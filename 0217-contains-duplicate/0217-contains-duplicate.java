import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int n : nums) {
            if (!set.add(n)) { // add() returns false if already exists
                return true;
            }
        }
        return false;
    }
}