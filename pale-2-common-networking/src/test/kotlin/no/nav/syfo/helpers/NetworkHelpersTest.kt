package no.nav.syfo.helpers

import java.io.IOException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class NetworkHelpersTest {
    @Test
    internal fun `Should find a IOException in a nested Exception`() {
        assertEquals(true, isCausedBy(Exception(IOException("Connection timed out")), 3, arrayOf(IOException::class)))

    }

    @Test
    internal fun `Should find not a IOException in a nested Exception`() {
        assertEquals(false, isCausedBy(
            Exception(IOException("Connection timed out")),
            3,
            arrayOf(RuntimeException::class)
        ))
    }

    @Test
    internal fun `Should not find a IOException whenever the cause stack is too deep`() {
        assertEquals(false, isCausedBy(
            Exception(Exception(Exception(IOException("Connection timed out")))),
            3,
            arrayOf(IOException::class)
        ))
    }

    @Test
    internal fun `Should find a IOException whenever the cause stack is 3 deep`() {
        assertEquals(true, isCausedBy(
            Exception(Exception(IOException("Connection timed out"))),
            3,
            arrayOf(IOException::class)
        ))
    }

}
