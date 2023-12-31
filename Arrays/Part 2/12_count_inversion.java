import java.util.* ;
import java.io.*; 
class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        int n=(int)N;
        return sort(arr,0,n);   
    }
    public static long sort(long[] arr,int s,int e)
    {
        long count=0;
        if(e-s==1)return count;
        int m=s+(e-s)/2;
        count+=sort(arr,s,m);
        count+=sort(arr,m,e);
        count+=countInv(arr,s,m,e);
        return count;
    }
    public static long countInv(long[] arr,int s,int m,int e){
        long temp[]= new long[e-s];
        int i=s,j=m,k=0;
        
        i=s;j=m;long count=0;
        while(i<m && j<e)
        {
            if(arr[i]<=arr[j])
            {
                temp[k]=arr[i];
                i++;
            }
            else
            {
                temp[k]=arr[j];
                count+=m-i;
                j++;
            }
            k++;
        }
        while(i<m)
        {
            temp[k]=arr[i];
            i++;k++;
        }
        while (j<e)
        {
            temp[k]=arr[j];
            j++;k++;
        }
        e--;k--;
        while(k>=0)
        {
            arr[e--]=temp[k--];
        }
        return count;
    }
}