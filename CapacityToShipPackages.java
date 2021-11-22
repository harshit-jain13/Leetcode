class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int low = Integer.MIN_VALUE, high = 0;
        
        for(int i = 0; i < weights.length; i++){
            low = Math.max(weights[i], low);
            high += weights[i];
        }
        int ans = -1;
        while(low <= high){
            int mid = (low + high)/2;
            
            int daysTaken = countDays(mid, weights);
            
            if(daysTaken > days){
                low = mid + 1;
            }else{
                int dayssTaken = countDays(mid-1, weights);
                if(dayssTaken > days){
                    ans = mid;
                    break;
                }else{
                    high = mid - 1;
                }
            }
            
        }
        
        return ans;
    }
    
    public int countDays(int totalWeight, int[] weights){
        
        int days = 0;
        int temp = totalWeight;
        for(int i = 0; i < weights.length; i++){
            temp -= weights[i];
            if(temp < 0){
                days += 1;
                temp = totalWeight - weights[i];
                if(temp < 0){
                    return Integer.MAX_VALUE;
                }
            }
        }
        return days+1;
    }
    
}
