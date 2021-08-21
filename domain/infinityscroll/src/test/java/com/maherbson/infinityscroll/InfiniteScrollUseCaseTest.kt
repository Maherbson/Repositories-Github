package com.maherbson.infinityscroll

import org.junit.Assert.assertEquals
import org.junit.Test

class InfiniteScrollUseCaseTest {

    var infiniteScrollUseCase: InfiniteScrollUseCase = InfiniteScrollUseCase()

    @Test
    fun `infinityScroll Should return true When Scroll is in the end`() {
        val isEnd = infiniteScrollUseCase(
            1,
            true,
            9,
            30,
            22
        )

        assertEquals(isEnd, true)
    }

    @Test
    fun `infinityScroll Should return false When Scroll is not in the end`() {
        val isNotEnd = infiniteScrollUseCase(
            0,
            true,
            9,
            15,
            22
        )

        assertEquals(isNotEnd, false)
    }
}
