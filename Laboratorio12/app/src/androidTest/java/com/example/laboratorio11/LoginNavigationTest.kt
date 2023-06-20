package com.example.laboratorio11

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.laboratorio11.ui.login.LoginFragment
import junit.framework.TestCase.assertEquals

class LoginNavigationTest {

    fun testNavigationToWelcome() {
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        )
        var loginScenario = launchFragmentInContainer<LoginFragment>(themeResId = R.style.Theme_Laboratorio11)

        loginScenario.onFragment { fragment ->
            navController.setGraph(R.navigation.nav_graph)
            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        onView(withId(R.id.email_txt)).perform(typeText("test@test.com"))
        onView(withId(R.id.password_txt)).perform(typeText("12345678"))
        onView(withId(R.id.loginBtn)).perform(click())
        Thread.sleep(2000)

        assertEquals(navController.currentDestination?.id, R.id.welcomeFragment)

    }
}