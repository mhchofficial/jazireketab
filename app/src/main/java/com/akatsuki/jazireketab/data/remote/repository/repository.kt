package com.akatsuki.jazireketab.data.remote.repository


import com.akatsuki.jazireketab.data.remote.InterfaceApi
import com.akatsuki.jazireketab.data.remote.Resource
import com.akatsuki.jazireketab.models.TopCatModel
import com.akatsuki.jazireketab.models.test.ListModel.ListModelResponse
import com.akatsuki.jazireketab.models.test.TestModel
import com.akatsuki.jazireketab.models.test.book_details.BookDetails_response
import com.akatsuki.jazireketab.models.test.cat.CatModelTest
import com.akatsuki.jazireketab.models.test.mybooks.MyBooksResponse
import com.akatsuki.jazireketab.models.test.search.SearchModelTest
import com.akatsuki.jazireketab.ui.fragments.list_fragment.ListViewModel
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



    suspend fun cats(): Resource<CatModelTest> {
        val response = try {
            api.cats().body()
        } catch (e: Exception) {
            return Resource.Errors("An unknown error occurred.")
        }
        return Resource.Success(response!!)
    }

    suspend fun search(): Resource<SearchModelTest> {
        val response = try {
            api.stest().body()
        } catch (e: Exception) {
            return Resource.Errors("An unknown error occurred.")
        }
        return Resource.Success(response!!)
    }


    suspend fun mybooks(): Resource<MyBooksResponse> {
        val response = try {
            api.MyBooks().body()
        } catch (e: Exception) {
            return Resource.Errors("An unknown error occurred.")
        }
        return Resource.Success(response!!)
    }

    suspend fun book_datails(): Resource<BookDetails_response> {
        val response = try {
            api.BookDetails().body()
        } catch (e: Exception) {
            return Resource.Errors("An unknown error occurred.")
        }
        return Resource.Success(response!!)
    }

    suspend fun lists(): Resource<ListModelResponse> {
        val response = try {
            api.lists().body()
        } catch (e: Exception) {
            return Resource.Errors("An unknown error occurred.")
        }
        return Resource.Success(response!!)
    }


}