// Last updated: 9/14/2025, 9:07:17 AM
class Solution {
    public String getEncryptedString(String s, int k) {
        char []arr = s.toCharArray();
        int len = arr.length;
        for(int i=0; i<len; i++){
            int index = (i + k) % len;
            arr[i] = s.charAt(index);
        }

        return new String(arr);
    }
}