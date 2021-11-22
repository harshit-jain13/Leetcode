class Solution {
    public boolean judgePoint24(int[] cards) {
        
        List<Double> list = new ArrayList<>();
        for(int card : cards){
            list.add((double) card);
        }
        
        return dfs(list);
    }
    
    
    public boolean dfs(List<Double> cards){
        
        if(cards.size() == 1){
            if(Math.abs(cards.get(0) - 24*1.0) < 0.001){
                return true;
            }
        }
        
        for(int i = 0; i < cards.size(); i++){
            for(int j = i+1; j < cards.size(); j++){
                List<Double> operations = getOperations((double)cards.get(i), (double)cards.get(j));
                
                for(Double operation : operations){
                    List<Double> temp = new ArrayList<>();
                    temp.add(operation);
                    for(int k = 0; k < cards.size(); k++){
                        if(k != i && k != j){
                            temp.add(cards.get(k));
                        }
                    }
                    if(dfs(temp)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    
    public List<Double> getOperations(double i, double j){
        
        List<Double> li = new ArrayList<>();
        li.add(i + j);
        li.add(i - j);
        li.add(j - i);
        li.add(i * j);
        li.add(i / j);
        li.add(j / i);
        return li;
        
    }
    
}
