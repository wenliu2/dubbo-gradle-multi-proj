package com.ebay.wenliu2.dubbo.services

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.util.concurrent.CountDownLatch

@EnableDubbo
@SpringBootApplication
open class SayGoodByeApp {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SayGoodByeApp::class.java, *args)
            val countDown = CountDownLatch(1)
            countDown.await()
        }
    }
}