package com.example.laboratorio11

import com.example.laboratorio11.network.dto.login.LoginRequest
import com.example.laboratorio11.network.service.AuthService
import com.google.gson.Gson
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var authService: AuthService

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        authService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthService::class.java)
    }

    @Test
    fun loginTest() = runTest{
        val mockResponse = MockResponse()
        mockResponse.setBody("""{"msg": "Login Successful", "token": "Testoken"}""")
        mockResponse.setResponseCode(200)
        mockWebServer.enqueue(mockResponse)

        val response = authService.login(LoginRequest("test@test.com", "12345678"))
        mockWebServer.takeRequest()

        Assert.assertEquals("Login Successful", response.message)
        Assert.assertEquals("Testoken", response.token)
    }

    @Test
    fun unsuccesfulLogin() = runTest{
        val mockResponse = MockResponse()
        mockResponse.setBody("""{"msg": "Check credentials"}""")
        mockWebServer.enqueue(mockResponse)

        val response = authService.login(LoginRequest("loremo", "lalal"))
        mockWebServer.takeRequest()

        Assert.assertEquals("Check credentials", response.message)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}