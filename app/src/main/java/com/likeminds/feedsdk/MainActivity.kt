package com.likeminds.feedsdk

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.configuration.model.ConfigurationType
import com.likeminds.likemindsfeed.configuration.model.GetCommunityConfigurationRequest
import com.likeminds.likemindsfeed.user.model.InitiateUserRequest
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "test_feed_data"
    }

    @SuppressLint("HardwareIds")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = LMFeedClient.getInstance()
        CoroutineScope(Dispatchers.IO).launch {
            val initiateResponse = client.initiateUser(
                InitiateUserRequest.Builder()
                    .apiKey("69edd43f-4a5e-4077-9c50-2b7aa740acce")
                    .uuid("10003")
                    .deviceId("adadad")
                    .userName("Ishaan")
                    .isGuest(false)
                    .build()
            )

            val memberStateResponse = client.getMemberState()

            Log.d(TAG, "initiateResponse: ${initiateResponse.data?.user?.sdkClientInfo?.uuid}")

            val communityConfigs = client.getCommunityConfigurations()

            Log.d(
                TAG,
                "communityConfigs API: ${communityConfigs.data?.configurations?.size}"
            )

            val profileMetaData = client.getCommunityConfiguration(
                GetCommunityConfigurationRequest.Builder()
                    .type(ConfigurationType.PROFILE_METADATA)
                    .build()
            )

            Log.d(
                TAG,
                "profileMetaData db: ${profileMetaData.data?.configuration?.value}"
            )
        }
    }
}