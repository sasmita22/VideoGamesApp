package com.hiroshisasmita.videogamesapp

import com.hiroshisasmita.videogamesapp.data.database.dao.GameFavoriteDao
import com.hiroshisasmita.videogamesapp.data.database.entity.GameEntity
import com.hiroshisasmita.videogamesapp.data.network.service.GameService
import com.hiroshisasmita.videogamesapp.data.repository.GameRepositoryImpl
import com.hiroshisasmita.videogamesapp.extension.enqueueResponse
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GameRepositoryTest {
    private val mockWebServer = MockWebServer()
    private lateinit var SUT: GameRepositoryImpl

    @MockK
    lateinit var gameFavoriteDao: GameFavoriteDao

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        mockWebServer.start()
        val gameService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GameService::class.java)

        SUT = GameRepositoryImpl(gameService, gameFavoriteDao)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `FetchGameDetail Success DataIsRetrievedWithFavoriteTrue`() = runTest {
        // Given
        mockWebServer.enqueueResponse("game_detail_response.json", 200)
        coEvery { gameFavoriteDao.fetchGameById(any()) } returns GameEntity(1, "", "", 0.0, "", "", 0, "")

        // When
        val result = SUT.fetchGameDetail(1)

        // Then
        Assert.assertNotNull(result)
        Assert.assertEquals(true, result.isFavorite)
    }

    @Test
    fun `FetchGameDetail Success DataIsRetrievedWithFavoriteFalse`() = runTest {
        // Given
        mockWebServer.enqueueResponse("game_detail_response.json", 200)
        coEvery { gameFavoriteDao.fetchGameById(any()) } returns null

        // When
        val result = SUT.fetchGameDetail(1)

        // Then
        Assert.assertNotNull(result)
        Assert.assertEquals(false, result.isFavorite)
    }

    @Test(expected = Exception::class)
    fun `FetchGameDetail 500ErrorResponse ThrowException`() = runTest {
        // Given
        mockWebServer.enqueue(MockResponse().setResponseCode(500))
        coEvery { gameFavoriteDao.fetchGameById(any()) } returns null

        // When
        SUT.fetchGameDetail(1)

        // Then
        // Success Expected : SUT must throw Error
    }


}