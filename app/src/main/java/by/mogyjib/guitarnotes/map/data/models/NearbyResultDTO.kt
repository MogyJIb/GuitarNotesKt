package by.mogyjib.guitarnotes.map.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NearbyResultDTO(

        @Expose
        @SerializedName("next_page_token")
        var nextToken: String?,

        @Expose
        @SerializedName("results")
        var places: List<PlaceBasicDTO>,

        @Expose
        @SerializedName("status")
        var responseStatus: String?
) : Serializable