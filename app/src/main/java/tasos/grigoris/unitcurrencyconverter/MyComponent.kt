package tasos.grigoris.unitcurrencyconverter

import dagger.Component
import tasos.grigoris.unitcurrencyconverter.NavBar.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [MyModule::class])
interface MyComponent {

    fun inject(mainActivity: MainActivity)

    fun injectConverter(converter: MyConverter)

    fun injectListGenerator(listGenerator: ListGenerator)

}