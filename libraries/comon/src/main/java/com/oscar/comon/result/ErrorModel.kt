package com.oscar.comon.result

import com.google.gson.annotations.SerializedName
import com.oscar.constants.ERROR_UNKNOWN

data class ErrorModel(
    @field:SerializedName("status")
    val status: String = "",

    @field:SerializedName("message")
    override val message: String = "",

    @field:SerializedName("Description")
    val description: String? = null,

    @field:SerializedName("Code")
    val code: String? = null,

    @field:SerializedName("ErrorType")
    val errorType: String? = null,

    ) : Throwable()


fun getErrorModel(error: Throwable): ErrorModel {
    return if (error is ErrorModel) {
        error
    } else {
        ErrorModel(ERROR_UNKNOWN)
    }
}

fun ErrorModel?.getErrorMessage() = this?.message ?: ""
