import java.util.*;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        LinkedList<Integer> stack = new LinkedList<>();
        
        for (int num : nums) {
            stack.addLast(num);
            
            while (stack.size() > 1) {
                int a = stack.removeLast();
                int b = stack.removeLast();
                int g = gcd(a, b);
                
                if (g == 1) { // coprime
                    stack.addLast(b);
                    stack.addLast(a);
                    break;
                } else {
                    long lcm = (long) a / g * b;  // safe lcm calc
                    stack.addLast((int) lcm);
                }
            }
        }
        
        return stack;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
