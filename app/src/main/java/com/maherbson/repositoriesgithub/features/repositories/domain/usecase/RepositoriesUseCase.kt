package com.maherbson.repositoriesgithub.features.repositories.domain.usecase

import com.maherbson.repositoriesgithub.features.repositories.domain.model.Repositories
import com.maherbson.repositoriesgithub.features.repositories.domain.repository.RepositoriesRepositoryContract

private const val INITIAL_PAGE= 1

class RepositoriesUseCase(
    private val repositoriesRepositoryContract: RepositoriesRepositoryContract
): RepositoriesUseCaseContract {

    private var page: Int = INITIAL_PAGE

    override suspend fun invoke(): List<Repositories> {
        val repositories = repositoriesRepositoryContract.getRepositories(page)
        if (repositories.isNotEmpty()) {
            page++
        }
        return repositories
    }
}
