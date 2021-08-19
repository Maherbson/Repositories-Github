package com.maherbson.core.viewmodel.extensions

import androidx.appcompat.app.AppCompatActivity
import com.maherbson.core.viewmodel.Action
import com.maherbson.core.viewmodel.State
import com.maherbson.core.viewmodel.ViewModel

inline fun <reified S : State, reified A : Action> AppCompatActivity.onStateObserver(
    viewModel: ViewModel<S, A>,
    crossinline states: (S) -> Unit
) {
    viewModel.state.observe(this, { state -> states(state as S) })
}

inline fun <reified S : State, reified A : Action> AppCompatActivity.onActionObserver(
    viewModel: ViewModel<S, A>,
    crossinline actions: (A) -> Unit
) {
    viewModel.action.observe(this, { action -> actions(action as A) })
}
