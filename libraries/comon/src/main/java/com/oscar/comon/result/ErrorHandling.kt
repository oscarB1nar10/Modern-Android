package com.oscar.comon.result

import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import com.oscar.constants.API_RESPONSE_CODE_401
import com.oscar.constants.API_RESPONSE_CODE_403
import com.oscar.constants.API_RESPONSE_CODE_404
import com.oscar.constants.ERROR_UNKNOWN
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException


class ErrorHandling {

    companion object {

        fun handleError(e: Throwable): ErrorModel {

            val error = parseErrorBody(e)

            if (e is HttpException &&
                (e.code() == API_RESPONSE_CODE_401 ||
                        e.code() == API_RESPONSE_CODE_403 ||
                        e.code() == API_RESPONSE_CODE_404)
            ) { // We don't show 404 errors to the users.
                // TODO("Determine how we are going to handle this peculiar errors")
                return error
            }

            return error
        }

        private fun parseErrorBody(e: Throwable): ErrorModel {
            val gson = GsonBuilder().create()
            var error = ErrorModel(ERROR_UNKNOWN)

            if (e !is HttpException) return error

            try {
                val errorBody = e.response()?.errorBody()?.charStream()
                error = gson.fromJson(errorBody, ErrorModel::class.java)
            } catch (e: IOException) {
                Timber.e(e)
            } catch (e: JsonSyntaxException) { // json is malformed
                Timber.e(e)
            } catch (e: IllegalStateException) { // parsed json resulted in null
                Timber.e(e)
            } catch (e: NullPointerException) {
                Timber.e(e)
            }
            return error
        }
    }
}