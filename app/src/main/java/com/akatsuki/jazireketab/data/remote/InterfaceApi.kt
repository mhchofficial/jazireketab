package com.akatsuki.jazireketab.data.remote

import com.akatsuki.jazireketab.models.TopCatModel
import com.akatsuki.jazireketab.models.test.TestModel
import retrofit2.Response
import retrofit2.http.*

interface InterfaceApi {


    @GET("test/jazireketab/test.json")
    suspend fun search(
    ): Response<TestModel>


}