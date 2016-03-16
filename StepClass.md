### How to create a step class ###

Step Classes are plain old java classes (POJOs) that are annotated with `org.givwenzen.DomainSteps`

By default the `org.givwenzen.GivWenZenExecutor` class looks for the steps in the package bdd.steps and any sub-packages.

Example:
```
   @DomainSteps
   public class DomainSteps {
   }
```

See http://wiki.github.com/aslakhellesoy/cucumber/step-organisation