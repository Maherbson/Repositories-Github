package com.maherbson.repositoriesgithub.features.repositories.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.maherbson.infinitescroll.InfiniteScrollUseCaseContract
import com.maherbson.repositoriesgithub.TestCoroutineRule
import com.maherbson.repositoriesgithub.features.mock.repositories
import com.maherbson.repositoriesgithub.features.mock.repositoriesNext
import com.maherbson.repositoriesgithub.features.mock.repositoriesView
import com.maherbson.repositoriesgithub.features.mock.repositoriesViewNext
import com.maherbson.repositoriesgithub.features.repositories.domain.usecase.RepositoriesUseCaseContract
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.mockito.kotlin.inOrder
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.mockito.quality.Strictness
import org.mockito.kotlin.verify as verifyKotlin

@ExperimentalCoroutinesApi
class RepositoriesViewModelTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS)

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private val repositoriesUseCaseContract: RepositoriesUseCaseContract = mock()

    private val infinityScrollContract: InfiniteScrollUseCaseContract = mock()

    @Mock
    lateinit var repositoriesState: Observer<RepositoriesState>

    @Mock
    lateinit var repositoriesAction: Observer<RepositoriesAction>

    private lateinit var repositoriesViewModel: RepositoriesViewModel

    private fun initViewModel() {
        repositoriesViewModel = RepositoriesViewModel(
            repositoriesUseCaseContract,
            infinityScrollContract
        )
    }

    @Test
    fun `repositoriesUseCase Should return Repositories When the repository is called`() {
        runBlocking {
            whenever(repositoriesUseCaseContract.invoke()).thenReturn(repositories())
            initViewModel()
            repositoriesViewModel.state.observeForever(repositoriesState)
            repositoriesViewModel.action.observeForever(repositoriesAction)

            verifyKotlin(repositoriesState).onChanged(
                RepositoriesState(
                    isLoading = false,
                    repositories = repositoriesView(),
                    freshMore = true
                )
            )
        }
    }

    @Test
    fun `repositoriesUseCase Should return Repositories When the repositories method is called if infinite scroll is true`() {
        runBlocking {
            whenever(repositoriesUseCaseContract.invoke()).thenReturn(repositories())
            whenever(repositoriesUseCaseContract.invoke()).thenReturn(repositoriesNext())
            initViewModel()
            repositoriesViewModel.state.observeForever(repositoriesState)
            repositoriesViewModel.action.observeForever(repositoriesAction)

            repositoriesViewModel.repositories(
                100,
                29,
                30,
                50
            )

            inOrder(repositoriesState) {
                verifyKotlin(repositoriesState).onChanged(
                    RepositoriesState(
                        isLoading = false,
                        repositories = repositoriesViewNext(),
                        freshMore = true
                    )
                )
            }
        }
    }

}