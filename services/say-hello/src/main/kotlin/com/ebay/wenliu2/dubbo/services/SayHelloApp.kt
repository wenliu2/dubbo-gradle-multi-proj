package com.ebay.wenliu2.dubbo.services

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.CountDownLatch

@EnableDubbo
@SpringBootApplication
open class SayHelloApp {
    companion object {
        var ARGS = mutableMapOf<String, String>()
        @JvmStatic
        fun main(args: Array<String>) {
            val strArgs = args.joinToString(",")
            println("args: $strArgs")
            val id = if ( args.isNotEmpty() ) args[0] else "Unknown"
            ARGS["id"] = id

            SpringApplication.run(SayHelloApp::class.java, *args)
            val countDown = CountDownLatch(1)
            countDown.await()
        }
    }
}

