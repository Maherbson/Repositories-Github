package com.maherbson.repositoriesgithub.features.repositories.presentation.model


data class RepositoryView(
    var name: String? = String(),
    var description: String? = String(),
    var watchers: Int? = -1,
    var forks: Int? = -1,
    var owner: OwnerView
)