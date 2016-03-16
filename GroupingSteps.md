### StepClass allow you to group common test code together ###

One of the things I like about the step classes over plain fixtures is the ability to put step test methods together that deal with the same set of objects.  If you have a Catalog object you can put all the methods that call actions or verify the state of the catalog in a `bdd.steps.CatalogSteps` class.  If you are doing web testing and you have a Search page you should have a set of test steps in a `bdd.steps.SearchSteps` class.

Also see:

http://wiki.github.com/aslakhellesoy/cucumber/step-organisation