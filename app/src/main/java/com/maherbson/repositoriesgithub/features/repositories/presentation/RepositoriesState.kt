package com.maherbson.repositoriesgithub.features.repositories.presentation

data class RepositoriesState(
    val isLoading: Boolean = true,
    val isLoadingInfinityScroll: Boolean = false,
    val messageError: String = String()
)