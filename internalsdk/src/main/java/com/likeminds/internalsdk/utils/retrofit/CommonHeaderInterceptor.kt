package com.likeminds.internalsdk.utils.retrofit

import android.annotation.SuppressLint
import android.app.Application
import android.provider.Settings
import com.likeminds.internalsdk.BuildConfig
import com.likeminds.internalsdk.TokenManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class CommonHeaderInterceptor @Inject constructor(
    private val application: Application
) : Interceptor {
    @SuppressLint("HardwareIds")
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        val tokenManager = TokenManager.getInstance()
        if (!tokenManager.accessToken.isNullOrEmpty()) {
            requestBuilder.addHeader(AUTH, "Bearer ${tokenManager.accessToken}")
        }
        //todo remove
        requestBuilder.addHeader(X_MEMBER_ID, tokenManager.memberId.toString())
        requestBuilder.addHeader(X_PLATFORM_CODE, "an")
        requestBuilder.addHeader(X_VERSION_CODE, BuildConfig.APP_VERSION_CODE.toString())
        val deviceId =
            Settings.Secure.getString(application.contentResolver, Settings.Secure.ANDROID_ID)
        requestBuilder.addHeader(X_DEVICE_ID, deviceId)
        return chain.proceed(requestBuilder.build())
    }

    companion object {
        private const val X_MEMBER_ID = "x-member-id"
        private const val X_PLATFORM_CODE = "x-platform-code"
        private const val X_VERSION_CODE = "x-version-code"
        private const val X_DEVICE_ID = "x-device-id"
        private const val AUTH = "Authorization"
    }
}