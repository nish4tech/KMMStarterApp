package com.ip.mobile.android

import com.ip.mobile.android.home.RocketLaunchViewModel
import com.ip.mobile.home.data.SpaceXRepo
import com.ip.mobile.networking.SpaceXApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<SpaceXApi> { SpaceXApi() }
    single<SpaceXRepo> { SpaceXRepo() }
    viewModel { RocketLaunchViewModel() }
}