### Missing step methods end up as exceptions ###

#### Running the test will display an error like the following with an example implementation of the step method. ####
```
|import|
|org.givwenzen|

|script|
|start|giv wen zen for slim|

|script|
|given|i do not have this method|
```

---

```
__EXCEPTION__:org.givwenzen.DomainStepNotFoundException: 
You need a step class with an annotated method matching this pattern: 'i do not have this method'
The step class should be placed in the package or sub-package of bdd.steps.
Example:
  @DomainSteps
  public class StepClass {

    @DomainStep("i do not have this method")
    public void domainStep() {
      // TODO implement step
    }  

  }
```