class Solution {
    int[] parent;

    public int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public void union(int x,int y){
        int px = find(x);
        int py = find(y);
        if(px != py){
            parent[py] = px;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        Map<String,Integer> emailMap = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String email = accounts.get(i).get(j);
                if(!emailMap.containsKey(email)){
                    emailMap.put(email,i);
                }
                else{
                    union(emailMap.get(email),i);
                }
            }
        }

        HashMap<Integer,List<String>> merged = new HashMap<>();
        for(String email : emailMap.keySet()){
            int parentnode = find(emailMap.get(email));
            merged.putIfAbsent(parentnode,new ArrayList<>());
            merged.get(parentnode).add(email);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int parentnode : merged.keySet()){
            List<String> list = merged.get(parentnode);
            Collections.sort(list);
            List<String> account = new ArrayList<>();
            account.add(accounts.get(parentnode).get(0));
            account.addAll(list);
            ans.add(account);
        }
        return ans;
    }
}