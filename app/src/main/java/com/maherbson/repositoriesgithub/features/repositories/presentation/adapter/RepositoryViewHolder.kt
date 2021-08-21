package com.maherbson.repositoriesgithub.features.repositories.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.maherbson.repositoriesgithub.databinding.ItemRepositoryBinding
import com.maherbson.repositoriesgithub.features.repositories.presentation.model.RepositoryView
import com.maherbson.ui.extensions.loadUrl

class RepositoryViewHolder(
    private val itemRepositoryBinding: ItemRepositoryBinding
) : RecyclerView.ViewHolder(itemRepositoryBinding.root) {

    fun bind(repository: RepositoryView) {
        with(itemRepositoryBinding) {
            tvUserName.text = repository.owner.login
            tvRepositoryName.text = repository.name
            tvRepositoryDescription.text = repository.description
            tvCountFork.text = repository.forks.toString()
            tvCountStart.text = repository.watchers.toString()
            repository.owner.avatar_url?.let { ivRepositoryAvatar.loadUrl(it) }
        }
    }

}