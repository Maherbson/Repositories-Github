package com.maherbson.core.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class ViewModel<S : State, A : Action>(
    initState: S
) : ViewModel() {

    private val _state = MutableLiveData(initState)
    val state: LiveData<S> = _state

    private val _action = MutableLiveData<A>()
    val action: LiveData<A> = _action

    fun setState(state: (S) -> S) {
        _state.value = state(_state.value!!)
    }

    fun setAction(action: () -> A) {
        _action.value = action()
    }

}
