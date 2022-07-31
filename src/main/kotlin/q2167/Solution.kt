package q2167


class Solution {
    fun minimumTime(s: String): Int {
        return min(s)
    }

    open class Group(character: Char, count: Int) {
        var leftZero: Int = 0
        var rightZero: Int = 0
        var character: Char = character
        var count: Int = count
        fun getTime(step: Step): Int {
            return when (step) {
                Step.LEFT -> leftZero + count
                Step.RIGHT -> rightZero + count
                Step.ANY -> count * 2
            }
        }
    }

    enum class Step {
        LEFT, RIGHT, ANY
    }

    private fun min(s: String): Int {
        var groups: MutableList<Group> = emptyList<Group>().toMutableList()
        var c = s.toCharArray().toMutableList()
        if (c.isEmpty()) {
            return 0
        }
        var count = 1;
        for (i in c.indices) {
            if (i == c.size - 1) {
                groups.add(Group(c[i], count))
                continue
            }
            if (c[i] == c[i + 1]) {
                count++
            } else {
                groups.add(Group(c[i], count))
                count = 1;
            }
        }
        for (i in groups.indices) {
            if (groups[i].character != '1') {
                continue
            }
            if (i == 0) {
                groups[i].leftZero = 0;
            } else {
                groups[i].leftZero = groups[i - 1].count
            }
            if (i == groups.size - 1) {
                groups[i].rightZero = 0;
            } else {
                groups[i].rightZero = groups[i + 1].count
            }
        }
        groups = groups.filter { it -> it.character == '1' }.toMutableList()
        System.out.println("groups num: " + groups.size)
        return minOfGroups(groups)
    }

    fun minOfGroups(groups: List<Group>): Int {

        var minLeft = 0
        var minRight = 0
        var minLeftIndexs = mutableListOf<Int>()
        var minRightIndexs = mutableListOf<Int>()

        var allAny = groups.map { it -> it.getTime(Step.ANY) }.sum()

        var replace = 0;

        replace = allAny
        minLeft = allAny
        for (i in groups.indices) {
            replace = replace - groups[i].getTime(Step.ANY) + groups[i].getTime(Step.LEFT);
            if (replace <= minLeft) {
                minLeft = replace
                minLeftIndexs.add(i)
            }
        }
        replace = allAny
        minRight = allAny
        for (i in groups.indices.reversed()) {
            replace = replace - groups[i].getTime(Step.ANY) + groups[i].getTime(Step.RIGHT);
            if (replace <= minRight) {
                minRight = replace
                minRightIndexs.add(i)
            }
        }
//        System.out.println("allAny: $allAny, minLeft: $minLeft, minRight: $minRight, minLeftIndexs.size: ${minLeftIndexs.size}, minRightIndexs.size: ${minRightIndexs.size}")
        if (minLeftIndexs.isEmpty() || minLeftIndexs.isEmpty() || minLeftIndexs.last() < minLeftIndexs.last()) {
            return allAny - (allAny - minLeft) - (allAny - minRight)
        }
        minLeftIndexs.add(0, -1)
        minRightIndexs.add(0, groups.size)
        var minLeftRight = allAny;
        for (minLeftIndex in minLeftIndexs.reversed()) {
            for (minRightIndex in minRightIndexs.reversed().filter { i -> i > minLeftIndex }) {
//                System.out.println("minLeftIndex: $minLeftIndex, minRightIndex: $minRightIndex")
                var value = 0;
                for (i in groups.indices) {
                    value += if (i <= minLeftIndex) {
                        groups[i].getTime(Step.LEFT)
                    } else if (i >= minRightIndex) {
                        groups[i].getTime(Step.RIGHT)
                    } else {
                        groups[i].getTime(Step.ANY)
                    }
                }
                if (value < minLeftRight) {
                    minLeftRight = value
                } else {
                    break
                }
            }
        }
        return minLeftRight
    }
}