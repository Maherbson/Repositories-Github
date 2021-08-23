package com.maherbson.infinitescroll

interface InfiniteScrollUseCaseContract {

    operator fun invoke(
        horizontalScroll: Int,
        loadingMore: Boolean,
        childCount: Int,
        itemCount: Int,
        findFirstVisibleItemPosition: Int
    ): Boolean

}