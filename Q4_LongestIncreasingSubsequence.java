/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 
 *
 * @author mohas
 */
import java.util.*;
public class LongestIncreasingSubsequence {
    public static void PrintLIS(int[] n) { 

        // Declare a variable and set it to the length of the array
        int length = n.length; 
        
        // Creates a new array and set the size to the length of the array
        int[] lis = new int[length];
        
        // This is a utility method provided by the java.util.Arrays 
        // It sets every element in the new array we created (lis) to 1
        Arrays.fill(lis, 1);
        
        // This loop iterates over each index i from 1 to length - 1 in the input array n
        // Starts from index 1 because the LIS at index 0 is always 1
        for (int i = 1; i < length; i++) {
            
        // This loop iterates over each index j from 0 to i-1.
        // It ompares the elements at index i with all previous elements to check if it can be a part of the increasing subsequence.
            for (int j = 0; j < i; j++) {
                
        // n[i] > n[j]: Ensures that the element at index i is greater than the element at index j, meaning it can be a part of the increasing subsequence.
        // lis[i] < lis[j] + 1: Checks if the LIS ending at index i is less than the LIS ending at index j incremented by 1. If true, extend the LIS ending at index i.        
                if (n[i] > n[j] && lis[i] < lis[j] + 1) {
                    
        // If true, update the LIS at index i to be one more than the LIS at index j.            
                    lis[i] = lis[j] + 1;
                }
            }
        }
        // Find the maximum value in the lis array, which represents the length of the overall LIS
        int maxLength = Arrays.stream(lis).max().orElse(0);
        
        // Finds the index of the last element in the original array 
        // that belongs to the LIS by searching backward from the end of the array.
        int lastIndex = -1;
        for (int i = length - 1; i >= 0; i--) {
            if (lis[i] == maxLength) {
                lastIndex = i;
                break;
            }
        }
        
        // Initialized to hold the maximum possible number of elements in the LIS, which is maxLength.
        int[] result = new int[maxLength];
        
        // This keeps track of the current length
        int currentLength = maxLength;
        
        // This variable stores the value of the last element added to the result array
        int currentValue = n[lastIndex];
        
        // Reconstructs the LIS in reverse order and stores it in the result array
        // The reconstructed LIS will be stored in the result array in the correct order
        for (int i = lastIndex; i >= 0; i--) {
            if (currentLength > 0 && lis[i] == currentLength && n[i] <= currentValue) {
                result[--currentLength] = n[i];
                currentValue = n[i];
            }
        }

        // Print the length of LIS
        System.out.println("Length of Longest Increasing Subsequence: " + maxLength);

        // Print the LIS
        System.out.println("Longest Increasing Subsequence: " + Arrays.toString(result));
    }

    public static void main(String[] args) {
        int[] arrayInt = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int [] input = { 2, 6, 3, 4, 1, 2, 9, 5, 8 };

        PrintLIS(arrayInt);
        PrintLIS(input);
    }
}
