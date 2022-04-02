package com.minyul.cms.ui

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PostController() {

    @GetMapping("/post/{postId}", produces = ["application/json"])
    fun findPost(@PathVariable postId: String): ResponseEntity<String> {

        return ResponseEntity.ok().body("ok");
    }
}