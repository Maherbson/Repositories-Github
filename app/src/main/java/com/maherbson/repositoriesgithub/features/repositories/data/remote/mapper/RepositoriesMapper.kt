package com.maherbson.repositoriesgithub.features.repositories.data.remote.mapper

import com.maherbson.core.mapper.Mapper
import com.maherbson.repositoriesgithub.features.repositories.domain.model.Owner
import com.maherbson.repositoriesgithub.features.repositories.domain.model.Repositories
import com.maherbson.repositoriesgithub.features.repositories.data.remote.model.response.Repositories as RepositoriesResponse

class RepositoriesMapper : Mapper<List<RepositoriesResponse>, List<Repositories>> {

    override fun map(source: List<RepositoriesResponse>): List<Repositories> {
        return source.map {
            Repositories(
                it.name,
                it.description,
                it.watchers,
                it.forks,
                Owner(
                    it.owner?.login,
                    it.owner?.avatar_url
                )
            )
        }
    }

}