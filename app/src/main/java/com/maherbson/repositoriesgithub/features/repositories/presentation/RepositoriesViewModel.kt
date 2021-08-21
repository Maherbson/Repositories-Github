package com.maherbson.repositoriesgithub.features.repositories.presentation

import androidx.lifecycle.viewModelScope
import com.maherbson.core.viewmodel.ViewModelState
import com.maherbson.infinityscroll.InfiniteScrollUseCaseContract
import com.maherbson.network.exception.NetworkException
import com.maherbson.repositoriesgithub.R
import com.maherbson.repositoriesgithub.features.repositories.domain.usecase.RepositoriesUseCaseContract
import com.maherbson.repositoriesgithub.features.repositories.presentation.mapper.RepoMapper
import kotlinx.coroutines.launch

class RepositoriesViewModel(
    private val repositoriesUseCaseContract: RepositoriesUseCaseContract,
    private val infinityScrollContract: InfiniteScrollUseCaseContract
) : ViewModelState<RepositoriesState>(RepositoriesState()) {

    private var loadingMore = true

    init {
        getRepositories()
    }

    fun getRepositories() {
        viewModelScope.launch {
            try {
                setState { state -> state.showLoading(true) }
                val repositories = repositoriesUseCaseContract()
                if (repositories.isNotEmpty()) {
                    setState { state -> state.showLoading(false) }
                    setState { state -> state.showRepositories(RepoMapper().map(repositories)) }
                    loadingMore = true
                } else {
                    setState { state -> state.showLoading(false) }
                }
            } catch (exception: Exception) {
                handleException(exception)
                setState { state -> state.showLoading(false) }
            }
        }
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