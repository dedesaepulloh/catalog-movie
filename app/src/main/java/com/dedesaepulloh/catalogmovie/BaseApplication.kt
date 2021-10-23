package com.dedesaepulloh.catalogmovie

import android.app.Application
import com.dedesaepulloh.catalogmovie.di.AppComponent
import com.dedesaepulloh.catalogmovie.di.DaggerAppComponent

open class BaseApplication : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}