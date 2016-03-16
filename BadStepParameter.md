### Bad step parameters end up as exceptions ###

#### Running the test will show an error when you have a bad parameter for a step. Example: ####
```
|import|
|org.givwenzen|

|script|
|start|giv wen zen for slim|

|script|
|given|i have entered 500000000000 into the calculator|
```

---

```
__EXCEPTION__:org.givwenzen.InvalidDomainStepParameterException: 
Invalid step parameters in method pattern: i have entered 500000000000 into the calculator
  found matching method annotated with: i have entered (\d+) into the calculator
  method signature is: public void bdd.steps.ExampleSteps.enterNumber(int)
  step class is: bdd.steps.ExampleSteps
	at java.lang.NumberFormatException.forInputString(Unknown Source)
	at java.lang.Integer.parseInt(Unknown Source)
	at java.lang.Integer.valueOf(Unknown Source)
        ...
```

---

As you can see the test passed in a number that could not be converted into an int as the step method required.