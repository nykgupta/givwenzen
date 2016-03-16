### Maybe you will want to create your own logic to instantiate step classes ###

#### The step classes are instantiated by looking for constructor in the following order: ####

  1. Any custom `org.givwenzen.annotations.InstantiationStrategy`
  1. A constructor that takes an instance of the interface implemented by the `org.givwenzen.GivWenZenExecutor`, user's custom state class, or a super class of one of these objects  as a parameter
  1. A constructor that takes an instance of `org.givwenzen.GivWenZenExecutor` or user's custom state class or super class of one of them as a parameter
  1. An no parameter constructor

#### Custom Instantiation Strategy ####

To do this you will need to have create an implementation of `org.givwenzen.annotations.InstantiationStrategy`.

Implement the method:
```
   InstantiationState instantiate(Class markedClass, Object parameter)
```
If the step Class that is passed in as the first parameter can be created using your custom strategy then create and return the object in an instance of the `org.givwenzen.annotations.InstantiationState` interface (see `org.givwenzen.annotations.DefaultInstantiationState`).  If it cannot be created by your strategy then return `org.givwenzen.annotations.DefaultInstantiationState.UNINSTANTIATED`.

---

To use this custom implementation you must create the `org.givwenzen.GivWenZenExecutor` using the `org.givwenzen.GivWenZenExecutorCreator` telling it what your custom instantiation object(s) is/are:
```
   GivWenZenExecutor executor = GivWenZenExecutorCreator.instance()
      .customInstantiationStrategies(new MyCustomInstantiationStrategy())
      .create();
```


---

See an [example](InjectStepClassDependenciesWithSpring.md) using spring to instantiate the step classes.