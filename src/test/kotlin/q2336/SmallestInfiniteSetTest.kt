package q2336

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class SmallestInfiniteSetTest {

    private var set: SmallestInfiniteSet = SmallestInfiniteSet()

    @Test
    fun given_newSet_when_popSmallest_should_return_1() {
        assertEquals(1, set.popSmallest())
    }

    @Test
    fun given_newSet_when_popSmallest2Times_should_return_2() {
        set.popSmallest()
        assertEquals(2, set.popSmallest())
    }

    @Test
    fun given_newSet_when_popSmallest1000Times_should_return_1000() {
        for (i in 1..999) {
            set.popSmallest()
        }
        assertEquals(1000, set.popSmallest())
    }

    @Test
    fun given_newSet_when_popSmallest1001Times_should_throwIllegalStateException() {
        for (i in 1..1000) {
            set.popSmallest()
        }
        assertThrows<IllegalStateException> {
            set.popSmallest()
        }
    }

    @Test
    fun given_newSet_popSmallest500Times_when_addBack1_then_popSmallest_should_return1(){
        for (i in 1..500) {
            set.popSmallest()
        }
        set.addBack(1)
        assertEquals(1, set.popSmallest())
    }
}