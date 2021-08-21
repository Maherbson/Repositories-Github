package com.maherbson.repositoriesgithub.features.repositories.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maherbson.repositoriesgithub.databinding.ItemRepositoryBinding
import com.maherbson.repositoriesgithub.features.repositories.presentation.model.RepositoryView

class RepositoriesAdapter : RecyclerView.Adapter<RepositoryViewHolder>() {

    private val repositories: ArrayList<RepositoryView?> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRepositoryBinding.inflate(inflater, parent, false)
        return RepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        repositories[position]?.let { repository -> holder.bind(repository) }
    }

    override fun getItemCount(): Int {
        return repositories.size
    }

    fun setRepositories(repositories: List<RepositoryView?>) {
        this.repositories.addAll(repositories)
        notifyItemRangeInserted(this.repositories.size, repositories.size - 1)
    }

}