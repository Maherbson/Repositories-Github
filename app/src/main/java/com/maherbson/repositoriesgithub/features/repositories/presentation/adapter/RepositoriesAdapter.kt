package com.maherbson.repositoriesgithub.features.repositories.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maherbson.repositoriesgithub.databinding.ItemRepositoryBinding
import com.maherbson.repositoriesgithub.features.repositories.presentation.model.RepositoryView

class RepositoriesAdapter : RecyclerView.Adapter<RepositoryViewHolder>() {

    private var repositories: ArrayList<RepositoryView> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRepositoryBinding.inflate(inflater, parent, false)
        return RepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(repositories[position])
    }

    override fun getItemCount(): Int {
        return repositories.size
    }

    fun setRepositories(repositoriesView: List<RepositoryView>) {
        repositories.addAll(repositoriesView)
        notifyItemRangeInserted(this.repositories.size, repositoriesView.size - 1)
    }

    fun getRepositories() : ArrayList<RepositoryView> {
        return repositories
    }

}