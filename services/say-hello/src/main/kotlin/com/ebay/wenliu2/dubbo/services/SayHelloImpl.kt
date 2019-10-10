package com.ebay.wenliu2.dubbo.services

import com.ebay.wenliu2.dubbo.api.SayHello
import org.apache.dubbo.config.annotation.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import java.lang.IllegalArgumentException
import java.util.*

@Service(
    registry = ["\${dubbo.registry.id}"],
    application = "\${dubbo.application.id}",
    version = "\${dubbo.service.version}",
    protocol = ["\${dubbo.protocol.id}"]
)
class SayHelloImpl: SayHello {
    override fun hello(name: String): String {
        val randomInt = Random().nextInt(10)
        if ( randomInt < 5 ) {
            throw IllegalArgumentException("sayhello exception")
        }
        val id = SayHelloApp.ARGS["id"]?.let{it} ?: "Unknown"

        return "Hello $name, $id"
    }
}