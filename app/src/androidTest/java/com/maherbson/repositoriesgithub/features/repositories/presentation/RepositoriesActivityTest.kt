package com.maherbson.repositoriesgithub.features.repositories.presentation

import com.maherbson.androidtest.robot.extensions.action
import com.maherbson.androidtest.robot.extensions.assertion
import com.maherbson.androidtest.robot.extensions.mockJson
import com.maherbson.repositoriesgithub.features.repositories.presentation.robot.RepositoriesActivityRobot
import org.junit.Test

class RepositoriesActivityTest : RepositoriesActivityRobot() {

    @Test
    fun whenLoadedRepositories_CheckNameRepository() {
        mockJson("repositories/repositories_response.json")
        assertion {
            checkNameRepository("kotlin")
        }
    }

    @Test
    fun whenLoadedRepositories_CheckOwner() {
        mockJson("repositories/repositories_response.json")
        assertion {
            checkLoginOwner()
        }
    }

    @Test
    fun whenLoadedRepositories_CheckDescription() {
        mockJson("repositories/repositories_response.json")
        assertion {
            checkDescriptionRepository()
        }
    }

    @Test
    fun whenLoadedRepositories_CheckCountForks() {
        mockJson("repositories/repositories_response.json")
        assertion {
            checkCountForksRepository()
        }
    }

    @Test
    fun whenLoadedRepositories_CheckCountWatchers() {
        mockJson("repositories/repositories_response.json")
        assertion {
            checkCountWatchersRepository()
        }
    }

    @Test
    fun whenLoadedRepositories_CheckInfiniteScroll() {
        mockJson(
            "repositories/repositories_response.json",
            "repositories/repositories_response.json"
        )
        action {
            recyclerViewToPosition(11)
            recyclerViewToPosition(22)
        }
        assertion {
            checkNameRepository("plaid")
        }
    }

}