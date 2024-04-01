package com.example.test_movie_app

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class ShowsListScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun validate_topBar_title_visibility(){
        composeTestRule.onNodeWithText("Shows List")
            .assertIsDisplayed()
    }

    @Test
    fun validate_shows_list_visibility(){
        composeTestRule.apply{
            Thread.sleep(4000)
            onNodeWithTag("shows_list").assertIsDisplayed()
        }
    }
    @Test
    fun validate_progressBar_visibility(){
        composeTestRule.apply{
            onNodeWithTag("progress").assertIsDisplayed()
        }
    }

}