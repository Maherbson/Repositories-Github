package com.maherbson.repositoriesgithub.features.repositories.di

import com.maherbson.network.client.Client
import com.maherbson.repositoriesgithub.features.repositories.data.remote.api.RepositoriesService
import com.maherbson.repositoriesgithub.features.repositories.data.remote.datasource.RepositoriesDataSource
import com.maherbson.repositoriesgithub.features.repositories.data.remote.datasource.RepositoriesDataSourceContract
import com.maherbson.repositoriesgithub.features.repositories.data.repository.RepositoriesRepository
import com.maherbson.repositoriesgithub.features.repositories.domain.repository.RepositoriesRepositoryContract
import com.maherbson.repositoriesgithub.features.repositories.domain.usecase.RepositoriesUseCase
import com.maherbson.repositoriesgithub.features.repositories.domain.usecase.RepositoriesUseCaseContract
import com.maherbson.repositoriesgithub.features.repositories.presentation.RepositoriesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object RepositoriesModule {

    private val presentation: Module = module {
        viewModel {
            RepositoriesViewModel(
                repositoriesUseCaseContract = get(),
                infinityScrollContract = get()
            )
        }
    }

    private val domain: Module = module {
        factory<RepositoriesUseCaseContract> {
            RepositoriesUseCase(
                repositoriesRepositoryContract = get()
            )
        }
    }

    private val data: Module = module {
        factory { get<Client>().create(RepositoriesService::class.java) }
        factory<RepositoriesDataSourceContract> {
            RepositoriesDataSource(
                repositoriesService = get()
            )
        }
        factory<RepositoriesRepositoryContract> {
            RepositoriesRepository(
                repositoriesDataSourceContract = get()
            )
        }
    }

    fun load(): List<Module> {
        return listOf(data, domain, presentation)
    }

}