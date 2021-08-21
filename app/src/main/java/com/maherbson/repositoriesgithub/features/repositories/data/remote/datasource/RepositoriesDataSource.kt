package com.maherbson.repositoriesgithub.features.repositories.data.remote.datasource

import com.maherbson.repositoriesgithub.features.repositories.data.remote.api.RepositoriesService
import com.maherbson.repositoriesgithub.features.repositories.data.remote.model.response.RepositoriesResponse

class RepositoriesDataSource(
    private val repositoriesService: RepositoriesService
) : RepositoriesDataSourceContract {

    override suspend fun getRepositories(page: Int): RepositoriesResponse {
        return repositoriesService.getRepositories(page)
    }
}