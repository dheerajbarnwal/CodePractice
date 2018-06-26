/**
 * Created by Dheeraj Kumar Barnwal on 26/06/18.
 * Toggle bits in the given range : GFG
 */
public class ToggleBitsRange{
        // Function to toggle bits in the given range
        static int toggleBitsFromLToR(int n, int l, int r)
        {
            /*num = ((1<<(R-L+1))-1)<<(L-1);

            Now break it to understand:
            From your point 1: we need R-L+1 number of 1's
            So, ((1<<(R-L+1))-1) : it will give R-L+1 number of 1's

            Now, according to question we have to toggle from L. So, leave L-1 bit as it is.
            So, do left shift by L-1 times.

            Finally, ((1<<(R-L+1))-1)<<(L-1) : it will give all set bits from L to R. */

            int num = ((1<<(r-l+1))-1)<<(l-1);

            // toggle bits in the range l to r in 'n'
            // and return the number
            return (n ^ num);
        }

        // driver program
        public static void main (String[] args)
        {
            int n = 50;
            int l = 2, r = 5;
            System.out.println(toggleBitsFromLToR(n, l, r));
        }
}
