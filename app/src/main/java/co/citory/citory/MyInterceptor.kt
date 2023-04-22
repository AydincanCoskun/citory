package co.citory.citory

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
     val orginalrequest=chain.request()
        val request=orginalrequest.newBuilder().header("Authorization","AuthToken").build()
        val response=chain.proceed(request)
        return response
     
    }
}