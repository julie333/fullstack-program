
package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.HelloSpringConfig;
import hello.HelloSpringService;

public class HelloSpringDemo {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = //
			new AnnotationConfigApplicationContext(HelloSpringConfig.class);

		System.out.println("\n-----------------------------------------------------\n");

		// this will fail:
		// context.getBean(Number.class);

		HelloSpringService helloSpringService1 = context.getBean(HelloSpringService.class);
		System.out.println("Message 1: " + helloSpringService1.generateMessage());
		System.out.println("\n-----------------------------------------------------\n");

		HelloSpringService helloSpringService2 = context.getBean(HelloSpringService.class);
		System.out.println("Message 2: " + helloSpringService2.generateMessage());
		System.out.println("\n-----------------------------------------------------\n");

		System.out.println("service 1 == service 2: "//
				+ (helloSpringService1 == helloSpringService2));
		System.out.println("\n-----------------------------------------------------\n");

		// Old school "by name" -- not recommended.
		//		HelloSpringService helloSpringServiceByName = //
		//			(HelloSpringService) context.getBean("helloSpringService");

		HelloSpringService helloSpringServiceByName = //
			context.getBean("helloSpringService", HelloSpringService.class);
		System.out.println("Message by name: " + helloSpringServiceByName.generateMessage());
		System.out.println("\n-----------------------------------------------------\n");

		System.out.println("service 1 == service by name: "//
				+ (helloSpringService1 == helloSpringServiceByName));
		System.out.println("\n-----------------------------------------------------\n");

		System.out.println("Beans of type...");
		context.getBeansOfType(HelloSpringService.class)//
				.forEach((id, service) -> System.out.println(id + " says: " + service.generateMessage()));
	}

}
