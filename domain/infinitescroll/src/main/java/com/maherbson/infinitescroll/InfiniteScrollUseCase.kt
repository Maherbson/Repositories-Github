package com.maherbson.infinitescroll

private const val INITIAL_HORIZONTAL_SCROLL = 0

class InfiniteScrollUseCase : InfiniteScrollUseCaseContract {

    override fun invoke(
        horizontalScroll: Int,
        loadingMore: Boolean,
        childCount: Int,
        itemCount: Int,
        findFirstVisibleItemPosition: Int
    ): Boolean {
        if (horizontalScroll > INITIAL_HORIZONTAL_SCROLL) {
            if (loadingMore) {
                if ((childCount + findFirstVisibleItemPosition) >= itemCount) {
                    return true
                }
            }
        }
        return false
    }
}