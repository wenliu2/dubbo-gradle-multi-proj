package com.ebay.wenliu2.dubbo.services

import com.ebay.wenliu2.dubbo.api.SayGoodBye
import com.ebay.wenliu2.dubbo.api.SayHello
import org.apache.dubbo.config.annotation.Service

@Service(
    registry = ["\${dubbo.registry.id}"],
    application = "\${dubbo.application.id}",
    version = "\${dubbo.service.version}",
    protocol = ["\${dubbo.protocol.id}"]
)
class SayGoodByeImpl: SayGoodBye {
    override fun goodbye(name: String): String {
        return "GoodBye $name"
    }
}