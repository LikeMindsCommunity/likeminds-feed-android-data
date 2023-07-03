package com.likeminds.likemindsfeed.initiateuser

import android.app.Application
import com.likeminds.likemindsfeed.LMFeedClient
import kotlinx.coroutines.runBlocking
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
    }

    @Test
    fun `is member state api running`() = runBlocking {
        val response = client.getMemberState()
    }
}