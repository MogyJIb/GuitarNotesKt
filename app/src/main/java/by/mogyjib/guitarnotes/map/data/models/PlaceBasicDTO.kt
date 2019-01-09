package by.mogyjib.guitarnotes.map.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PlaceBasicDTO(

        @Expose
        @SerializedName("geometry")
        var geometry: GeometryDTO,

        @Expose
        @SerializedName("name")
        var name: String,

        @Expose
        @SerializedName("place_id")
        var placeId: String
) : Serializable