package com.biskinler.helloworld;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Environment;
import com.biskinler.helloworld.resources.HelloWorldResource;
import com.biskinler.helloworld.health.TemplateHealthCheck;

public class HelloWorldService extends Service<HelloWorldConfiguration> {
	public static void main(String[] args) throws Exception {
		new HelloWorldService().run(args);
	}

	private HelloWorldService() {
		super("hello-world");
	}

	@Override
	protected void initialize(HelloWorldConfiguration configuration,
				  Environment environment) {
		final String template = configuration.getTemplate();
		final String defaultName = configuration.getDefaultName();
		environment.addResource(new HelloWorldResource(template, defaultName));
		environment.addHealthCheck(new TemplateHealthCheck(template));
	}
}
