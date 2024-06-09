package com.ip.mobile.android.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ip.mobile.home.data.RocketLaunch
import com.ip.mobile.home.data.SpaceXRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class RocketLaunchViewModel() : ViewModel() {
    private val _launchState = MutableStateFlow<RocketLaunchScreenState>(RocketLaunchScreenState.Uninitialized)
    val launchState: StateFlow<RocketLaunchScreenState> = _launchState

    init {
        loadLaunches()
    }

    fun loadLaunches() {
        _launchState.value = RocketLaunchScreenState.Loading
        viewModelScope.launch {
            try {
                SpaceXRepo().getAllLaunches().collect { launches ->
                    _launchState.value = RocketLaunchScreenState.Success(launches)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _launchState.value = RocketLaunchScreenState.Error(e.message.orEmpty())
            }

        }
    }

}

sealed interface RocketLaunchScreenState {
    data class Success(val data: List<RocketLaunch>) : RocketLaunchScreenState
    data class Error(val exceptionMessage: String) : RocketLaunchScreenState
    object Loading : RocketLaunchScreenState
    object Uninitialized : RocketLaunchScreenState
}
