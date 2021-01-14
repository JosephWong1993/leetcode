package com.wong.example;

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
    // TODO：需要继续学习
    //endregion
}
