package com.likeminds.likemindsfeed.initiateuser

import android.app.Application
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.initiateUser.model.InitiateUserRequest
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class InitiateUserClientTest {

    private lateinit var client: LMFeedClient

    @Mock
    lateinit var application: Application

    @Before
    fun setup() {
        application = Mockito.mock(Application::class.java)
        Mockito.`when`(application.applicationContext).thenReturn(application)
        client = LMFeedClient.Builder(application).build()
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
    fun `is member state api running`() = runBlocking {
        val response = client.getMemberState()
        Assert.assertEquals(true, true)
    }
}