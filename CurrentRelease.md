[Download latest version](http://code.google.com/p/givwenzen/downloads/list)

# `GivWenZen` 1.0.1 #
## Enhancements ##
  * simple Levenshtein distance to find similar
methods when method is not found

## Defects Fixed ##
  * fix to format issues with exception message when a step is missing

# `GivWenZen` 1.0 #
## Enhancements ##
  * added pom to be used for maven central deployment
  * also allows src to be built with maven or ant now

# `GivWenZen` Beta 10 Released #
## Enhancements ##
  * [Added vararg and array of values support for step parameters](http://code.google.com/p/givwenzen/issues/detail?id=13&can=1&q=beta10)
  * [Convention added for finding new MethodParameterParser without GWZ code change](http://code.google.com/p/givwenzen/issues/detail?id=16&can=1&q=beta10)

## Defects Fixed ##
  * missing src from with dependencies jar
  * better message for steps not found errors

[All issues](http://code.google.com/p/givwenzen/issues/list?can=1&q=beta10&colspec=ID+Type+Status+Priority+Milestone+Owner+Summary&cells=tiles)


---


# `GivWenZen` Beta 9 Released #
## Enhancements ##
  * Builder added for instantiation states
  * Updated to new FitNesse release

## Defects Fixed ##
  * eclipse and intellij projects are working again


---


# `GivWenZen` Beta 8 Released #
## Enhancements ##
  * GivWenZenExecutorCreator - allows creating a custom executor to override the defaults without knowing the details of how it is done.  Much more convenient.
  * Added the ability to have multiple custom state objects.  WARNING - there is a change to GivWenZenExecutor constructor parameter order.  Use the GivWenZenExecutorCreator to avoid these issues in the future.
  * InteliJ 9 project folder.


---


# `GivWenZen` Beta 7 Released #

This release adds more examples, updates to the latest versions of fitnesse and google collections.

Due to an always breaking/changing reflections dependency added the patched version of the source to givwenzen source and removed that jar.

Added intellij 9 modules.


---


# `GivWenZen` Beta 6 Released #

Beta 6 adds [FitLibrary](http://fitlibrary.wiki.sourceforge.net/) examples and a fix for finding steps in jars.

## Enhancements ##
  * Added `FitLibrary` examples using `DoFixture`.  Very simple to do.
  * http://weswilliamz.blogspot.com/2009/11/givwenzen-and-fitlibrary.html
  * http://weswilliamz.blogspot.com/2009/11/givwenzen-and-fitlibrary-part-2.html
  * http://weswilliamz.blogspot.com/2009/11/givwenzen-and-fitlibrary-part-3.html
  * http://weswilliamz.blogspot.com/2009/11/givwenzen-and-fitlibrary-part-4.html

## Defects Fixed ##
  * Issue with finding steps in jars.  There is a new patched version of Reflection 0.9.4


---


# `GivWenZen` Beta 5 Released #

The new beta release has better documentation and examples and defect corrections.

# Details #

## Enhancements ##
  * New `FitNesse` tests that both show how to use `GivWenZen` features and test those features at the same time.
  * `FitNesse` examples and tests have links to source related to them.
  * Examples were separated from tests and new examples jar created.  Test are only available by getting the source now.
  * `FitNesse` CSS changes to hide table borders and `FitNesse` 'technical' rows.  Makes the test look more like specs.
  * updated to reflections 0.9.4 which allows the latest version of google-collections to be used
  * added a sample of using `GivWenZen` with JUnit (only available in tests package currently).  This allows BDD functional specs/tests to be defined in JUnit as well as FitNesse.

## Defects Fixed ##
  * Issue with step text matching multiple steps was fixed. http://code.google.com/p/givwenzen/issues/detail?id=4&can=1