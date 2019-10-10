#!/usr/bin/env bash

export AGENT_PATH=$HOME/apps/apache-skywalking-apm-bin/agent 

java -javaagent:$AGENT_PATH/skywalking-agent.jar -Dskywalking.agent.service_name=router -Dskywalking.agent.application_code=router -Dskywalking.collector.servers=localhost:11800 -jar router/build/libs/router-1.0.jar
