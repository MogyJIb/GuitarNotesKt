package by.mogyjib.guitarnotes.map.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GeometryDTO(
    @Expose
    @SerializedName("location")
    var location: LocationDTO,

    @Expose
    @SerializedName("viewport")
    var viewport: ViewportDTO
) : Serializable