//recuresive TLE



class Solution
{
    private final long MOD = 1000000007;
    
    private long add(long a,long b){
        return ((a%MOD) + (b%MOD))%MOD;
    }
    
    private long multiply(long a,long b){
        return ((a%MOD) * (b%MOD))%MOD;
    }
    
    long countWays(int n,int k)
    {
        if(n==1)return k;
        if(n==2)return add(k,multiply(k,k-1))%MOD;
        
        long same= multiply(countWays(n-2,k),k-1)%MOD;
        long diff= multiply(countWays(n-1,k),k-1)%MOD;
        
        return add(same,diff);
    }
}

// dp[] memoization
class Solution
{
    private final long MOD = 1000000007;
    
    private long add(long a,long b){
        return ((a%MOD) + (b%MOD))%MOD;
    }
    
    private long multiply(long a,long b){
        return ((a%MOD) * (b%MOD))%MOD;
    }
    
    long countWays(int n,int k)
    {
        long dp[]= new long[n+1];
        return getWays(n,k,dp);
    }
    long getWays(int n,int k,long dp[])
    {
        if(n==1)return k;
        if(n==2)return add(k,multiply(k,k-1))%MOD;
        
        if(dp[n]!=0)return dp[n];
        long same= multiply(countWays(n-2,k),k-1)%MOD;
        long diff= multiply(countWays(n-1,k),k-1)%MOD;
        
        dp[n]=add(same,diff);
        
        return dp[n];
    }
}


//bottom up O(n) O(1)
class Solution
{
    private final long MOD = 1000000007;
    
    private long add(long a,long b){
        return ((a%MOD) + (b%MOD))%MOD;
    }
    
    private long multiply(long a,long b){
        return ((a%MOD) * (b%MOD))%MOD;
    }
    
    long countWays(int n,int k)
    {
        long dp[]= new long[n+2];// for 1,17 case +1 more
        dp[1]=k;dp[2]=add(k,multiply(k,k-1));
        for(int i=3;i<=n;i++)
        {
            dp[i]=add(multiply(dp[i-2],k-1),multiply(dp[i-1],k-1));
        }
        return dp[n];
    }
    
}

//bottom up O(n) O(1)
class Solution
{
    private final long MOD = 1000000007;
    
    private long add(long a,long b){
        return ((a%MOD) + (b%MOD))%MOD;
    }
    
    private long multiply(long a,long b){
        return ((a%MOD) * (b%MOD))%MOD;
    }
    
    long countWays(int n,int k)
    {
        long prev1=k,prev2=add(k,multiply(k,k-1));
        long cur=0;
        if(n==1)return prev1;
        if(n==2)return prev2;
        for(int i=3;i<=n;i++)
        {
            cur=add(multiply(prev2,k-1),multiply(prev1,k-1));
            prev1=prev2;
            prev2=cur;
        }
        return cur;
    }
    
}