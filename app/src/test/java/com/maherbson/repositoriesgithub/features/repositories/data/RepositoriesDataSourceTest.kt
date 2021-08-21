package com.maherbson.repositoriesgithub.features.repositories.data

import com.maherbson.network.exception.NetworkException
import com.maherbson.repositoriesgithub.features.mock.repositoriesResponse
import com.maherbson.repositoriesgithub.features.repositories.data.remote.api.RepositoriesService
import com.maherbson.repositoriesgithub.features.repositories.data.remote.datasource.RepositoriesDataSource
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

class RepositoriesDataSourceTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS)

    @Mock
    lateinit var repositoryService: RepositoriesService

    @InjectMocks
    lateinit var repositoriesDataSource: RepositoriesDataSource

    @Test
    fun `repositoryService Should return RepositoriesResponse When the repository is called`() {
        runBlocking {
            whenever(repositoryService.getRepositories(1)).doReturn(repositoriesResponse())

            assertEquals(repositoriesResponse(), repositoriesDataSource.getRepositories(1))
        }
    }


    @Test(expected = NetworkException::class)
    fun `repositoryService Should return NetworkException When have not connection`() {
        runBlocking {
            whenever(
                repositoryService.getRepositories(1)
            ).doAnswer { throw NetworkException() }

            assertEquals(
                NetworkException().message,
                repositoriesDataSource.getRepositories(1)
            )
        }
    }
}