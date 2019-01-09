package by.mogyjib.guitarnotes.map.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ViewportDTO(

       @Expose
       @SerializedName("northeast")
       var northeast: LocationDTO,

       @Expose
       @SerializedName("southwest")
       var southwest: LocationDTO
) : Serializable