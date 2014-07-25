package com.sonyatv.simple.routes;

import java.io.File;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.CamelTestSupport;

public class TestLocalFileRoute extends CamelTestSupport{
	
	@Override
	protected RouteBuilder createRouteBuilder()throws Exception{
		return new LocalFileRoute();
	}
	
	public void testFileRoute()throws Exception{
		template.sendBodyAndHeader("file://target/inbox", "Hello World",
				Exchange.FILE_NAME, "hello.txt");
		Thread.sleep(1000);
		
		File target = new File("target/outbox/hello.txt");
		assertTrue("File not moved", target.exists());
	}
}
