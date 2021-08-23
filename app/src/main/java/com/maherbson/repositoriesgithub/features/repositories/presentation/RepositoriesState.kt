package com.maherbson.repositoriesgithub.features.repositories.presentation

import com.maherbson.core.viewmodel.State
import com.maherbson.repositoriesgithub.features.repositories.presentation.model.RepositoryView

data class RepositoriesState(
    val isLoading: Boolean = true,
    val dialogErrorState: DialogErrorState? = null,
    var repositories: List<RepositoryView> = arrayListOf(),
    val freshMore: Boolean = false
) : State {


    fun showLoading(
        showLoading: Boolean
    ): RepositoriesState {
        return this.copy(
            isLoading = showLoading,
            dialogErrorState = null,
            freshMore = false
        )
    }

    fun showMessageError(
        title: Int,
        message: Int
    ): RepositoriesState {
        return this.copy(
            dialogErrorState = DialogErrorState(
                titleError = title,
                messageError = message
            )
        )
    }

    fun showRepositories(
        repositoriesView: List<RepositoryView>
    ): RepositoriesState {
        return this.copy(
            dialogErrorState = null,
            repositories = repositoriesView,
            freshMore = true
        )
    }

}