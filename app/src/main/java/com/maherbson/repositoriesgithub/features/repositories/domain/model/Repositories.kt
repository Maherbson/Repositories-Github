package com.maherbson.repositoriesgithub.features.repositories.domain.model

data class Repositories(
    var name: String? = String(),
    var description: String? = String(),
    var watchers: Int? = -1,
    var forks: Int? = -1,
    var owner: Owner? = null
)