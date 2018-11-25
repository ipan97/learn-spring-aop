package com.github.ipan97.learnspringaop.config;

import com.github.ipan97.learnspringaop.aop.logging.LoggingAspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;

/**
 * @author Ipan Taupik Rahman
 */
@Configuration
@EnableAspectJAutoProxy
public class LoggingAspectConfiguration {

	@Bean
	public LoggingAspect loggingAspect(Environment env) {
		return new LoggingAspect(env);
	}
}
