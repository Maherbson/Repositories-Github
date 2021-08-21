package com.maherbson.repositoriesgithub.features.repositories.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maherbson.core.viewmodel.extensions.onState
import com.maherbson.repositoriesgithub.R
import com.maherbson.repositoriesgithub.databinding.ActivityRepositoriesBinding
import com.maherbson.repositoriesgithub.features.repositories.presentation.adapter.RepositoriesAdapter
import com.maherbson.ui.extensions.alertDialog
import com.maherbson.ui.extensions.negativeButton
import com.maherbson.ui.extensions.positiveButton
import com.maherbson.ui.loading.extensions.hideLoading
import com.maherbson.ui.loading.extensions.showLoading
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepositoriesActivity : AppCompatActivity() {

    private val repositoriesViewModel: RepositoriesViewModel by viewModel()

    private val repositoriesAdapter: RepositoriesAdapter by lazy { RepositoriesAdapter() }

    private val binding: ActivityRepositoriesBinding by lazy {
        ActivityRepositoriesBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView()
        setupInfinityScroll()
        setupObserver()
    }

    private fun setupView() {
        binding.rvRepositories.adapter = repositoriesAdapter
    }

    private fun setupInfinityScroll() {
        val layoutManager = binding.rvRepositories.layoutManager as LinearLayoutManager
        binding.rvRepositories.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                repositoriesViewModel.repositories(
                    horizontalScroll = dy,
                    childCount = layoutManager.childCount,
                    itemCount = layoutManager.itemCount,
                    findFirstVisibleItemPosition =
                    layoutManager.findFirstVisibleItemPosition()
                )
            }
        })
    }

    private fun setupObserver() {
        onState(repositoriesViewModel) { repositoriesState ->
            with(repositoriesState) {
                loading()
                fillRepositories()
                messageError()
            }

        }
    }

    private fun RepositoriesState.loading() {
        if (isLoading) showLoading() else hideLoading()
    }

    private fun RepositoriesState.fillRepositories() {
        repositories?.let {
            repositoriesAdapter.setRepositories(repositories)
        }
    }

    private fun RepositoriesState.messageError() {
        dialogErrorState?.let { dialog ->
            alertDialog {
                setTitle(getString(dialog.titleError))
                setMessage(getString(dialog.messageError))
                negativeButton(getString(R.string.cancel)) {
                    finish()
                }
                positiveButton(getString(R.string.try_again)) {
                    repositoriesViewModel.getRepositories()
                    it.dismiss()
                }
            }
        }
    }
}
