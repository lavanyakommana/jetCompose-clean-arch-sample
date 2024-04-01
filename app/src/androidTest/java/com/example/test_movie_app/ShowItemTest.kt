package com.example.test_movie_app

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.test_movie_app.Presentation.viewModels.components.ShowItem
import com.example.test_movie_app.domain.domain.model.ShowItem
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ShowItemTest {
    @get:Rule
    val composeTestRule= createComposeRule()

    @Before
    fun setup(){
      val  showItem = ShowItem(title = "Peron of Interest","https://static.tvmaze.com/uploads/images/original_untouched/81/202627.jpg")
        composeTestRule.setContent {
            ShowItem(showItem = showItem)
        }
    }
    @Test
    fun is_item_displayed(){
        composeTestRule.onNodeWithTag("showItem").assertIsDisplayed()
    }
}