class Solution {
    Map<Integer,Integer> parent = new HashMap<>();

    public int find(int x){
        parent.putIfAbsent(x,x);
        if(parent.get(x) != x){
            parent.put(x,find(parent.get(x)));
        }
        return parent.get(x);
    } 

    public void union(int x, int y){
        parent.put(find(x),find(y));
    }

    public int removeStones(int[][] stones) {
        for(int[] stone : stones){
            union(stone[0],stone[1] + 10001);
        }

        HashSet<Integer> components = new HashSet<>();
        for(int[] stone : stones){
            components.add(find(stone[0]));
        }
        return stones.length - components.size();
    }
}