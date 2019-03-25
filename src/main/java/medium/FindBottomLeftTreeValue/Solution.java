package medium.FindBottomLeftTreeValue;

import java.util.ArrayList;

/**
 *  Given a binary tree, find the leftmost value in the last row of the tree.
 *
 * Example 1:
 *
 * Input:
 *
 *     2
 *    / \
 *   1   3
 *
 * Output:
 * 1
 *
 * Example 2:
 *
 * Input:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * Output:
 * 7
 *
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        int k = 0;
        list.add(root);
        list.add(null);
        boolean flag = false;
        int ans=root.val;//初始值是根节点的值
        while(k<list.size()) {
            TreeNode node = list.get(k);
            if (node == null) {
                flag = false;
                if (k!=list.size()-1) {//终止条件，如果k=list.size()-1，那么即使node==null，也不再添加null


                    list.add(null);

                }
            }
            else {//判断当前节点是否有左右子节点，每一层选出最左的节点。
                if (node.left != null) {
                    if (!flag) {

                        ans = node.left.val;
                        flag = true;
                    }
                    list.add(node.left);

                }
                if (node.right != null) {
                    if (!flag) {

                        ans = node.right.val;
                        flag = true;
                    }
                    list.add(node.right);
                }


            }
            k++;
        }

        return ans;

    }
}
