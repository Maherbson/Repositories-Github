package com.maherbson.repositoriesgithub.features.repositories.presentation.robot

import checkTextIsDisplayed
import com.maherbson.androidtest.robot.RobotAssertion

class RepositoriesAssertionRobot: RobotAssertion {

    fun checkNameRepository(nameRepository: String) {
        checkTextIsDisplayed(nameRepository)
    }

    fun checkLoginOwner() {
        checkTextIsDisplayed("JetBrains")
    }

    fun checkDescriptionRepository() {
        checkTextIsDisplayed("The Kotlin Programming Language.")
    }

    fun checkCountForksRepository() {
        checkTextIsDisplayed("4665")
    }

    fun checkCountWatchersRepository() {
        checkTextIsDisplayed("38482")
    }

}