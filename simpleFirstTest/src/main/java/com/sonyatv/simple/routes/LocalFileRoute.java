package com.sonyatv.simple.routes;

import org.apache.camel.builder.RouteBuilder;

public class LocalFileRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file://target/inbox").to("file://target/outbox");		
	}

}
