class Solution {
    public String smallestNumber(String s) {
        int n = s.length();
        int cnt =0;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        for(int i =0; i<=n; i++){
                st.push(i+1);

                if(i == n|| s.charAt(i) == 'I' ){
                    while(!st.isEmpty()){
                        sb.append(st.pop());
                    }
                }
        }
        return sb.toString();
    }
}