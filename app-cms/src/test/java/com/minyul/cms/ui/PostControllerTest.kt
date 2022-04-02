package com.minyul.cms.ui

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*   // status, content
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print

@WebMvcTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @DisplayName("해당 ID의 포스트를 갖고 오는 테스트")
    @Test
    fun findPostById(){
        mockMvc.perform(get("/api/post/{postId}", 1))
            .andExpect(status().isOk)
            .andExpect(content().string("ok")
        ).andDo(print())
    }
}