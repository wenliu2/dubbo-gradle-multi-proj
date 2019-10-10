package com.ebay.wenliu2.dubbo.router

import com.ebay.wenliu2.dubbo.api.SayHello
import org.apache.dubbo.config.annotation.Reference
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/router")
class RouterController {
    @Reference(
        version = "\${demo.service.version}",
        application = "\${dubbo.application.id}",
        check = false
    )
    private lateinit var helloService: SayHello

    @GetMapping("/hello")
    fun hello(@RequestParam name: String): String {
        val randomInt = Random().nextInt(10)
        if ( randomInt < 3 ){
            throw IllegalAccessError("Random fail")
        }
        return helloService.hello(name)
    }
}