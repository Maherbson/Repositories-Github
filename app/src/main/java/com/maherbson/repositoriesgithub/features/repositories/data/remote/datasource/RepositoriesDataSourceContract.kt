package com.maherbson.repositoriesgithub.features.repositories.data.remote.datasource

import com.maherbson.repositoriesgithub.features.repositories.data.remote.model.response.RepositoriesResponse

interface RepositoriesDataSourceContract {

    suspend fun getRepositories(page: Int): RepositoriesResponse

}