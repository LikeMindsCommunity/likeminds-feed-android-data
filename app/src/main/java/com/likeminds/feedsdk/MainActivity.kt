package com.likeminds.feedsdk

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.likeminds.likemindsfeed.LMFeedClient
import com.likeminds.likemindsfeed.branding.model.BrandingRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = LMFeedClient.getInstance()
//        CoroutineScope(Dispatchers.IO).launch {
//            val result = client.initiateUser(
//                InitiateUserRequest(
//                    "10003",
//                    "Ishaan",
//                    false
//                )
//            )
//            withContext(Dispatchers.Main) {
//                Toast.makeText(
//                    this@MainActivity,
//                    "result: ${result?.initiateUser?.user?.name}",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        }

        CoroutineScope(Dispatchers.IO).launch {
            val result = client.getBranding(
                BrandingRequest.Builder().communityId("50418").build()
            )
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    "result: ${result?.branding?.basic?.primaryColor}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}