package q2336

class SmallestInfiniteSet() {
    var isTaken: BooleanArray = BooleanArray(1000);
    fun popSmallest(): Int {
        for (i in 0..999) {
            if (!isTaken[i]) {
                isTaken[i] = true
                return i + 1
            }
        }
        throw IllegalStateException("all are taken");
    }

    fun addBack(num: Int) {
        isTaken[num - 1] = false
    }

}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * var obj = SmallestInfiniteSet()
 * var param_1 = obj.popSmallest()
 * obj.addBack(num)
 */