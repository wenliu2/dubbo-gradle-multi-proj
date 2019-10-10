#!/usr/bin/env bash

export AGENT_PATH=$HOME/apps/apache-skywalking-apm-bin/agent 

java -javaagent:$AGENT_PATH/skywalking-agent.jar -Dskywalking.agent.service_name=say-hello -Dskywalking.agent.application_code=say-hello -Dskywalking.collector.servers=localhost:11800 -jar services/say-hello/build/libs/say-hello-1.0.jar 001
