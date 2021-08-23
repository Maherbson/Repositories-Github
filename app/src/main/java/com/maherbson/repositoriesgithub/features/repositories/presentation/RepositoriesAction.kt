package com.maherbson.repositoriesgithub.features.repositories.presentation

import com.maherbson.core.viewmodel.Action

sealed class RepositoriesAction : Action
data class InfiniteScrollAction(
    val horizontalScroll: Int,
    val childCount: Int,
    val itemCount: Int,
    val findFirstVisibleItemPosition: Int
) : RepositoriesAction()