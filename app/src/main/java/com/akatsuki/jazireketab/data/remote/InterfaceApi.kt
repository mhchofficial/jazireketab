package com.akatsuki.jazireketab.data.remote

import com.akatsuki.jazireketab.models.TopCatModel
import com.akatsuki.jazireketab.models.test.ListModel.ListModelResponse
import com.akatsuki.jazireketab.models.test.TestModel
import com.akatsuki.jazireketab.models.test.book_details.BookDetails_response
import com.akatsuki.jazireketab.models.test.cat.CatModelTest
import com.akatsuki.jazireketab.models.test.mybooks.MyBooksResponse
import com.akatsuki.jazireketab.models.test.search.SearchModelTest
import retrofit2.Response
import retrofit2.http.*

interface InterfaceApi {


    @GET("test/jazireketab/test.json")
    suspend fun search(
    ): Response<TestModel>


    @GET("test/jazireketab/cat.json")
    suspend fun cats(
    ): Response<CatModelTest>

    @GET("test/jazireketab/search.json")
    suspend fun stest(
    ): Response<SearchModelTest>


    @GET("test/jazireketab/books.json")
    suspend fun MyBooks(
    ): Response<MyBooksResponse>


    @GET("test/jazireketab/book_details.json")
    suspend fun BookDetails(
    ): Response<BookDetails_response>

    @GET("test/jazireketab/list.json")
    suspend fun lists(
    ): Response<ListModelResponse>


}