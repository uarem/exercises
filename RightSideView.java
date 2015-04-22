package main;

import java.util.*;

/**
 * Created by uarem on 4/18/2015.
 */
public class RightSideView {
    private Map<Integer, Integer> viewMap = new LinkedHashMap<Integer, Integer>();

    public List<Integer> rightSideView(TreeNode root) {
        travelTree(root, 0);
        List<Integer> result = new ArrayList<Integer>();

        for (int i=0; i<viewMap.size(); i++) result.add(viewMap.get(i));

        return result;
    }

    private void travelTree(TreeNode node, int level) {
        if (node == null)
            return;

        viewMap.put(level, node.val);

        travelTree(node.left, level+1);
        travelTree(node.right, level+1);
    }
}
