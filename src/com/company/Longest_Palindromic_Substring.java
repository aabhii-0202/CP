package com.company;

public class Longest_Palindromic_Substring {
    public static String longestPalindrome(String s) {
        int n=s.length();
        int indexstart=0;
        int indexend=0;//index of answer string
        int max=1;


        for(int i=0;max<2*(n-1-i);i++) {
            //for odd number of characters with no continuous same element in palindrom
            if(s.charAt(i)!=s.charAt(i+1)){
                int j=i-1;
                int k=i+1;
                while(j>=0&&k<n&&s.charAt(j)==s.charAt(k)) {
                    j--;									    
                    k++;
                }
                j++;
                k--;
                int maxtillnow=k-j+1;
                if(maxtillnow>max) {
                    max=maxtillnow;
                    indexstart=j;
                    indexend=k;
                }

            }
            else {//i&&i+1 are equal
                int count=1;
                char temp = s.charAt(i);
                int j=i+1;
                int k;
                while(j<n&&s.charAt(j++)==temp)count++;
                if(count%2==0) { //even
                    j=i+(count/2)-1;
                    k=j+1;
                }else {//odd
                    j=i+count/2;
                    k=j;
                }
                while(j>=0&&k<n&&s.charAt(j)==s.charAt(k)) {
                    j--;
                    k++;
                }
                j++;
                k--;
                int maxtillnow=k-j+1;
                if(maxtillnow>max) {
                    max=maxtillnow;
                    indexstart=j;
                    indexend=k;
                }
            }
        }
        return s.substring(indexstart,indexend+1);


    }
    public static void main(String[] args) {
        String s[] = {"a",
                "aaa","abc","bbc","cbb","malayalam","akdddddddf","makkkkkkam"};
        for(int  i=0;i<s.length;i++) {
            System.out.println("For s = "+s[i]+" longest palindrome is "+longestPalindrome(s[i]));
        }

    }
}
