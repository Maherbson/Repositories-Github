package com.maherbson.repositoriesgithub.features.repositories.presentation

import androidx.lifecycle.viewModelScope
import com.maherbson.core.viewmodel.ViewModel
import com.maherbson.infinitescroll.InfiniteScrollUseCaseContract
import com.maherbson.network.exception.NetworkException
import com.maherbson.repositoriesgithub.R
import com.maherbson.repositoriesgithub.features.repositories.domain.usecase.RepositoriesUseCaseContract
import com.maherbson.repositoriesgithub.features.repositories.presentation.mapper.RepoMapper
import kotlinx.coroutines.launch

class RepositoriesViewModel(
    private val repositoriesUseCaseContract: RepositoriesUseCaseContract,
    private val infinityScrollContract: InfiniteScrollUseCaseContract
) : ViewModel<RepositoriesState, RepositoriesAction>(RepositoriesState()) {

    private var loadingMore = true

    init {
        getRepositories()
    }

    fun getRepositories() {
        viewModelScope.launch {
            try {
                showLoadingState(true)
                val repositories = repositoriesUseCaseContract()
                if (repositories.isNotEmpty()) {
                    showLoadingState(false)
                    setState { state ->
                        state.showRepositories(RepoMapper().map(repositories))
                    }
                    loadingMore = true
                } else {
                    showLoadingState(false)
                }
            } catch (exception: Exception) {
                handleException(exception)
                showLoadingState(false)
            }
        }
    }

    private fun showLoadingState(showLoading: Boolean) {
        setState { state -> state.showLoading(showLoading) }
    }

    private fun handleException(exception: Exception) {
        when (exception) {
            is NetworkException -> {
                setState { state ->
                    state.showMessageError(
                        R.string.ops,
                        R.string.no_connection
                    )
                }
            }
        }
    }

    fun fetchMore(
        horizontalScroll: Int,
        childCount: Int,
        itemCount: Int,
        findFirstVisibleItemPosition: Int
    ) {
        setAction {
            InfiniteScrollAction(
                horizontalScroll,
                childCount,
                itemCount,
                findFirstVisibleItemPosition
            )
        }
    }

    fun repositories(
        horizontalScroll: Int,
        childCount: Int,
        itemCount: Int,
        findFirstVisibleItemPosition: Int
    ) {

        if (infinityScrollContract(
                horizontalScroll,
                loadingMore,
                childCount,
                itemCount,
                findFirstVisibleItemPosition
            )
        ) {
            loadingMore = false
            getRepositories()
        }
    }

}