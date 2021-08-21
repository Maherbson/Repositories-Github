package com.maherbson.repositoriesgithub.features.mock

import com.maherbson.repositoriesgithub.features.repositories.data.remote.model.response.OwnerResponse
import com.maherbson.repositoriesgithub.features.repositories.data.remote.model.response.RepositoriesResponse
import com.maherbson.repositoriesgithub.features.repositories.domain.model.Owner
import com.maherbson.repositoriesgithub.features.repositories.domain.model.Repositories
import com.maherbson.repositoriesgithub.features.repositories.presentation.model.OwnerView
import com.maherbson.repositoriesgithub.features.repositories.presentation.model.RepositoryView
import com.maherbson.repositoriesgithub.features.repositories.data.remote.model.response.Repositories as Repo

fun repositories(): List<Repositories> = listOf(
    Repositories(
        name = "okhttp",
        description = "Square’s meticulous HTTP client for the JVM, Android, and GraalVM.",
        watchers = 1,
        forks = 1,
        owner = Owner(
            login = "square",
            avatar_url = "url"
        )
    )
)

fun repositoriesNext(): List<Repositories> = listOf(
    Repositories(
        name = "architecture-samples",
        description = "A collection of samples to discuss and showcase different architectural tools and patterns for Android apps. ",
        watchers = 1,
        forks = 1,
        owner = Owner(
            login = "android",
            avatar_url = "url"
        )
    )
)

fun repositoriesView(): List<RepositoryView> = listOf(
    RepositoryView(
        name = "okhttp",
        description = "Square’s meticulous HTTP client for the JVM, Android, and GraalVM.",
        watchers = 1,
        forks = 1,
        owner = OwnerView(
            login = "square",
            avatar_url = "url"
        )
    )
)

fun repositoriesViewNext(): List<RepositoryView> = listOf(
    RepositoryView(
        name = "architecture-samples",
        description = "A collection of samples to discuss and showcase different architectural tools and patterns for Android apps. ",
        watchers = 1,
        forks = 1,
        owner = OwnerView(
            login = "android",
            avatar_url = "url"
        )
    )
)

fun repositoriesResponse(): RepositoriesResponse {
    return RepositoriesResponse(
        items = listOf(
            Repo(
                name = "okhttp",
                description = "Square’s meticulous HTTP client for the JVM, Android, and GraalVM.",
                watchers = 1,
                forks = 1,
                owner = OwnerResponse(
                    login = "square",
                    avatar_url = "url"
                )
            )
        )
    )
}
