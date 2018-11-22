package tasos.grigoris.unitcurrencyconverter.NavBar

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import tasos.grigoris.unitcurrencyconverter.*
import tasos.grigoris.unitcurrencyconverter.FixerApi.FixerApiService
import tasos.grigoris.unitcurrencyconverter.FixerApi.Model.FixerResponse
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var prefs: IMyPrefs
    private lateinit var base_url: String
    private lateinit var rates: FixerResponse

    private val fixerApiServe by lazy {
        FixerApiService.create(base_url)
    }

    private var disposable: Disposable? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        base_url = "http://data.fixer.io/api/"
        MyApplication.getComponent().inject(this@MainActivity)

        println("TEST PREFS: ".plus(prefs))

        updateRates()

        startBasicFragment()

        bottom_nav.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { position ->

            val bundle = Bundle()
            val fr = FRParent()

            when (position.itemId) {

                R.id.basic -> bundle.putSerializable("fr", FRS.BASIC)
                R.id.science -> bundle.putSerializable("fr", FRS.SCIENCE)
                R.id.calculate -> bundle.putSerializable("fr", FRS.CALCULATE)
                R.id.settings -> {

                    supportFragmentManager.beginTransaction().replace(activity2_frame.id, FRSettings()).commit()
                    return@OnNavigationItemSelectedListener true

                }

            }

            fr.arguments = bundle
            supportFragmentManager.beginTransaction().replace(activity2_frame.id, fr).commit()

            return@OnNavigationItemSelectedListener true

        })


    }

    private fun startBasicFragment(){

        val bundle = Bundle()
        val fr = FRParent()
        bundle.putSerializable("fr", FRS.BASIC)
        fr.arguments = bundle
        supportFragmentManager.beginTransaction().replace(activity2_frame.id, fr).commit()

    }


    private fun beginSearch() {

        println("2a. DOWNLOADING RATES")

        disposable = fixerApiServe.search(getString(R.string.fixer_api_key))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->

                    println("2b. RECEIVED RATES ".plus(result.body()))
                    println(result.raw().request().url())

                    rates = result.body()!!
                    prefs.storeRates(rates)

                    startBasicFragment()

                },

                { error -> Log.d("error getting rates: ", error.message) }

            )

    }


    private fun updateRates(){

        print("1.UPDATE RATES ".plus(prefs.shouldUpdate()))

        if (prefs.shouldUpdate())
            beginSearch()

    }

}