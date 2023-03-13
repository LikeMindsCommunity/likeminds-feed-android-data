package com.likeminds.internalsdk.di.modules

import android.content.Context
import com.amazonaws.auth.CognitoCachingCredentialsProvider
import com.amazonaws.mobile.client.AWSMobileClient
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility
import com.amazonaws.regions.Region
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3Client
import com.likeminds.internalsdk.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AWSModule {

    @Provides
    @Singleton
    fun provideFinalTransferUtility(context: Context, s3Client: AmazonS3Client): TransferUtility {
        val bucketName: String = BuildConfig.URLS_MAP[BuildConfig.BUCKET_NAME].toString()
        return TransferUtility.builder()
            .context(context)
            .defaultBucket(bucketName)
            .awsConfiguration(AWSMobileClient.getInstance().configuration)
            .s3Client(s3Client)
            .build()
    }

    @Provides
    @Singleton
    fun provideCredProvider(context: Context): CognitoCachingCredentialsProvider {
        return CognitoCachingCredentialsProvider(
            context.applicationContext,
            BuildConfig.URLS_MAP[BuildConfig.IDENTITY_POOL_ID],
            Regions.AP_SOUTH_1
        )
    }

    @Provides
    @Singleton
    fun provideS3Client(credProvider: CognitoCachingCredentialsProvider): AmazonS3Client {
        val sS3Client = AmazonS3Client(credProvider, Region.getRegion(Regions.AP_SOUTH_1))
        sS3Client.setRegion(Region.getRegion(Regions.AP_SOUTH_1))
        return sS3Client
    }
}