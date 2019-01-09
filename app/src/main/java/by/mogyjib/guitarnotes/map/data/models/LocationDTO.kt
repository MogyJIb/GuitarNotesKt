package by.mogyjib.guitarnotes.map.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LocationDTO(

        @Expose
        @SerializedName("lat")
        var latitude: Double,

        @Expose
        @SerializedName("lng")
        var longitude: Double
) : Serializable