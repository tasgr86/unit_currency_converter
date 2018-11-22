package tasos.grigoris.unitcurrencyconverter.Tabs

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main_tabs.*
import tasos.grigoris.unitcurrencyconverter.FixerApi.FixerApiService
import tasos.grigoris.unitcurrencyconverter.FixerApi.Model.FixerResponse
import tasos.grigoris.unitcurrencyconverter.MyPrefs
import tasos.grigoris.unitcurrencyconverter.R

class MainActivityTabs : AppCompatActivity() {

//    private lateinit var prefs : MyPrefs
    private lateinit var prefs : MyPrefs
    private lateinit var base_url : String
    private lateinit var rates : FixerResponse

    val fixerApiServe by lazy {
        FixerApiService.create(base_url)
    }

    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tabs)

        setSupportActionBar(main_toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, main_toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()


       // prefs = MyPrefs(applicationContext)
        base_url = "http://data.fixer.io/api/"

        val adapter = TabPagerAdapter(supportFragmentManager, 4)

        pager.adapter = adapter
        pager.currentItem = 0

        pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(main_tab_layout))

        main_tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                pager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}

        })

        updateRates()

    }


    private fun beginSearch() {

        disposable = fixerApiServe.search(getString(R.string.fixer_api_key))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        { result ->

                            println(result.raw().request().url())
                            println("2b. RECEIVED RATES ".plus(result.body()))

                            rates = result.body()!!
                            prefs.storeRates(rates)
                            
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