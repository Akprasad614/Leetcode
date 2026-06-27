/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Deque <TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        boolean reverse = false;

        while(!deque.isEmpty()){
            int levelsize = deque.size();
            List<Integer> currentlevel = new ArrayList<>(levelsize);

            for(int i=0;i<levelsize;i++){
                if(!reverse){
                    TreeNode currentnode = deque.pollFirst();
                    currentlevel.add(currentnode.val);
                    if(currentnode.left != null){
                        deque.addLast(currentnode.left);
                    }
                    if(currentnode.right != null){
                        deque.addLast(currentnode.right);
                    }
                }
                else{
                   TreeNode currentnode = deque.pollLast();
                    currentlevel.add(currentnode.val);
                    if(currentnode.right != null){
                        deque.addFirst(currentnode.right);
                    } 
                    if(currentnode.left != null){
                        deque.addFirst(currentnode.left);
                    }
                }
            }
            reverse = !reverse;
            result.add(currentlevel);
        }
        return result;
    }
}

// List<List<Integer>> result = new ArrayList<>();

//         if(root == null){
//             return result;
//         }
//         Deque<TreeNode> deque = new LinkedList<>();
//         deque.offer(root);
//         boolean reverse = false;

//         while(!deque.isEmpty()){
//             int levelsize = deque.size();
//             List<Integer> currentlevel = new ArrayList<>(levelsize);
//             for(int i = 0; i< levelsize; i++){

//                 if(!reverse){
//                     TreeNode currentnode = deque.pollFirst();
//                     currentlevel.add(currentnode.val);
//                     if(currentnode.left != null){
//                         deque.addLast(currentnode.left);
//                     }
//                     if(currentnode.right != null){
//                         deque.addLast(currentnode.right);
//                     }
//                 }
//                 else{
//                     TreeNode currentnode = deque.pollLast();
//                     currentlevel.add(currentnode.val);
//                     if(currentnode.right != null){
//                         deque.addFirst(currentnode.right);
//                     }
//                     if(currentnode.left != null){
//                         deque.addFirst(currentnode.left);
//                     }
//                 }
//             }
//             reverse = !reverse;
//             result.add(currentlevel);
//         }
//         return result;