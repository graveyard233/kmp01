import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.server.testing.testApplication
import kotlinx.serialization.json.Json
import org.lyd.kmp01.module
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class TestApplication {

    @Test
    fun testRoot() = testApplication {
        application {
            module()
        }

        val response = client.get("/json")
        val tempMap = mapOf("message" to "Hello World! Json")
        val mapJson = Json.encodeToString(tempMap)
        assertEquals(HttpStatusCode.OK,response.status)
        assertEquals("json", response.contentType()?.contentSubtype)
        assertContains(response.bodyAsText(), mapJson)
    }
}