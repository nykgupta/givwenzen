### Make your steps easier to read and reuse common captures ###

One of the things we have found to help readability in the regular expressions is to use constants. (thanks to Kelly Mower for this idea)

So a method annotated as follows:
```
   @DomainStep("i have entered (\\d+) into the calculator")
```
A little better read:
```
   public static final String POSITIVE_NUMBER = "(\\d+)";

   @DomainStep("i have entered " + POSITIVE_NUMBER + " into the calculator")
```