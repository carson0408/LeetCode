package medium.FindLargestValueinEachTreeRow;

import java.util.ArrayList;
import java.util.List;

/**
 * You need to find the largest value in each row of a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * Output: [1, 3, 9]
 */

/**
 * 该题求每一层的最大值，就是二叉树的层序遍历，并求出每一层的最大值。
 */
public class Solution {
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> list = new ArrayList<Integer>();//存放结果
        if(root==null)
            return list;
        List<TreeNode> nodes = new ArrayList<TreeNode>();//遍历节点时存放节点
        int k = 0;
        nodes.add(root);
        nodes.add(null);
        list.add(root.val);
        int temp =  Integer.MIN_VALUE;
        boolean flag = false;//作为标记位，避免temp等于Integer.MIN_VALUE的情景
        while(k<nodes.size()){
            TreeNode node = nodes.get(k);
            if(node == null){
                if(k!=nodes.size()-1){
                    nodes.add(null);
                }
                if(temp!=Integer.MIN_VALUE||flag == true)
                    list.add(temp);
                temp = Integer.MIN_VALUE;
                flag = false;
            }
            else {//确保当前节点不为空
                if (node.left != null) {
                    nodes.add(node.left);
                    temp = Math.max(node.left.val, temp);
                    flag = true;
                }
                if (node.right != null) {
                    nodes.add(node.right);
                    temp = Math.max(node.right.val, temp);
                    flag = true;
                }
            }
            k++;
        }
        return list;


    }
}
