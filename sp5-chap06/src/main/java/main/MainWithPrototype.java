package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.AppCtxWithPrototype;
import spring.Client;
import spring.Client2;

public class MainWithPrototype {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtxWithPrototype.class);
		
		Client client = ctx.getBean("client", Client.class);
		Client client_cmp = ctx.getBean("client", Client.class);
		Client2 client2 = ctx.getBean("client2", Client2.class);
		Client2 client2_cmp = ctx.getBean("client2", Client2.class);
		
		System.out.println("client == client_cmp : prototype : " + (client == client_cmp));
		System.out.println("client2 == client2_cmp : singleton : " + (client2 == client2_cmp));
	}
}
