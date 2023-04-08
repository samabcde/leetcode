package q1659

class Solution {
    enum class LivingState(val initial: Int, val neighbourChange: Int) {
        INTROVERT(120, -30),
        EXTRAVERT(40, 20),
        EMPTY(0, 0);
    }

    //    Constraints:
    //    1 <= m, n <= 5
    //    0 <= introvertsCount, extrovertsCount <= min(m * n, 6)
    //
    //    put all may be not optimal
    //    |I|I|I|
    //    -------    -> 120 * 6 - 60 * 4 - 90 * 2 = 300
    //    |I|I|I|
    //
    //    |I| |I|
    //    -------    -> 120 * 3 = 360
    //    | |I| |
    //
    //    |I|E|I|
    //    -------    -> 120 * 4 + 40 * 2 - 30 * 2 * 4 + 20 * 3 * 2
    //    |I|E|I|
    //
    //    |E|E|E|
    //    -------    -> 40 * 6 + 40 * 4 + 60 * 2 = 520
    //    |E|E|E|
    //    1. prevent neighbour for introverts
    //    2. increase neighbour for extroverts
    //    3. m*n larger -> more introverts
    //    4. m*n small -> more extroverts
    //
    //    Implementation
    //    brute force?
    //    each room, either
    //    1. introvert
    //    2. extrovert
    //    3. empty
    //    number of state = 3^(m*n) so the max is 847288609443
    //
    //    Divide and Conquer?
    //    1. only introverts
    //    2. only extroverts
    //    3. both introverts and extroverts
    fun getMaxGridHappiness(m: Int, n: Int, introvertsCount: Int, extrovertsCount: Int): Int {
        val width = m
        val height = n
        val rooms = Array(n) { Array(m) { LivingState.EMPTY } }
        var maxHappiness = 0
        val roomNum = m * n
        val maximumNumberOfPeopleWithNoNeighbour = (if (roomNum.mod(2) == 0) roomNum else roomNum + 1) / 2
        for (i in 0..introvertsCount) {
            for (j in maximumNumberOfPeopleWithNoNeighbour - introvertsCount..(m * n - i).coerceAtMost(extrovertsCount)) {
                maxHappiness = maxHappiness.coerceAtLeast(findMax(m, n, i, j))
            }
        }
        //
//        return maxHappiness

//        var lastRow = MutableList(n) { LivingState.EMPTY }
        var memory = Array(introvertsCount) {
            Array(extrovertsCount) {
                Array(Math.pow(n.toDouble(), 3.0).toInt()) {
                    -1
                }
            }
        }
//        maxHappiness = maxRow(m, n, 0, introvertsCount, extrovertsCount, 0, memory)
        var lastRows = listOf(0)
        for (i in 0 until m) {
            var result = maxRow(m, n, 0, introvertsCount, extrovertsCount, lastRows, memory)
            maxHappiness = result[0]

        }
        return maxHappiness
    }

    fun maxRow(
        m: Int,
        n: Int,
        rowIndex: Int,
        introvertsCount: Int,
        extrovertsCount: Int,
        lastRows: List<Int>,
        memory: Array<Array<Array<Int>>>
    ): (List<Int>) {
        var max = 0;
        for (i in 0 until Math.pow(n.toDouble(), 3.0).toInt()) {
            var current = 0

//            var nextToLast = maxRow(m, n, rowIndex + 1, introvertsCount, extrovertsCount, lastRow)
//            max = max.coerceAtLeast(current + nextToLast)
        }
        return emptyList()
    }

    fun calculateHappiness(lastRow: List<LivingState>, currentRow: List<LivingState>) {
        for (i in lastRow.indices) {

        }
    }

    fun maxPossibleNeighbours(m: Int, n: Int): List<Int> {
        var neighbourNums = mutableListOf<Int>()
        for (i in 1..n) {
            for (j in 1..m) {
                var numberOfNeighbour = 8
                if (i == 1) numberOfNeighbour -= 2
                if (i == n) numberOfNeighbour -= 2
                if (j == 1) numberOfNeighbour -= 2
                if (j == m) numberOfNeighbour -= 2
                neighbourNums.add(numberOfNeighbour)
            }
        }
        neighbourNums.sortDescending()
        return neighbourNums
    }

