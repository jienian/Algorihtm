import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>(); // 存储结果的列表
        int level = 0 ;
        Order(root, res, level); // 递归遍历二叉树
        return res;
    }
    public void Order(TreeNode root, List<List<Integer>> res, int level) {
        if(root == null){
            level--;
            return;
        }
        if(res.size()< level + 1 ){
            res.add(new LinkedList<>());
          
        }
        res.get(level).add(root.val);
        Order(root.left, res,level + 1 );
        Order(root.right, res ,level + 1);
    }
}