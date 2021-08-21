package com.maherbson.repositoriesgithub.features.repositories.domain.usecase

import com.maherbson.repositoriesgithub.features.repositories.domain.model.Repositories

interface RepositoriesUseCaseContract {

    suspend operator fun invoke(): List<Repositories>
    fun restartPage()
}