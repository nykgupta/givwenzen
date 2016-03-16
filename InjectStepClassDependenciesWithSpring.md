# Introduction #

This is a sample of one way to instantiate step classes with their dependencies injected by Spring.


# Details #
First we create the step definition class using TDD. Then we annotate it with Spring annotations to show which dependencies need injecting.
```
@Configurable(autowire = Autowire.BY_NAME, dependencyCheck = true)
@DomainSteps
class AutowiredStepDefinition {
   private Dummy dummy;

   @Autowired(required = true)
   public void setDummy(Dummy dummy) {
      this.dummy = dummy;
   }

  @DomainStep(“do something with dummy”
  public void doSomething() {
    dummy.blahBlahBlah();
  }
}
```

Then we create an implementation of `org.givwenzen.annotations.InstantiationStrategy` to do the work of instantiating the step class if it is Spring-injectable.

```
public class SpringInstantiationStrategy implements InstantiationStrategy {
   private ApplicationContext applicationContext;

   public SpringInstantiationStrategy(ApplicationContext applicationContext) {
      this.applicationContext = applicationContext;
   }

   public Object instantiate(Class markedClass, Object parameter) throws InvocationTargetException, InstantiationException, IllegalAccessException {
      if (!markedClass.isAnnotationPresent(Configurable.class)) {
         return null;
      }

      AutowireCapableBeanFactory factory = applicationContext.getAutowireCapableBeanFactory();
      return factory.createBean(markedClass, AutowireCapableBeanFactory.AUTOWIRE_AUTODETECT, true);
   }
}
```

Then we need to create the `org.givwenzen.GivWenZenExecutor` which will use our `SpringInstantiationStrategy `. You could do that in a subclass of `org.givwenzen.GivWenZenForSlim`

```
public class MyGivWenZenForSlim extends GivWenZenForSlim {
   private static GivWenZenExecutor executor = null;

   public AlertDomainStepsForSlim() {
      super(createGivWenZenExecutor());
   }

   protected static DomainStepExecutor createGivWenZenExecutor() {
      if (executor != null) return executor;
	   
      executor  = GivWenZenExecutorCreator.instance()
         .customInstantiationStrategies(autowireStepDefinitionClassesWithSpring())
         .create();
      return executor;
   }

   private static InstantiationStrategy autowireStepDefinitionClassesWithSpring() {
      // take a deep breath
      return new SpringInstantiationStrategy(
         new ClassPathXmlApplicationContext("applicationContext.xml"));
   }
}
```

Don't forget to use your new subclass in the test page or [SetUp](http://fitnesse.org/FitNesse.UserGuide.SpecialPages).
```
|script|
|start|my giv wen zen for slim|
```

That's it. It would be nice if there was a simpler way to plug in the `InstantiationStrategy`. That was a lot of rigamarole to go through.