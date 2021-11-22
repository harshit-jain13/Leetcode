/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        int low = 0, high = mountainArr.length()-1;
        int mid = 0;
        while(low <= high){
            mid = (low+high)/2;
            if(mid==0){
                mid+=1;
                break;
            }
            if(mid==mountainArr.length()-1){
                mid-=1;
                break;
            }
            int left = mountainArr.get(mid-1);
            int right = mountainArr.get(mid+1);
            int peak = mountainArr.get(mid);
            
            if(peak > left && peak > right){
                break;
            }
            if(peak > left && peak < right){
                low = mid + 1;
            }
            if(peak < left && peak > right){
                high = mid - 1;
            }
        }
        
       if(target > mountainArr.get(mid)){
           return -1;
       } 
       int peak = mid;
       boolean found = false;
       low = 0; high = peak;
       while(low <= high){
           mid = (low+high)/2;
           int midElement = mountainArr.get(mid);
           if(midElement == target){
               return mid;
           }
           if(midElement < target){
               low = mid + 1;
           }else{
               high = mid - 1;
           }
       }
        
       low = peak+1; high = mountainArr.length()-1;
       while(low <= high){
           mid = (low+high)/2;
           int midElement = mountainArr.get(mid);
           if(midElement == target){
               return mid;
           }
           if(midElement < target){
               high = mid - 1;
           }else{
               low = mid + 1;
           }
       }
       return -1;
    }
}
