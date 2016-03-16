### How to implement step methods ###

Step methods are methods in a step class that are annotated with `org.givwenzen.DomainStep` with a string value that is a regular expression that will be used to do matches against the text in the test.

#### Example: ####

the test:
```
|given|i have entered 50 into the calculator|
```

---

would need a method annotated like:
```
   @DomainStep("i have entered (\\d+) into the calculator")
   public void enterNumber(int number) {
      numbers.add(number);
   }
```
the captures, (\d+) in this example, from the match are passed as
[parameters](ParameterConversion.md) to the method.

[GivWenZen](http://code.google.com/p/givwenzen) throws an exception when steps are redundant.

[GivWenZen](http://code.google.com/p/givwenzen) does not throw an exception, at this point, when there are ambiguous steps.

see the `org.givwenzen.ExampleSteps` class in the givwenzen\_test.jar and the `SlimExamples`