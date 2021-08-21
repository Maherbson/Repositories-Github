package com.maherbson.repositoriesgithub.features.repositories.data

import com.maherbson.network.exception.NetworkException
import com.maherbson.repositoriesgithub.features.mock.repositoriesResponse
import com.maherbson.repositoriesgithub.features.repositories.data.remote.datasource.RepositoriesDataSourceContract
import com.maherbson.repositoriesgithub.features.repositories.data.repository.RepositoriesRepository
import com.maherbson.repositoriesgithub.features.repositories.domain.model.Owner
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
import com.maherbson.repositoriesgithub.features.repositories.domain.model.Repositories as Repo

class RepositoriesRepositoryTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS)

    @Mock
    lateinit var repositoriesDataSource: RepositoriesDataSourceContract

    @InjectMocks
    lateinit var repositoriesRepository: RepositoriesRepository

    @Test
    fun `repositoriesRepository Should return Repositories When the datasource is called`() {
        runBlocking {
            whenever(
                repositoriesDataSource.getRepositories(1)
            ).doReturn(repositoriesResponse())

            assertEquals(repositories(), repositoriesRepository.getRepositories(1))
        }
    }

    @Test(expected = NetworkException::class)
    fun `repositoriesRepository Should return NetworkException When have not connection`() {
        runBlocking {
            whenever(
                repositoriesDataSource.getRepositories(1)
            ).doAnswer { throw NetworkException() }

            assertEquals(
                NetworkException().message,
                repositoriesRepository.getRepositories(1)
            )
        }
    }

    private fun repositories(): List<Repo> {
        return listOf(
            Repo(
                name = "Name",
                description = "Description",
                watchers = 1,
                forks = 1,
                owner = Owner(
                    login = "Login",
                    avatar_url = "url"
                )
            )
        )
    }

}