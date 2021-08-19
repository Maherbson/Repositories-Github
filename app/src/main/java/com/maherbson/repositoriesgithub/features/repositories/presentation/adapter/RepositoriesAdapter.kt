package com.maherbson.repositoriesgithub.features.repositories.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maherbson.repositoriesgithub.databinding.ItemLoadingBinding
import com.maherbson.repositoriesgithub.databinding.ItemRepositoryBinding
import com.maherbson.repositoriesgithub.features.repositories.presentation.model.Repository

private const val VIEW_ITEM = 0
private const val VIEW_LOADING = 1

class RepositoriesAdapter(
    private val repositories: ArrayList<Repository?>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == VIEW_LOADING) {
            val binding = ItemLoadingBinding.inflate(inflater, parent, false)
            LoadingViewHolder(binding)
        } else {
            val binding = ItemRepositoryBinding.inflate(inflater, parent, false)
            RepositoryViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is RepositoryViewHolder -> {
                repositories[position]?.let { repository -> holder.bind(repository) }
            }
        }
    }

    override fun getItemCount(): Int {
        return repositories.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (repositories[position] == null) VIEW_LOADING else VIEW_ITEM
    }

    fun setRepositories(repositories: List<Repository?>) {
        this.repositories.addAll(repositories)
    }

}