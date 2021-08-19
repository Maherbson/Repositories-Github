package com.maherbson.infinityscroll

class InfinityScroll : InfinityScrollContract {

    override fun invoke(
        dy: Int,
        loadMode: Boolean,
        childCount: Int,
        itemCount: Int,
        findFirstCompletelyVisibleItemPosition: Int
    ): Boolean {
        return (
                (dy > 0) &&
                        loadMode &&
                        (childCount + findFirstCompletelyVisibleItemPosition) >= itemCount
                )
    }
}