package com.maherbson.repositoriesgithub.features.repositories.data.remote.model.response

data class Repositories(
    var name: String? = String(),
    var description: String? = String(),
    var watchers: Int? = -1,
    var forks: Int? = -1,
    var owner: OwnerResponse? = null
)