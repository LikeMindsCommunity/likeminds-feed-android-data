package com.likeminds.likemindsfeed.initiateUser

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserRequest
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@RunWith(AndroidJUnit4::class)
class InitiateIUserClientTest {

    private lateinit var client: LMFeedClient

    @Mock
    lateinit var application: Application

    @Before
    fun setup() {
        application = Mockito.mock(Application::class.java)
        Mockito.`when`(application.applicationContext).thenReturn(application)
        client = LMFeedClient.Builder(application).build()

        val mockPrefs: SharedPreferences = mock()
        `when`(
            application.applicationContext.getSharedPreferences(
                "chucker_preferences",
                Context.MODE_PRIVATE
            )
        )
            .thenReturn(mockPrefs);

        val request = InitiateUserRequest.Builder()
            .userId("10003")
            .apiKey("4f881a74-8d0b-4c73-9f60-3d2370216392")
            .userName("Ishaan Jain")
            .deviceId("898989898")
            .build()
        runBlocking {
            client.initiateUser(request)
        }
    }

    @Test
    fun anddd() = runBlocking {
        val response = client.getMemberState()
        Assert.assertEquals(true, response.success)
    }
}