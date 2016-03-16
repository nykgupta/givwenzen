### Sometimes you want state to be shared between step classes ###

Similar to the ability to call other steps inside your step classes you can have a step class that is instantiated with a custom state object.

To use a custom state object you must create the `org.givwenzen.GivWenZenExecutor` using the `org.givwenzen.GivWenZenExecutorCreator` telling the creator what your custom state object(s) is/are:
```
   GivWenZenExecutor executor = GivWenZenExecutorCreator.instance()
      .customStepState(myCustomStateInstance)
      .create();
```
Create a step class that takes your custom state object (or it's base class or interface) in single parameter constructor.