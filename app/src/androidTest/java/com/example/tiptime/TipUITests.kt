
package com.example.tiptime

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat
import java.util.Locale
import com.example.tiptime.ui.theme.TipTimeTheme
import androidx.compose.ui.test.assertIsDisplayed

class TipUITests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            TipTimeTheme {
                TipTimeLayout()
            }
        }

        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")

        composeTestRule.onNodeWithText("Tip Percentage")
            .performTextInput("20")

        val expectedTip = NumberFormat.getCurrencyInstance(Locale.US).format(2.0)

        composeTestRule.onNodeWithText("Tip Amount: $expectedTip")
            .assertIsDisplayed()
    }
}
