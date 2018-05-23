package com.beesham.weatherapp

import com.beesham.weatherapp.extensions.toDateString
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.text.DateFormat

/**
 * @author Beesham Sarendranauth
 * Tests the extensions funtions of long to string
 */
class ExtensionsTest {

    @Test
    fun testLongToDateString() {
        assertEquals("Oct 19, 2015", 1445275635000L.toDateString())
    }


    @Test
    fun testDateStringFullFormat() {
        assertEquals("Monday, October 19, 2015", 1445275635000L.toDateString(DateFormat.FULL))
    }
}