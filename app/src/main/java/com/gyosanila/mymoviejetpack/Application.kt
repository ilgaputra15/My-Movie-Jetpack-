package com.gyosanila.mymoviejetpack

import android.app.Application
import com.gyosanila.mymoviejetpack.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by ilgaputra15
 * on Friday, 22/11/2019 16:31
 * Division Mobile - PT.Homecareindo Global Medika
 **/
class Application: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@Application)
            modules(appComponent)
        }
    }
}