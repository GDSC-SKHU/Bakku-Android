package com.example.bakku.data.remote

import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GetTokenResult
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val BASE_URL = "https://bakku-dev.duckdns.org/api/v1/"

    val interceptorClient = OkHttpClient().newBuilder()
        .addInterceptor(AuthInterceptor())
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(interceptorClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}



class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()

        if (FirebaseAuth.getInstance().currentUser == null) {
            return chain.proceed(originalRequest);
        }

        val user: FirebaseUser = FirebaseAuth.getInstance().currentUser!!
        val task: Task<GetTokenResult> = user.getIdToken(false)
        val tokenResult: GetTokenResult = Tasks.await(task, 10, TimeUnit.SECONDS)
        val idToken = tokenResult.token

        if (idToken == null) {
            return chain.proceed(originalRequest)
        }

        val newRequest = originalRequest.newBuilder()
            .header("Authorization", "Bearer ${idToken}")
            .build()

        return chain.proceed(newRequest)
    }
}
