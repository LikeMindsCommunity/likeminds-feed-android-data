package com.likeminds.internalsdk.sdk.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

//TODO: Confirm

@Parcelize
@Keep
class _Community_ private constructor(
    var id: String,
    var name: String,
//    @SerializedName("image_url")
//    var imageUrl: String?,
//    var purpose: String?,
//    var about: String?,
//    @SerializedName("branding")
//    var branding: Branding?,
//    @SerializedName("members_count")
//    var membersCount: Int?,
//    @SerializedName("is_member")
//    var isMember: Boolean,
//    @SerializedName("pending_members_count")
//    var pendingMembersCount: Int,
//    @SerializedName("pending_chatroom_count")
//    var pendingChatRoomCount: Int,
//    @SerializedName("open_reports_count")
//    var openReportsCount: Int,
//    @SerializedName("collabcard_unseen")
//    var chatroomUnseen: Int,
//    @SerializedName("updated_at")
//    var updatedAt: String?,
//    @SerializedName("is_admin")
//    var isAdmin: Boolean,
//    var state: Int?,
//    @SerializedName("member_state")
//    var memberState: Int?,
//    @SerializedName("created_by")
//    var createdBy: String?,
//    @SerializedName("managed_by")
//    var managedBy: String?,
//    @SerializedName("date")
//    var date: String?,
//    @SerializedName("type")
//    var type: Int?,
//    @SerializedName("sub_type")
//    var subType: Int?,
//    @SerializedName("click_state")
//    var clickState: Int?,
//    @SerializedName("chatroom_count")
//    var chatroomCount: Int?,
//    var actions: List<CommunityHomeAction>?,
//    @SerializedName("new_chatroom_users")
//    var newChatRoomUsers: List<Member>?,
//    @SerializedName("chatroom_users")
//    var chatRoomUsers: List<Member>?,
//    @SerializedName("member_right_states")
//    var memberRightStates: List<Int>?,
//    @SerializedName("order_time")
//    var orderTime: Long?,
//    @SerializedName("menu")
//    var menu: List<String>?,
//    @SerializedName("leave_community")
//    var leaveCommunity: CommunityLeave?,
//    @SerializedName("is_paid")
//    var isPaid: Boolean?,
//    @SerializedName("auto_approval")
//    var autoApproval: Boolean?,
//    @SerializedName("grace_period")
//    var gracePeriod: Long?,
//    @SerializedName("is_discoverable")
//    var isDiscoverable: Boolean?,
//    @SerializedName("website_url")
//    var websiteUrl: String?,
//    @SerializedName("referral_enabled")
//    var referralEnabled: Boolean?,
//    @SerializedName("community_setting_rights")
//    var communitySettingRights: List<ManagementRightPermissionData>?,
//    @SerializedName("likeminds_plan")
//    var likeMindsPlan: String?,
//    @SerializedName("is_freemium_community")
//    var isFreemiumCommunity: Boolean,
) : Parcelable {

//    fun getMemberRightStatesAsString(): String? {
//        if (memberRightStates == null || memberRightStates?.isEmpty() == true) {
//            return null
//        }
//        val sb = StringBuilder()
//        for (i in memberRightStates!!.indices) {
//            if (sb.isEmpty()) {
//                sb.append("|")
//            }
//            sb.append(memberRightStates?.get(i))
//            sb.append("|")
//        }
//        return sb.toString()
//    }

    class Builder {
        private var id: String = ""
        private var name: String = ""
        //        private var imageUrl: String? = null
//        private var purpose: String? = null
//        private var about: String? = null
//        private var branding: Branding? = null
//        private var membersCount: Int? = null
//        private var isMember: Boolean = false
//        private var pendingMembersCount: Int = 0
//        private var pendingChatRoomCount: Int = 0
//        private var openReportsCount: Int = 0
//        private var chatroomUnseen: Int = 0
//        private var updatedAt: String? = null
//        private var isAdmin: Boolean = false
//        private var state: Int? = null
//        private var memberState: Int? = null
//        private var createdBy: String? = null
//        private var managedBy: String? = null
//        private var date: String? = null
//        private var type: Int? = null
//        private var subType: Int? = null
//        private var clickState: Int? = null
//        private var chatroomCount: Int? = null
//        private var actions: List<CommunityHomeAction>? = null
//        private var newChatRoomUsers: List<Member>? = null
//        private var chatRoomUsers: List<Member>? = null
//        private var memberRightStates: List<Int>? = null
//        private var orderTime: Long? = null
//        private var menu: List<String>? = null
//        private var leaveCommunity: CommunityLeave? = null
//        private var isPaid: Boolean? = null
//        private var autoApproval: Boolean? = null
//        private var gracePeriod: Long? = null
//        private var isDiscoverable: Boolean? = null
//        private var websiteUrl: String? = null
//        private var referralEnabled: Boolean? = null
//        private var communitySettingRights: List<ManagementRightPermissionData>? = null
//        private var likeMindsPlan: String? = null
//        private var isFreemiumCommunity: Boolean = false
//
        fun id(id: String) = apply { this.id = id }
        fun name(name: String) = apply { this.name = name }
        //        fun imageUrl(imageUrl: String?) = apply { this.imageUrl = imageUrl }
//        fun purpose(purpose: String?) = apply { this.purpose = purpose }
//        fun about(about: String?) = apply { this.about = about }
//        fun branding(branding: Branding?) = apply { this.branding = branding }
//        fun membersCount(membersCount: Int?) = apply { this.membersCount = membersCount }
//        fun isMember(isMember: Boolean) = apply { this.isMember = isMember }
//        fun pendingMembersCount(pendingMembersCount: Int) =
//            apply { this.pendingMembersCount = pendingMembersCount }
//
//        fun pendingChatRoomCount(pendingChatRoomCount: Int) =
//            apply { this.pendingChatRoomCount = pendingChatRoomCount }
//
//        fun openReportsCount(openReportsCount: Int) =
//            apply { this.openReportsCount = openReportsCount }
//
//        fun chatroomUnseen(chatroomUnseen: Int) = apply { this.chatroomUnseen = chatroomUnseen }
//        fun updatedAt(updatedAt: String?) = apply { this.updatedAt = updatedAt }
//        fun isAdmin(isAdmin: Boolean) = apply { this.isAdmin = isAdmin }
//        fun state(state: Int?) = apply { this.state = state }
//        fun memberState(memberState: Int?) = apply { this.memberState = memberState }
//        fun createdBy(createdBy: String?) = apply { this.createdBy = createdBy }
//        fun managedBy(managedBy: String?) = apply { this.managedBy = managedBy }
//        fun date(date: String?) = apply { this.date = date }
//        fun type(type: Int?) = apply { this.type = type }
//        fun subType(subType: Int?) = apply { this.subType = subType }
//        fun clickState(clickState: Int?) = apply { this.clickState = clickState }
//        fun chatroomCount(chatroomCount: Int?) = apply { this.chatroomCount = chatroomCount }
//        fun actions(actions: List<CommunityHomeAction>?) = apply { this.actions = actions }
//        fun newChatRoomUsers(newChatRoomUsers: List<Member>?) =
//            apply { this.newChatRoomUsers = newChatRoomUsers }
//
//        fun chatRoomUsers(chatRoomUsers: List<Member>?) =
//            apply { this.chatRoomUsers = chatRoomUsers }
//
//        fun memberRightStates(memberRightStates: List<Int>?) =
//            apply { this.memberRightStates = memberRightStates }
//
//        fun orderTime(orderTime: Long?) = apply { this.orderTime = orderTime }
//        fun menu(menu: List<String>?) = apply { this.menu = menu }
//        fun leaveCommunity(leaveCommunity: CommunityLeave?) =
//            apply { this.leaveCommunity = leaveCommunity }
//
//        fun isPaid(isPaid: Boolean?) = apply { this.isPaid = isPaid }
//        fun autoApproval(autoApproval: Boolean?) = apply { this.autoApproval = autoApproval }
//        fun gracePeriod(gracePeriod: Long?) = apply { this.gracePeriod = gracePeriod }
//        fun isDiscoverable(isDiscoverable: Boolean?) =
//            apply { this.isDiscoverable = isDiscoverable }
//
//        fun websiteUrl(websiteUrl: String?) = apply { this.websiteUrl = websiteUrl }
//        fun referralEnabled(referralEnabled: Boolean?) =
//            apply { this.referralEnabled = referralEnabled }
//
//        fun communitySettingRights(communitySettingRights: List<ManagementRightPermissionData>?) =
//            apply { this.communitySettingRights = communitySettingRights }
//
//        fun likeMindsPlan(likeMindsPlan: String?) = apply { this.likeMindsPlan = likeMindsPlan }
//
//        fun isFreemiumCommunity(isFreemiumCommunity: Boolean) =
//            apply { this.isFreemiumCommunity = isFreemiumCommunity }
//
        fun build() = _Community_(
            id,
            name,
//            imageUrl,
//            purpose,
//            about,
//            branding,
//            membersCount,
//            isMember,
//            pendingMembersCount,
//            pendingChatRoomCount,
//            openReportsCount,
//            chatroomUnseen,
//            updatedAt,
//            isAdmin,
//            state,
//            memberState,
//            createdBy,
//            managedBy,
//            date,
//            type,
//            subType,
//            clickState,
//            chatroomCount,
//            actions,
//            newChatRoomUsers,
//            chatRoomUsers,
//            memberRightStates,
//            orderTime,
//            menu,
//            leaveCommunity,
//            isPaid,
//            autoApproval,
//            gracePeriod,
//            isDiscoverable,
//            websiteUrl,
//            referralEnabled,
//            communitySettingRights,
//            likeMindsPlan,
//            isFreemiumCommunity
        )
    }

    fun toBuilder(): Builder {
        return Builder().id(id)
            .name(name)
//            .imageUrl(imageUrl)
//            .purpose(purpose)
//            .about(about)
//            .branding(branding)
//            .membersCount(membersCount)
//            .isMember(isMember)
//            .pendingMembersCount(pendingMembersCount)
//            .pendingChatRoomCount(pendingChatRoomCount)
//            .openReportsCount(openReportsCount)
//            .chatroomUnseen(chatroomUnseen)
//            .updatedAt(updatedAt)
//            .isAdmin(isAdmin)
//            .state(state)
//            .memberState(memberState)
//            .createdBy(createdBy)
//            .managedBy(managedBy)
//            .date(date)
//            .type(type)
//            .subType(subType)
//            .clickState(clickState)
//            .chatroomCount(chatroomCount)
//            .actions(actions)
//            .newChatRoomUsers(newChatRoomUsers)
//            .chatRoomUsers(chatRoomUsers)
//            .memberRightStates(memberRightStates)
//            .orderTime(orderTime)
//            .menu(menu)
//            .leaveCommunity(leaveCommunity)
//            .isPaid(isPaid)
//            .autoApproval(autoApproval)
//            .gracePeriod(gracePeriod)
//            .isDiscoverable(isDiscoverable)
//            .websiteUrl(websiteUrl)
//            .referralEnabled(referralEnabled)
//            .communitySettingRights(communitySettingRights)
//            .likeMindsPlan(likeMindsPlan)
//            .isFreemiumCommunity(isFreemiumCommunity)
    }
}