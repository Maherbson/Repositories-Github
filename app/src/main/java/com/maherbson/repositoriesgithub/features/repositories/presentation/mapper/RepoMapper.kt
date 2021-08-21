package com.maherbson.repositoriesgithub.features.repositories.presentation.mapper

import com.maherbson.core.mapper.Mapper
import com.maherbson.repositoriesgithub.features.repositories.domain.model.Repositories
import com.maherbson.repositoriesgithub.features.repositories.presentation.model.OwnerView
import com.maherbson.repositoriesgithub.features.repositories.presentation.model.RepositoryView

class RepoMapper : Mapper<List<Repositories>, List<RepositoryView>> {

    override fun map(source: List<Repositories>): List<RepositoryView> {
        return source.map {
            RepositoryView(
                it.name,
                it.description,
                it.watchers,
                it.forks,
                OwnerView(
                    it.owner?.login,
                    it.owner?.avatar_url
                )
            )
        }
    }
}