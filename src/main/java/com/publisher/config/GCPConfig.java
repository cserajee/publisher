package com.publisher.config;

import javax.websocket.MessageHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.outbound.PubSubMessageHandler;

@Component
public class GCPConfig {

	 @Bean
	   @ServiceActivator(inputChannel = "myOutputChannel")
	   public PubSubMessageHandler messageSender(PubSubTemplate pubsubTemplate) {
	      return new PubSubMessageHandler(pubsubTemplate, "GCPTopic");
	   }

	   @MessagingGateway(defaultRequestChannel = "myOutputChannel")
	   public interface PubsubOutboundGateway {
	      void sendToPubsub(String text);
	   }
	   
}
