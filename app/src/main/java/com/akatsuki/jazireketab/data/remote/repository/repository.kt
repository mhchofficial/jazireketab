package com.akatsuki.jazireketab.data.remote.repository


import com.akatsuki.jazireketab.data.remote.InterfaceApi
import com.akatsuki.jazireketab.data.remote.Resource
import com.akatsuki.jazireketab.models.TopCatModel
import com.akatsuki.jazireketab.models.test.TestModel
import javax.inject.Inject

class repository @Inject constructor(
    private val api: InterfaceApi,

    ){


    suspend fun test(): Resource<TestModel> {
        val response = try {
            api.search().body()
        } catch (e: Exception) {
            return Resource.Errors("An unknown error occurred.")
        }
        return Resource.Success(response!!)
    }


}