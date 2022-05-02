
import java.util.*;
public class Main{
    
    public static void main (String[] args) {
        /* code */
        int[] arr ={1,2,3,4,5,6};
        //quickSort(arr, 0, 5);
        
            System.out.print(binarySearch(arr, 7));
    }
    
    static int binarySearch(int[] arr, int key)
    {
        int s=0;
        int e=arr.length-1;
        quickSort(arr, s, e);
        return helper(arr, s, e,key);
    }
    
    static int helper(int[] arr, int s, int e, int key)
    {
        if(s>e) return -1;
        
        int i=(s+e)/2;
        if(arr[i]==key)
            return i;
        else if(arr[i] > key)
            return helper(arr, s, i-1, key);
        else
            return helper(arr, i+1, e, key);
            
    }
    
    static void quickSort(int[] arr, int s, int e)
    {
        if(s<e)
        {
            int p = partition(arr, s, e);
            quickSort(arr, s, p-1);
            quickSort(arr, p+1, e);
        }
    }
    
    static int partition(int[] arr, int s, int e)
    {
        int pivot = arr[e];
        int pIndex=0;
        for(int i=0;i<e;i++)
        {
            if(arr[i]<=pivot)
            {
                int temp=arr[i];
                arr[i]=arr[pIndex];
                arr[pIndex]=temp;
                pIndex++;
            }
        }
        
        arr[e] = arr[pIndex];
        arr[pIndex] = pivot;
        
        return pIndex;
    }
}
