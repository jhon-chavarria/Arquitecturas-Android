package com.android.androidarchitecture.model

data class PodCastBody(val api_warning: String? = "", val body: List<PodCast>? = null)
data class PodCastBannerImage(val original: String? = "")
data class PodCastImages(val banner_image: PodCastBannerImage? = null)
data class PodCast(val id: Int? = null, var title: String? = "", val description: String? = "", val formatted_description: String? = "", val urls: PodCastImages? = null)