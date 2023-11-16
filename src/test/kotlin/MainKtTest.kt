import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun testId() {

        val post =  Post(
        0, 11, 22, "text", 1699473307, "https://www.unixtimestamp.com/ru/", "post",
        true, true, true, true, true
        )

       val result = WallService.add(post)

        assertNotEquals(post.id,result)
    }

    @Test
    fun updateTrue(){
        val post =  Post(
            1, 11, 22, "text", 1699473307, "https://www.unixtimestamp.com/ru/", "post",
            true, true, true, true, true
        )

        WallService.add(post)
        val result = WallService.update(post)
        assertEquals(true,result)
    }

    @Test
    fun updateFalse(){
        val post =  Post(
            0, 11, 22, "text", 1699473307, "https://www.unixtimestamp.com/ru/", "post",
            true, true, true, true, true
        )

        WallService.add(post)
        val result = WallService.update(post)
        assertEquals(false,result)
    }
}