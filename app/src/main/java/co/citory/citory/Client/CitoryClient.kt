package co.citory.citory.Client

import co.citory.citory.MyInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL


class CitoryClient {

    companion object{
        fun getClient(baseUrl:String):Retrofit{
            return Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
        fun httpClient():OkHttpClient{
            val builder=OkHttpClient().newBuilder().addInterceptor(MyInterceptor())
            return builder.build()
        }
    }
}