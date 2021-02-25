package com.wong.example.example_00101_00200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 133. 克隆图
 * https://leetcode-cn.com/problems/clone-graph/
 */
public class Example_00133_CloneGraph {
    //region 方法一：深度优先搜索
    public Node cloneGraph_1(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        return dfsCloneGraph(map, node);
    }
    
    private Node dfsCloneGraph(HashMap<Node, Node> map, Node node) {
        if (node == null) {
            return null;
        }
        
        if (map.containsKey(node)) {
            return map.get(node);
        }
        
        Node copyNode = new Node(node.val, new ArrayList<>());
        map.put(node, copyNode);
        
        for (Node neighbor : node.neighbors) {
            copyNode.neighbors.add(dfsCloneGraph(map, neighbor));
        }
        return copyNode;
    }
    //endregion
    
    //TODO：方法二：广度优先遍历
    public Node cloneGraph_2(Node node) {
        if (node == null) {
            return node;
        }
        
        HashMap<Node, Node> visited = new HashMap<>();
        
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.put(node, new Node(node.val, new ArrayList<>()));
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            for (Node neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}

// Definition for a Node.
class Node {
    public int val;
    
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}