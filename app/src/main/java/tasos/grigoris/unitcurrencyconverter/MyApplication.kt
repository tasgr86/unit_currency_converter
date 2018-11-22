package tasos.grigoris.unitcurrencyconverter

import android.app.Application

class MyApplication : Application() {

    companion object {

        private var component: MyComponent? = null

        fun getComponent(): MyComponent {
            return component!!
        }

    }



    override fun onCreate() {

        super.onCreate()

        component = createMyComponent()

    }




    fun setComponent(_component: MyComponent) {
        component = _component
    }


    private fun createMyComponent(): MyComponent {

        return DaggerMyComponent
            .builder()
            .myModule(MyModule(this@MyApplication))
            .build()

    }

}