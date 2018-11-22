package tasos.grigoris.unitcurrencyconverter.FixerApi

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import tasos.grigoris.unitcurrencyconverter.FixerApi.Model.FixerResponse

interface FixerApiService {

    @GET("/latest")
    fun search(@Query("access_key") key: String): Observable<Response<FixerResponse>>

    companion object {

        fun create(base_url : String): FixerApiService {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(base_url)
                .build()

            return retrofit.create(FixerApiService::class.java)
        }
    }
}