package com.example.tiptime

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat
import java.util.Locale


class TipCalculatorTests {

    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 10.00
        val tipPercent = 20.00

        val expectedTip = NumberFormat.getCurrencyInstance(Locale.US).format(2.0)
        val actualTip = calculateTip(
            amount = amount,
            tipPercent = tipPercent,
            roundUp = false
        )
        assertEquals(expectedTip, actualTip)
    }
}