/*
 * Copyright 2019 dc-square GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.hivemq.extension.mqtt.message.log.interceptor;

import com.hivemq.extension.mqtt.message.log.MessageLogUtil;
import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.hivemq.extension.sdk.api.interceptor.subscribe.SubscribeInboundInterceptor;
import com.hivemq.extension.sdk.api.interceptor.subscribe.parameter.SubscribeInboundInput;
import com.hivemq.extension.sdk.api.interceptor.subscribe.parameter.SubscribeInboundOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Florian Limpöck
 * @since 1.0.0
 */
public class SubscribeInboundInterceptorImpl implements SubscribeInboundInterceptor {

    @NotNull
    private static final Logger log = LoggerFactory.getLogger(SubscribeInboundInterceptorImpl.class);
    private final boolean verbose;

    public SubscribeInboundInterceptorImpl(final boolean verbose) {
        this.verbose = verbose;
    }

    @Override
    public void onInboundSubscribe(final @NotNull SubscribeInboundInput subscribeInboundInput, final @NotNull SubscribeInboundOutput subscribeInboundOutput) {
        try {
            MessageLogUtil.logSubscribe(subscribeInboundInput, verbose);
        } catch (final Exception e) {
            log.debug("Exception thrown at inbound subscribe logging: ", e);
        }
    }
}
