package nejati.me.service.model

import java.util.ArrayList

import retrofit2.Response

class SingletonResponse private constructor() {

    private val responseList: MutableList<Response<*>>

    init {
        responseList = ArrayList()
    }

    fun getResponseList(): List<Response<*>> {
        return responseList
    }

    fun addResponse(value: Response<*>) {
        responseList.add(value)
    }

    fun clearResponse() {
        responseList.clear()
    }

    companion object {
        val instance = SingletonResponse()
    }


}
