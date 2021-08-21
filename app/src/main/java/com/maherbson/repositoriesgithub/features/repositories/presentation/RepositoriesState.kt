package com.maherbson.repositoriesgithub.features.repositories.presentation

import com.maherbson.core.viewmodel.State
import com.maherbson.repositoriesgithub.features.repositories.presentation.model.RepositoryView

data class RepositoriesState(
    val isLoading: Boolean = true,
    val isLoadingInfinityScroll: Boolean = false,
    val dialogErrorState: DialogErrorState? = null,
    val repositories: List<RepositoryView>? = arrayListOf()
) : State {

    fun showLoading(showLoading: Boolean): RepositoriesState {
        return this.copy(
            isLoading = showLoading,
            dialogErrorState = null,
            repositories = null
        )
    }

    fun showMessageError(title: Int, message: Int): RepositoriesState {
        return this.copy(
            dialogErrorState = DialogErrorState(titleError = title, messageError = message)
        )
    }

    fun showRepositories(repositoriesView: List<RepositoryView>): RepositoriesState {
        return this.copy(
            repositories = repositoriesView,
            dialogErrorState = null
        )
    }

    fun cleanRepositories(): RepositoriesState {
        return this.copy(
            repositories = emptyList(),
            dialogErrorState = null
        )
    }

}