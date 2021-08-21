package com.maherbson.repositoriesgithub.features.repositories.data.repository

import com.maherbson.repositoriesgithub.features.repositories.data.remote.datasource.RepositoriesDataSourceContract
import com.maherbson.repositoriesgithub.features.repositories.data.remote.mapper.RepositoriesMapper
import com.maherbson.repositoriesgithub.features.repositories.domain.repository.RepositoriesRepositoryContract
import com.maherbson.repositoriesgithub.features.repositories.domain.model.Repositories as Repository

class RepositoriesRepository(
    private val repositoriesDataSourceContract: RepositoriesDataSourceContract,
) : RepositoriesRepositoryContract {

    override suspend fun getRepositories(page: Int): List<Repository> {
        return RepositoriesMapper().map(repositoriesDataSourceContract.getRepositories(page).items)
    }
}