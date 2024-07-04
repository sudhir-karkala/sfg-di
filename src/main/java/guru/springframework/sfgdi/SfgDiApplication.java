package guru.springframework.sfgdi;

import guru.springframework.sfgdi.config.SfgConfiguration;
import guru.springframework.sfgdi.controllers.*;
import guru.springframework.sfgdi.datasources.FakeDataSource;
import guru.springframework.sfgdi.services.PrototypeBean;
import guru.springframework.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SfgDiApplication.class, args);
		MyController myController = (MyController) applicationContext.getBean("myController");
		System.out.println("---primary bean---");
		System.out.println(myController.sayHello());

		System.out.println("---property injected controller---");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) applicationContext.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.sayGreeting());

		System.out.println("---setter injected controller---");
		SetterInjectedController setterInjectedController = (SetterInjectedController) applicationContext.getBean("setterInjectedController");
		System.out.println(setterInjectedController.sayGreeting());

		System.out.println("---constructor injected controller---");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) applicationContext.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.sayGreeting());

		System.out.println("---I18nController---");
		I18nController i18nController = (I18nController) applicationContext.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		System.out.println("---PetService---");
		PetController petController = (PetController) applicationContext.getBean("petController");
		System.out.println(petController.whichPetIsTheBest());

		System.out.println("---Bean Scopes---");
		SingletonBean s1 = applicationContext.getBean(SingletonBean.class);
		System.out.println(s1.getMyScope());
		SingletonBean s2 = applicationContext.getBean(SingletonBean.class);
		System.out.println(s2.getMyScope());

		PrototypeBean p1 = applicationContext.getBean(PrototypeBean.class);
		System.out.println(p1.getMyScope());
		PrototypeBean p2 = applicationContext.getBean(PrototypeBean.class);
		System.out.println(p2.getMyScope());

		System.out.println("---Using properties source---");
		FakeDataSource fakeDataSource = applicationContext.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcUrl());

		System.out.println("---Using config properties binding bean---");
		SfgConfiguration sfgConfiguration = applicationContext.getBean(SfgConfiguration.class);
		System.out.println(sfgConfiguration.getUsername());
		System.out.println(sfgConfiguration.getPassword());
		System.out.println(sfgConfiguration.getJdbcUrl());
	}
}
