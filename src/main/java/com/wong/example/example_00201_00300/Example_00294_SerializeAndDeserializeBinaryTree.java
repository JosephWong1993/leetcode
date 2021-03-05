package com.wong.example.example_00201_00300;

import com.wong.model.TreeNode;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
@Component
public class Example_00294_SerializeAndDeserializeBinaryTree {

    //region 方法一：深度优先搜索
    // Encodes a tree to a single string.
    public String serialize_1(final TreeNode root) {
        return rSerialize(root, "").toString();
    }

    private String rSerialize(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += (root.val + ",");
            str = rSerialize(root.left, str);
            str = rSerialize(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize_1(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        return rDeserialize(dataList);
    }

    private TreeNode rDeserialize(List<String> list) {
        if (list.size() == 0) {
            return null;
        }
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = rDeserialize(list);
        root.right = rDeserialize(list);
        return root;
    }

    //endregion

    //region 方法二：括号表示编码 + 递归下降解码
    // Encodes a tree to a single string.
    public String serialize_2(TreeNode root) {
        if (root == null) {
            return "X";
        }
        String l = "(" + serialize_2(root.left) + ")";
        String r = "(" + serialize_2(root.right) + ")";
        return l + root.val + r;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize_2(String data) {
        int[] ptr = {0};
        return parse(data, ptr);
    }

    private TreeNode parse(String data, int[] ptr) {
        if (data.charAt(ptr[0]) == 'X') {
            ptr[0]++;
            return null;
        }
        TreeNode cur = new TreeNode(0);
        cur.left = parseSubtree(data, ptr);
        cur.val = parseInt(data, ptr);
        cur.right = parseSubtree(data, ptr);
        return cur;
    }

    private TreeNode parseSubtree(String data, int[] ptr) {
        ptr[0]++;   //跳过左括号
        TreeNode subtree = parse(data, ptr);
        ptr[0]++;   //跳过右括号
        return subtree;
    }

    private int parseInt(String data, int[] ptr) {
        int x = 0, sgn = 1;
        //判断是否为负值
        if (!Character.isDigit(data.charAt(ptr[0]))) {
            sgn = -1;
            ptr[0]++;
        }
        while (Character.isDigit(data.charAt(ptr[0]))) {
            x = x * 10 + (data.charAt(ptr[0]++) - '0');
        }
        return sgn * x;
    }
    //endregion
}
