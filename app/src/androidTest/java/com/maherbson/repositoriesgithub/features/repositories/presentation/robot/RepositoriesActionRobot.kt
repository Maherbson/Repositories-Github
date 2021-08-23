package com.maherbson.repositoriesgithub.features.repositories.presentation.robot

import com.maherbson.androidtest.robot.RobotAction
import com.maherbson.androidtest.robot.extensions.scrollBottom
import com.maherbson.repositoriesgithub.R
import com.maherbson.repositoriesgithub.features.repositories.presentation.adapter.RepositoryViewHolder

class RepositoriesActionRobot: RobotAction {

    fun recyclerViewToPosition(position: Int) {
        scrollBottom<RepositoryViewHolder>(position, R.id.rvRepositories)
    }

}