    fun findMax(m: Int, n: Int, introvertsCount: Int, extrovertsCount: Int): Int {
        var maxNeighbourForAll = maxNeighbour(m, n, introvertsCount + extrovertsCount)

        // maximize 20 * e_neighbour - 30 * i_neighbour
        // min / max neighbour for all?
        // XX
        // XX  min 0 max 8
        // I1 E3 -> I2 E6

        // minimize introverts neighbour, maximize extroverts neighbour
        // minimum neighbour for all
        // if introvertsCount+extrovertsCount = no of rooms
        // -> left side, right side, top side, bottom side ->3  corner->2 else 4
        //   e.g. 3*3 left side 1 right side 1 top side 1 bottom side 1 corner 4 centre 1 -> 24
        // try to put in diagonal
        // when even->
        //   introvertsCount+extrovertsCount <= no of room / 2 -> 0
        //   (introvertsCount+extrovertsCount - no of room / 2) put in corner(+4)->side(+6)->centre(+8) until all are put
        // when odd->
        //   introvertsCount+extrovertsCount <= (no of room + 1) / 2 -> 0
        //   (introvertsCount+extrovertsCount - (no of room + 1) / 2) put in side(+6)->centre(+8) until all are put
        // maximum neighbour for extroverts
        // pack it like square
        // EEEE  VS EEE
        // EEEE     EEE
        //          EE
        // determine shape of extroverts
        // if maximum neighbour for extroverts >= minimum neighbour
        //   good we are done, just return that
        // else target for min neighbour
        //   put room with less neighbour for introverts
        // then return that value
        val roomNum = m * n
        val totalNumberOfPeople = introvertsCount + extrovertsCount
        val maximumNumberOfPeopleWithNoNeighbour = (if (roomNum.mod(2) == 0) roomNum else roomNum + 1) / 2
        val neighbourNumsAfterHalf = neighbourNumsAfterHalf(m, n)
        val minimumNumberOfNeighbour = if (totalNumberOfPeople <= maximumNumberOfPeopleWithNoNeighbour) {
            0
        } else {
            neighbourNumsAfterHalf.subList(0, totalNumberOfPeople - maximumNumberOfPeopleWithNoNeighbour).sum()
        }
        var numOfIntrovertNeighbour: Int
        var numOfExtrovertNeighbour: Int
        val maxNeighbourOfExtrovert = maxNeighbour(m, n, extrovertsCount)
        if (minimumNumberOfNeighbour == 0) {
            numOfIntrovertNeighbour = 0
            numOfExtrovertNeighbour = maxNeighbourOfExtrovert
        } else {
            var minNeighbours = minNeighbours(m, n, totalNumberOfPeople)
            var maxNeighbours = maxNeighbours(m, n, totalNumberOfPeople)
            // this is wrong
            // IE  I 1 E 1
            // XXX  -> 14
            // XXX
            // 2E 4I  maxE -> 2  remaining E -> 6 - 2 = 4 remaining I 14 - 4 - 2 = 8
            // IEI
            // EEE -> 5 * 40 + 4 * 120 + 16 * 20 - 8 * 30 = 760
            // IEI
            // EEI
            // EEE -> 5 * 40 + 4 * 120 + 15 * 20 - 9 * 30 = 750
            // III
            for (i in neighbourNumsAfterHalf.indices) {

            }
            // X X X X X X X X
            //  X X X X X X X
            // X X X X X X X X
            //  X X X X X X X
            // X X X X X X X E
            //  X X X X X X EE
            // X X X X X X X E

            // X X X
            //  X X X
            // X X X
            //  X X X
            // EEX X
            // EE X X

            //minimumNumberOfNeighbour - maxNeighbourOfExtrovert
            numOfIntrovertNeighbour = 0
            numOfExtrovertNeighbour = maxNeighbourOfExtrovert
        }
        return (LivingState.INTROVERT.initial * introvertsCount
                + LivingState.EXTRAVERT.initial * extrovertsCount
                + LivingState.INTROVERT.neighbourChange * numOfIntrovertNeighbour
                + LivingState.EXTRAVERT.neighbourChange * numOfExtrovertNeighbour)
    }

    data class Point(val x: Int, val y: Int) {
        fun up(): Point {
            return Point(this.x, this.y - 1)
        }

        fun down(): Point {
            return Point(this.x, this.y + 1)
        }

        fun left(): Point {
            return Point(this.x - 1, this.y)
        }

        fun right(): Point {
            return Point(this.x + 1, this.y)
        }

        fun neighbours(): List<Point> {
            return listOf(up(), down(), left(), right())
        }
    }

