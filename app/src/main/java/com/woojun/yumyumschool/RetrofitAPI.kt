package com.woojun.yumyumschool

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {
    @GET("mealServiceDietInfo")
    fun GetLunch(
        @Query("KEY") KEY: String,
        @Query("Type") Type: String,
        @Query("ATPT_OFCDC_SC_CODE") ATPT_OFCDC_SC_CODE: String,
        @Query("SD_SCHUL_CODE") SD_SCHUL_CODE: String,
    ): Call<FoodInfoList>

}