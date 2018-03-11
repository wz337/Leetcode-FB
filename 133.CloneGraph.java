/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
//Questions to ask: the labels are unique, meaning the numbers are unique
//Time: O(V + E)
//Space: O(V) hashmap
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        //key: original node, value: copied node
        Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();
        return dfs(node, visited);
    }
    private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        if(node == null) {  //base case: if the node is empty
            return null;
        }
        if (map.containsKey(node)) { //base case: the node has already been cloned
            return map.get(node);
        }
        //When a new node is created, put it in the map.
        UndirectedGraphNode duplicate = new UndirectedGraphNode(node.label);
        map.put(node, duplicate);
        for (UndirectedGraphNode nei : node.neighbors) {    //traverse all its neighbor node too see if they have been cloned
            UndirectedGraphNode dupNei = dfs(nei, map);
            duplicate.neighbors.add(dupNei);
        }
        return duplicate;
    }
    /*
        1 -- 2
        |
        |
        3 -- 5
        
        1: 2 3
        2: 1
        3: 1 5
        5: 3
        
        1 : 1
        2 : 2  2's neighbor is already there, put in it its neighbors and return
        3 : 3
        5 : 5 
    */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        List<UndirectedGraphNode> list = bfs(node); //gets a unique set of original node, already dedup
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        for (UndirectedGraphNode cur : list) {
            UndirectedGraphNode newCur = new UndirectedGraphNode(cur.label);
            map.put(cur, newCur);
        }
        for (UndirectedGraphNode cur : list) {
            UndirectedGraphNode newCur = map.get(cur);
            for (UndirectedGraphNode nei : cur.neighbors) {
                newCur.neighbors.add(map.get(nei));
            }
        }
        return map.get(node);
    }
    
    /*
       old: 1 2 3 5
       new: 1 2 3 5 /edges haven't been created yet
       from the old neighbors, we know what the neighbors of the new neighbors are.
       old: 1: 2 3  New: 1: 2 3
       
    */
    //bfs returns a list of all the nodes in the original graph
    private List<UndirectedGraphNode> bfs(UndirectedGraphNode node) {
        Set<UndirectedGraphNode> set = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        set.add(node);
        queue.offer(node);   
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode nei : cur.neighbors) {
                if (!set.contains(nei)) {
                    queue.offer(nei);
                    set.add(nei);
                }
            }
        }
        return new ArrayList<UndirectedGraphNode>(set);
    }
}
