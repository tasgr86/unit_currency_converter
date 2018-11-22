package tasos.grigoris.unitcurrencyconverter

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MyModule (private val context: Context) {

    @Provides //scope is not necessary for parameters stored within the module
    fun context(): Context {
        return context
    }

    @Provides
    @Singleton
    internal fun providePrefs(context: Context): IMyPrefs {

        return MyPrefs(context)

    }

    @Provides
    @Singleton
    internal fun provideConverter(): IMyConverter {

        return MyConverter()

    }


}
