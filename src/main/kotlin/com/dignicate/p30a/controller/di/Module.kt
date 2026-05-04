package com.dignicate.p30a.controller.di

import com.dignicate.p30a.controller.automobile.AutomobileController
import com.dignicate.p30a.controller.time.CurrentTimeController
import org.koin.dsl.module


val controllerModule = module {
    factory {
        AutomobileController(get())
    }
    factory {
        CurrentTimeController(get())
    }
}
