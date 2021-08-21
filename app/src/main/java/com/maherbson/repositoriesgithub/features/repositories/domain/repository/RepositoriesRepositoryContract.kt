package com.maherbson.repositoriesgithub.features.repositories.domain.repository

import com.maherbson.repositoriesgithub.features.repositories.domain.model.Repositories

interface RepositoriesRepositoryContract {

    suspend fun getRepositories(page: Int): List<Repositories>
}