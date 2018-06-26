import java.util.Scanner;

/**
 * Created by Dheeraj Kumar Barnwal on 26/06/18.
 * Print all permutation of string
 */
public class StringPermute {

    private static void permutation(String prefix, String str) {
        //System.out.println("debug : " + prefix + " " + str);
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

    public static void permutation(String str) {
        permutation("", str);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String inp = sc.next();
        permutation(inp);

    }
}
