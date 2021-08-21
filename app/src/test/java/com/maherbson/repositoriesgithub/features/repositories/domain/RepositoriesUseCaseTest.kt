package com.maherbson.repositoriesgithub.features.repositories.domain

import com.maherbson.network.exception.NetworkException
import com.maherbson.repositoriesgithub.features.mock.repositories
import com.maherbson.repositoriesgithub.features.repositories.domain.repository.RepositoriesRepositoryContract
import com.maherbson.repositoriesgithub.features.repositories.domain.usecase.RepositoriesUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.whenever
import org.mockito.quality.Strictness

class RepositoriesUseCaseTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS)

    @Mock
    lateinit var repositoriesRepositoryContract: RepositoriesRepositoryContract

    @InjectMocks
    lateinit var repositoriesUseCase: RepositoriesUseCase

    @Test
    fun `repositoriesUseCase Should return Repositories When the repository is called`() {
        runBlocking {
            whenever(
                repositoriesRepositoryContract.getRepositories(1)
            ).doReturn(repositories())
            assertEquals(repositories(), repositoriesUseCase.invoke())
        }
    }

    @Test(expected = NetworkException::class)
    fun `repositoriesUseCase Should return NetworkException When have not connection`() {
        runBlocking {
            whenever(
                repositoriesRepositoryContract.getRepositories(1)
            ).doAnswer { throw NetworkException() }

            assertEquals(NetworkException().message, repositoriesUseCase.invoke())
        }
    }
}
