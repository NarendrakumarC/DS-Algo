class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int pf[] = new int[n+1];
        pf[0]=0;
        pf[1]=gain[0];
        for(int i=2;i<=n;++i){
            pf[i] = pf[i-1]+gain[i-1];
        }
        int max_altitude=0;
        for(int i=0;i<pf.length;i++){
            max_altitude = Math.max(max_altitude,pf[i]);
        }
        return max_altitude;
    }
}