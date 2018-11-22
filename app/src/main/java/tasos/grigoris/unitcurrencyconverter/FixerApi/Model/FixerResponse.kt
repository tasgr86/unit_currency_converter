package tasos.grigoris.unitcurrencyconverter.FixerApi.Model

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class FixerResponse(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("rates")
	val rates: HashMap<String, String>? = null,

	@field:SerializedName("timestamp")
	val timestamp: Long? = null,

	@field:SerializedName("base")
	val base: String? = null

)