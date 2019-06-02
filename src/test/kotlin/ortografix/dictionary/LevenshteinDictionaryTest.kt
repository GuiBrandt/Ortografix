package ortografix

import ortografix.dictionary.LevenshteinDictionary
import kotlin.test.*

import java.net.URL

class LevenshteinDictionaryTest {
    val dict: LevenshteinDictionary = LevenshteinDictionary()

    @Test
    fun adds() {
        dict.add("teste")
        assertEquals(1.0, dict.contains("teste"))
    }

    @Test
    fun gets() {
        dict.add("teste")
        assert(dict.get("test").any { it.match == "teste" })
    }

    @Test
    fun getsBest() {
        dict.add("teste")
        dict.add("testando")
        assertEquals("teste", dict.get("test").best)
    }
    
    @Test
    fun returnsZeroIfEmpty() {
        assertEquals(0.0, dict.contains("test"))
    }

    @Test
    fun containsFuzzy() {
        dict.add("teste")
        assertNotEquals(0.0, dict.contains("test"))
    }

    @Test
    fun notPerfectMatch() {
        dict.add("teste")
        assertNotEquals(1.0, dict.contains("test"))
    }
    
    @Test
    fun doesNotContainFuzzy() {
        dict.add("teste")
        assertEquals(0.0, dict.contains("abcd"))
    }
}