package q1377

class Solution {
    // 1 <= n <= 100
    // edges.length == n - 1
    // edges[i].length == 2
    // 1 <= ai, bi <= n
    // 1 <= t <= 50
    // 1 <= target <= n
    fun frogPosition(n: Int, edges: Array<IntArray>, t: Int, target: Int): Double {
        if (n == 1) {
            return 1.0
        }
        val map = (1..n).map { TreeNode(it) }.associateBy { treeNode -> treeNode.value }
        val root = map[1]!!
        setChildren(root, map, edges)
        val path = computePath(treeNode = root, listOf(), target)
        if (path.size > t + 1) {
            return 0.0;
        } else if (path.size == t + 1 || (path.size < t + 1 && map[target]!!.children!!.isEmpty())) {
            return (0 until path.size - 1).map { 1.0.div(map[path[it]]!!.children!!.size) }
                .reduce(Double::times)
        } else {
            return 0.0;
        }

    }

    fun setChildren(treeNode: TreeNode, map: Map<Int, TreeNode>, edges: Array<IntArray>) {
        if (treeNode.children != null) {
            return
        }
        val treeNodes = edges
            .filter {
                it[0] == treeNode.value || it[1] == treeNode.value
            }.map {
                if (it[0] == treeNode.value) it[1] else it[0]
            }.map {
                map[it]!!
            }.filter {
                it.children == null
            }
        treeNode.children = treeNodes
        treeNode.children!!.forEach { setChildren(it, map, edges) }
    }

    fun computePath(treeNode: TreeNode, prev: List<Int>, target: Int): List<Int> {
        if (treeNode.value == target) {
            return prev + treeNode.value
        }
        if (treeNode.children!!.isEmpty()) {
            return listOf()
        }
        return treeNode.children!!.map { computePath(it, prev + treeNode.value, target) }
            .firstOrNull { it.isNotEmpty() } ?: listOf()
    }

    data class TreeNode(
        val value: Int,
        var children: List<TreeNode>? = null
    )
}