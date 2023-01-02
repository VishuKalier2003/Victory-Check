/* In the "100 game" two players take turns adding, to a running total, any integer from 1 to 10... The player who first causes the running total to reach or exceed 100 wins... What if we change the game so that players cannot re-use integers?.. For example, two players might take turns drawing from a common pool of numbers from 1 to 15 without replacement until they reach a total >= 100... Given two integers maxChoosableInteger and desiredTotal, return true if the first player to move can force a win, otherwise, return false. Assume both players play greedily...
 * Eg 1: maxChoosable = 10   Desired = 11                     Victory for first = False       Reason: Since they play optimally, player 1 will choose 10 and player 2 will choose 9 which will make player 2 win the game...
 * Eg 2: maxChoosable = 10   Desired = 1                      Victory for first = True
 * Eg 3: maxChoosable = 10   Desired = 0                      Victory for first = True
 */
import java.util.*;
public class Victory
{
    public boolean ChancesOfVictory(int arr[], int required)
    {
        boolean vic = false;
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
        {
            sum = sum + arr[i];      // Sum of the answers till now...
            if(i == 0)
            {
                if(required <= sum)    // If the sum provided is already smaller...
                {
                    vic = true;
                    break;
                }
            }
            if(i % 2 != 0)
            {   // If chance of Second Player...
                if(sum > required)
                    return false;
            }
            else
            {   // If chance of First Player...
                if(sum > required)
                    return true;
            }
        }
        return vic;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.print("Enter the Max Choosable number : ");
        x = sc.nextInt();
        int choices[] = new int[x];
        for(int i = 0; i < x; i++)
            choices[i] = x-i;
        System.out.println("The Choices Array : ");
        for(int i = 0; i < x; i++)
            System.out.print(choices[i]+", ");
        System.out.println();
        System.out.print("Enter the required number to reach : ");
        x = sc.nextInt();
        Victory victory = new Victory();
        System.out.println("Chances of Victory : "+victory.ChancesOfVictory(choices, x));
        sc.close();
    }
}

// Time Complexity  - O(n) time...
// Space Complexity - O(n) space...

/* DEDUCTIONS:- 
 * 1. The array we assume in decreasing sequence since the players will choose numbers greedily...
 * 2. We now check sum at every iteration, whichever player gets the sum greater than the target first wins...
*/