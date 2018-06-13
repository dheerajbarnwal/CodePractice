import java.util.Scanner;

/**
 * Created by Dheeraj Kumar Barnwal on 13/06/18.
 * Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string.
 * Given a string, find the number of pairs of substrings of the string which are anagrams of each other.
 */
public class SubAnagram {
    public static boolean checkAnagram(String s1, String s2){
        int arr[] = new int[26];
        for(int i=0;i<s1.length();i++){
            arr[s1.charAt(i)-'a']++;
            arr[s2.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }
    static int sherlockAndAnagrams(String s) {
        int res=0;
        for(int len =1 ;len<s.length();len++){
            String s1,s2;

            for(int i=0;i<s.length()-len;i++){
                s1=s.substring(i,i+len);
                for(int j=i+1;j<s.length()-len+1;j++){
                    s2 = s.substring(j,j+len);
                    if(checkAnagram(s1,s2)==true){
                        res++;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T= sc.nextInt();
        for(int t=0;t<T;t++){
            String s = sc.next();
            int res = sherlockAndAnagrams(s);
            System.out.println(res);

        }
    }
}
