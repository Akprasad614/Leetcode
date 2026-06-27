/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {                                              // GOOGLE FACEBOOK AMAZON

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(root,list);
        StringBuilder str = new StringBuilder();
        for(String s : list){
            str.append(s).append(",");
        }
        return str.toString();

    }
    void helper(TreeNode root,List<String> list){
        if(root == null){
            list.add("null");
            return;
        }
        list.add(String.valueOf(root.val));

        helper(root.left,list);
        helper(root.right,list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] arr = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        return helper2(list);
    }

    TreeNode helper2(List<String> list){
        if(list.size() == 0){
            return null;
        }

        String root = list.remove(0);
        if(root.equals("null")){
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(root));
        node.left = helper2(list);
        node.right = helper2(list);
        return node;
    }
}






// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));






// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));