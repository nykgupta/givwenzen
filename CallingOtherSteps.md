### Sometimes steps you want are in a different step class ###

If your step class has a constructor that [GivWenZen](http://code.google.com/p/givwenzen) as the only parameter then it will be constructed using this constructor.  This will allow you to call steps from any step class.

Example:
```
  @DomainSteps
  public class SomeSteps {
    private GivWenZen givWenZen;

    public SomeSteps(GivWenZen givWenZen) {
      this.givWenZen = givWenZen;
    }

    @DomainStep("I do something")
    public void doSomething() {
      givWenZen.given("I do something else");
    }
  }
```