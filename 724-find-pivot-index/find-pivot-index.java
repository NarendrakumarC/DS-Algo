class Solution {
    public int pivotIndex(int[] nums) {
        int index =-1;
        int leftsum =0;
        int rightsum =0;
        int n = nums.length;
        nums[0] = nums[0];
        for(int i =1;i<n;i++){
            nums[i] = nums[i-1]+nums[i];
        }
        for(int j=0;j<n;j++){
            if(j==0){
                leftsum =0;
            }else{
                leftsum = nums[j-1];
            }
            rightsum = nums[n-1]-nums[j];
            if(leftsum==rightsum){
                index = j;
                break;
            }
        }
        return index;
    }
}
// LeftSum and RightSum formula are derived 
/*
Note Sum of all odd index after removing current index i
Sum of even index after removing current index i
So(after removing i) = So(0 to i-1)+ Se(i+1 to N-1);
Se(after removing i) = Se(0 to i-1)+ So(i+1 to N-1);
To find PF ? PF[i] = PF[i-1]+PF[i] where i!=0;
So(after removing i) = PFo[i-1]+PFe[N-1]-PFe[i];
Se(after removing i) = PFe[i-1]+PFo[N-1]-PFo[i];
if i==0 then So(after removing i) = PFe[N-1]-PFe[i];
             Se(after removing i) = PFo[N-1]-PFo[i];
else i!=0 leftSum or So(after removing i) =  PFo[i-1];
           leftSum or Se(after removing i) = PFe[i-1];                

*/




