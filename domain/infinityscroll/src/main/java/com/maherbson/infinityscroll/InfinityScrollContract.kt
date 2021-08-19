package com.maherbson.infinityscroll

interface InfinityScrollContract {

    operator fun invoke(
        dy: Int,
        loadMode: Boolean,
        childCount: Int,
        itemCount: Int,
        findFirstCompletelyVisibleItemPosition: Int
    ): Boolean

}