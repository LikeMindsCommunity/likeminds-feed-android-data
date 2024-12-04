package com.likeminds.internalsdk

import android.app.Application
import com.google.gson.Gson
import com.likeminds.internalsdk.comment.CommentApi
import com.likeminds.internalsdk.comment.CommentApiImpl
import com.likeminds.internalsdk.configuration.ConfigurationApi
import com.likeminds.internalsdk.configuration.ConfigurationApiImpl
import com.likeminds.internalsdk.db.LMFeedRoomDatabase
import com.likeminds.internalsdk.db.dao.*
import com.likeminds.internalsdk.di.*
import com.likeminds.internalsdk.helper.HelperApi
import com.likeminds.internalsdk.helper.HelperApiImpl
import com.likeminds.internalsdk.moderation.ModerationApi
import com.likeminds.internalsdk.moderation.ModerationApiImpl
import com.likeminds.internalsdk.notificationfeed.NotificationFeedApi
import com.likeminds.internalsdk.notificationfeed.NotificationFeedApiImpl
import com.likeminds.internalsdk.poll.PollApi
import com.likeminds.internalsdk.poll.PollApiImpl
import com.likeminds.internalsdk.post.PostApi
import com.likeminds.internalsdk.post.PostApiImpl
import com.likeminds.internalsdk.sdk.*
import com.likeminds.internalsdk.sdk.util.SDKPreferences
import com.likeminds.internalsdk.topic.TopicApi
import com.likeminds.internalsdk.topic.TopicApiImpl
import com.likeminds.internalsdk.feed.FeedApi
import com.likeminds.internalsdk.feed.FeedApiImpl
import com.likeminds.internalsdk.search.SearchApi
import com.likeminds.internalsdk.search.SearchApiImpl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FeedSDK {
    private var sdkComponent: LMFeedSDKComponent? = null

    @Inject
    lateinit var application: Application

    @Inject
    lateinit var gson: Gson

    @Inject
    lateinit var sdkApiImpl: SDKApiImpl

    @Inject
    lateinit var feedApiImpl: FeedApiImpl

    @Inject
    lateinit var postApiImpl: PostApiImpl

    @Inject
    lateinit var refreshTokenApiImpl: RefreshTokenApiImpl

    @Inject
    lateinit var commentApiImpl: CommentApiImpl

    @Inject
    lateinit var moderationApiImpl: ModerationApiImpl

    @Inject
    lateinit var helperApiImpl: HelperApiImpl

    @Inject
    lateinit var notificationFeedApiImpl: NotificationFeedApiImpl

    @Inject
    lateinit var topicApiImpl: TopicApiImpl

    @Inject
    lateinit var searchApiImpl: SearchApiImpl

    @Inject
    lateinit var configurationApiImpl: ConfigurationApiImpl

    @Inject
    lateinit var userDao: UserWithRightsDao

    @Inject
    lateinit var postDao: PostWithAttachmentsDao

    @Inject
    lateinit var configurationsDao: ConfigurationDao

    @Inject
    lateinit var feedRoomDatabase: LMFeedRoomDatabase

    @Inject
    lateinit var pollApiImpl: PollApiImpl

    @Inject
    lateinit var sdkPreferences: SDKPreferences

    var lmInternalCallback: LMInternalCallback? = null

    companion object {
        private var feedSDKInstance: FeedSDK? = null
        const val LOG_TAG = "LikeMinds"

        @JvmStatic
        fun getInstance(): FeedSDK {
            if (feedSDKInstance == null) {
                feedSDKInstance = FeedSDK()
            }
            return feedSDKInstance!!
        }
    }

    fun initialize(
        lmFeedSDKSharedResources: LMFeedSDKSharedResources,
        lmInternalCallback: LMInternalCallback?
    ) {
        initSDKComponent(lmFeedSDKSharedResources)
        this.lmInternalCallback = lmInternalCallback
    }

    private fun initSDKComponent(lmFeedSDKSharedResources: LMFeedSDKSharedResources) {
        if (sdkComponent == null) {
            sdkComponent = DaggerLMFeedSDKComponent.builder()
                .sdkSharedResources(lmFeedSDKSharedResources)
                .build()
            sdkComponent?.inject(this)
        }
    }

    fun getSDKApi(): SDKApi {
        return sdkApiImpl
    }

    fun feedApi(): FeedApi {
        return feedApiImpl
    }

    fun getCommentApi(): CommentApi {
        return commentApiImpl
    }

    fun getPostApi(): PostApi {
        return postApiImpl
    }

    fun getModerationApi(): ModerationApi {
        return moderationApiImpl
    }

    fun getHelperApi(): HelperApi {
        return helperApiImpl
    }

    fun getNotificationFeedApi(): NotificationFeedApi {
        return notificationFeedApiImpl
    }

    fun getTopicApi(): TopicApi {
        return topicApiImpl
    }

    fun getSearchApi(): SearchApi {
        return searchApiImpl
    }

    fun getConfigurationApi(): ConfigurationApi {
        return configurationApiImpl
    }

    fun getUserWithRightsDao(): UserWithRightsDao {
        return userDao
    }

    fun getPostWithAttachmentsDao(): PostWithAttachmentsDao {
        return postDao
    }

    fun getConfigurationDao(): ConfigurationDao {
        return configurationsDao
    }

    fun getDBInstance(): LMFeedRoomDatabase {
        return feedRoomDatabase
    }

    fun getPollApi(): PollApi {
        return pollApiImpl
    }

    fun getSDKPreferences(): SDKPreferences {
        return sdkPreferences
    }
}