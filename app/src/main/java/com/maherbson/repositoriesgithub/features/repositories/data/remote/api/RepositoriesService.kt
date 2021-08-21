package com.maherbson.repositoriesgithub.features.repositories.data.remote.api

import com.maherbson.repositoriesgithub.features.repositories.data.remote.model.response.RepositoriesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RepositoriesService {

    @GET("search/repositories?q=language:kotlin&sort=stars")
    suspend fun getRepositories(@Query("page") page: Int): RepositoriesResponse

}