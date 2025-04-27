package com.dignicate.p30a.controller.di

import com.dignicate.p30a.controller.AutomobileController
import io.ktor.server.application.*
import org.koin.dsl.module


val controllerModule = module {
    factory { (call: ApplicationCall) -> AutomobileController(call, get()) }
}
