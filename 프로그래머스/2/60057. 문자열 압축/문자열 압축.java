class Solution {
    public int solution(String s) {
        int length = 1;
        int minLength = s.length();
        while (length < s.length()) {
            int start = 0;
            String previous = "";
            int count = 1;
            StringBuilder sb = new StringBuilder();
            while (start < s.length()) {
                String sub;
                if(start + length >= s.length()) {
                    sub = s.substring(start);
                } else {
                    sub = s.substring(start, start + length);
                }
                if (previous.isBlank()) {
                    previous = sub;
                } else if (previous.equals(sub)) {
                    count++;
                } else {
                    if (count > 1) {
                        sb.append(count);
                    }
                    sb.append(previous);
                    previous = sub;
                    count = 1;
                }
                start += length;
            }
            if(count > 1) {
                sb.append(count).append(previous);
            } else {
                sb.append(previous);
            }
            minLength = Math.min(minLength, sb.length());
            length++;
        }

        return minLength;
    }
}