    // ascending list of neighbours
    inline fun minNeighbours(m: Int, n: Int, total: Int): Map<Int, Int> {

        val roomNum = m * n
        val maximumNumberOfPeopleWithNoNeighbour = (if (roomNum.mod(2) == 0) roomNum else roomNum + 1) / 2
        if (total == 0 || total <= maximumNumberOfPeopleWithNoNeighbour) {
            return mutableMapOf(
                Pair(0, total),
                Pair(1, 0),
                Pair(2, 0),
                Pair(3, 0),
                Pair(4, 0)
            )
        }
        var neighbourNumToCountMap = mutableMapOf(
            Pair(0, 0),
            Pair(1, 0),
            Pair(2, 0),
            Pair(3, 0),
            Pair(4, 0),
        )

        var pointToNeighbourNum = mapOf<Point, Int>().toMutableMap()
        for (i in 1..n) {
            for (j in 1..m) {
                if (i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1) {
                    var point = Point(i, j)
                    pointToNeighbourNum.put(point, 0)
                }
            }
        }
        var neighbourNumToAfterHalfPointMap = mutableMapOf(
            Pair(0, mutableListOf<Point>()),
            Pair(1, mutableListOf()),
            Pair(2, mutableListOf()),
            Pair(3, mutableListOf()),
            Pair(4, mutableListOf())
        )
        for (i in 1..n) {
            for (j in 1..m) {
                var point = Point(i, j)
                var numberOfNeighbour = 4
                if (i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1) {
                    continue
                }
                if (i == 1) numberOfNeighbour -= 1
                if (i == n) numberOfNeighbour -= 1
                if (j == 1) numberOfNeighbour -= 1
                if (j == m) numberOfNeighbour -= 1
                neighbourNumToAfterHalfPointMap.get(numberOfNeighbour)?.add(point)
            }
        }
        var toAdd = total - maximumNumberOfPeopleWithNoNeighbour
        for (i in 0..4) {
            if (toAdd == 0) {
                break
            }
            var pointsToAdd = neighbourNumToAfterHalfPointMap.getOrDefault(i, emptyList())
            for (point in pointsToAdd) {
                point.neighbours().forEach {
                    pointToNeighbourNum.computeIfPresent(it) { _, v -> v + 1 }
                }
                neighbourNumToCountMap.putIfAbsent(i, 0)
                neighbourNumToCountMap.computeIfPresent(i) { _, v -> v + 1 }
                toAdd--
                if (toAdd == 0) {
                    break
                }
            }
        }
        pointToNeighbourNum.values.forEach {
            neighbourNumToCountMap.computeIfPresent(it) { _, v -> v + 1 }
        }
        return neighbourNumToCountMap
    }

    inline fun maxNeighbours(m: Int, n: Int, total: Int): Map<Int, Int> {
        if (total == 0) {
            return mutableMapOf(
                Pair(0, 0),
                Pair(1, 0),
                Pair(2, 0),
                Pair(3, 0),
                Pair(4, 0)
            )
        }
        // make rectangle -> close to square
        // 5*5
        // 8 XXXX 20 XXX 2 2 2 3 3 2 2 4 -> 20
        //   XXXX    XXX
        //           XX
        var min = m.coerceAtMost(n)

        var a = min
        for (i in 0..min) {
            if (i * i >= total) {
                a = i
                break
            }
        }
        val width = total / a
        val height = a
        val remain = total % a
        var neighbourNumToCountMap = neighboursOfRectangle(width, height)
        for (i in 1..remain) {
            if (i == 1) {
                neighbourNumToCountMap.put(2, neighbourNumToCountMap.getOrDefault(2, 0) - 1)
                neighbourNumToCountMap.put(3, neighbourNumToCountMap.getOrDefault(3, 0) + 1)
                neighbourNumToCountMap.put(2, neighbourNumToCountMap.getOrDefault(2, 0) + 1)
            } else {
                neighbourNumToCountMap.put(3, neighbourNumToCountMap.getOrDefault(3, 0) - 1)
                neighbourNumToCountMap.put(4, neighbourNumToCountMap.getOrDefault(4, 0) + 1)
                neighbourNumToCountMap.put(3, neighbourNumToCountMap.getOrDefault(3, 0) + 1)
            }
        }
        return neighbourNumToCountMap
    }

    inline fun maxNeighbour(m: Int, n: Int, num: Int): Int {
        // make rectangle -> close to square
        // 5*5
        // 8 XXXX 20 XXX 2 2 2 3 3 2 2 4 -> 20
        //   XXXX    XXX
        //           XX
        var min = m.coerceAtMost(n)

        var a = min
        for (i in 0..min) {
            if (i * i >= num) {
                a = i
                break
            }
        }
        var b = neighbourOfSquare(a)
        if (min * min >= num) {
            // XXX        XX        XXX           X       XX
            // XXX -> 24  XXX -> 12 XXX -> 14    XXX -> 8 XXX -> 10
            // XXX         X                      X
            // remove from lower left corner to lower right corner
            // -4 -4 .... -4 -2(lower right corner)
            // -4 -4 .... -4 -2(upper right corner)
            val numToRemove = a * a - num
            for (i in 1..numToRemove) {
                b -= if (i == a || i == 2 * a - 1) {
                    2
                } else {
                    4
                }
            }
        } else {
            val numToAdd = num - min * min
            for (i in 1..numToAdd) {
                b += if (i % min == 1 || min == 1) {
                    2
                } else {
                    4
                }
            }
        }
        return b
    }

