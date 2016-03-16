### Multiple step class locations can be useful ###

By default steps are located in the bdd.steps package and any of it's sub-packages.  There are times when you might want to change this to look for them in multiple locations.

---

An example of this is having a set of steps that operate against the business logic and the gui.  It would be nice to keep the same wording in each but perform different actions.  One way would be to have a different state object that is passed to the step classes combined with a unique application startup step for the business logic and gui.  In this case you could have all your shared steps in bdd.steps and your business logic specific startup steps in businesslogic.bdd.steps and for the gui in gui.bdd.steps.

---

#### Customizing the step package location(s) ####

To do this you will need to create the `org.givwenzen.GivWenZenExecutor` using the `org.givwenzen.GivWenZenExecutorCreator`.
```
   GivWenZenExecutor executor = GivWenZenExecutorCreator.instance()
      .stepClassBasePackage("my.step.package.")
      .create();
```
The easiest way to use this in extend the GivWenZenForSlim fixture and creating the GivWenZenExecutor in the default constructor and calling the constructor which takes a GivWenZenExecutor parameter. (of course you can always create your own fixture that uses the GivWenZenExecutor as well)