package com.github.ipan97.learnspringaop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Ipan Taupik Rahman
 */
@Configuration
@ComponentScan(basePackages = "com.github.ipan97.learnspringaop.aop")
@EnableAspectJAutoProxy
public class AspectConfig {
}