    inline fun neighbourOfSquare(i: Int): Int {
        // 1 -> 0
        // 2 -> 4 * 2 8
        // 3 -> 4 * 2 + 4 * 3 + 1 * 4 = 24
        // 4 -> 4 * 2 + 8 * 3 + 4 * 4 = 48
        // 5 -> 4 * 2 + 12 * 3 + 9 * 4 = 80
        return (4 * 2) + (4 * (i - 2) * 3) + ((i - 2) * (i - 2) * 4)
    }

    inline fun neighboursOfRectangle(width: Int, height: Int): MutableMap<Int, Int> {
        // 1 -> 0
        // 2 -> 4 * 2 8
        // 3 -> 4 * 2 + 4 * 3 + 1 * 4 = 24
        // 4 -> 4 * 2 + 8 * 3 + 4 * 4 = 48
        // 5 -> 4 * 2 + 12 * 3 + 9 * 4 = 80
//        return if (i == 1) {
//            mutableMapOf(Pair(0, 1))
//        } else if (i == 2) {
//            mutableMapOf(Pair(2, 4))
//        } else {
//            mutableMapOf(Pair(2, 4), Pair(3, 4 * (i - 2)), Pair(4, (i - 2) * (i - 2)))
//        }
        return mutableMapOf(
            Pair(0, if (height == 1 && width == 1) 1 else 0),
            Pair(1, if (height == 1 && width > 1) 2 else 0 + if (height > 1 && width == 1) 2 else 0),
            Pair(
                2,
                if (width >= 2 && height >= 2) 4 else (if (height == 1 && width > 1) width - 2 else if (width == 1 && height > 1) height - 2 else 0)
            ),
            Pair(
                3,
                2 * (if (height >= 2 && width > 2) width - 2 else 0) + 2 * (if (height > 2 && width >= 2) height - 2 else 0)
            ),
            Pair(
                4, (if (height > 2 && width > 2) width - 2 else 0
                        ) * (if (height > 2 && width > 2) height - 2 else 0)
            )
        )
    }

    inline fun neighboursOfSquare(i: Int): MutableMap<Int, Int> {
        // 1 -> 0
        // 2 -> 4 * 2 8
        // 3 -> 4 * 2 + 4 * 3 + 1 * 4 = 24
        // 4 -> 4 * 2 + 8 * 3 + 4 * 4 = 48
        // 5 -> 4 * 2 + 12 * 3 + 9 * 4 = 80
        return if (i == 1) {
            mutableMapOf(Pair(0, 1))
        } else if (i == 2) {
            mutableMapOf(Pair(2, 4))
        } else {
            mutableMapOf(Pair(2, 4), Pair(3, 4 * (i - 2)), Pair(4, (i - 2) * (i - 2)))
        }
    }

    inline fun neighbourNumsAfterHalf(m: Int, n: Int): List<Int> {
        var neighbourNums = mutableListOf<Int>()
        for (i in 1..n) {
            for (j in 1..m) {
                var numberOfNeighbour = 8
                if (i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1) {
                    continue
                }
                if (i == 1) numberOfNeighbour -= 2
                if (i == n) numberOfNeighbour -= 2
                if (j == 1) numberOfNeighbour -= 2
                if (j == m) numberOfNeighbour -= 2
                neighbourNums.add(numberOfNeighbour)
            }
        }
        neighbourNums.sort()
        return neighbourNums
    }

    inline fun calculateHappiness(rooms: Array<Array<LivingState>>): Int {
        var happiness = 0
        for (i in rooms.indices) {
            for (j in rooms[i].indices) {
                var current = rooms[i][j]
                var up = if (i > 0) rooms[i - 1][j] else LivingState.EMPTY
                var down = if (i < rooms.size - 1) rooms[i + 1][j] else LivingState.EMPTY
                var left = if (j > 0) rooms[i][j - 1] else LivingState.EMPTY
                var right = if (j < rooms[i].size - 1) rooms[i][j + 1] else LivingState.EMPTY
                happiness += current.initial + current.neighbourChange *
                        listOf(up, down, left, right).filter { s -> s != LivingState.EMPTY }.count()
            }
        }
        return happiness
    }

}
