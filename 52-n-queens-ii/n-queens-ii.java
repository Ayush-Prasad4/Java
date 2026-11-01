class Solution {
    int n=0;
    int ans=0;
    boolean [] col;
    boolean [] dail1;
    boolean [] dail2;
    public int totalNQueens(int n) {
        this.n=n;
        col=new boolean[n];
        dail1=new boolean[2*n-1];
        dail2=new boolean [2*n-1];
        solve(0);
        return ans;
    }
    public void solve(int r){
        if(r==n){
            ans++;
            return;
        }
        for(int c=0;c<n;c++){
        int d1=r-c+n-1;
        int d2=r+c; 
        if(col[c] || dail1[d1] || dail2[d2]){
            continue;
        }
        place(r,c);
        solve(r+1);
        remove(r,c);
        }
    }
    public void place(int r,int c){
        col[c]=true;
        dail1[r-c+n-1]=true;
        dail2[r+c]=true;
    }
    public void remove(int r,int c){
        col[c]=false;
        dail1[r-c+n-1]=false;
        dail2[r+c]=false;
    }
}