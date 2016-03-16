### Some [Cucumber](http://cukes.info/) equivalences in [FitNesse](http://fitnesse.org/) ###

#### [Cucumber Background](http://wiki.github.com/aslakhellesoy/cucumber/background) ####
Using Suites and `SuiteSetUp` can give you the equivalent of a background or at least a similar idea.

#### [Cucumber Feature](http://wiki.github.com/aslakhellesoy/cucumber/cucumber-feature) ####
[GivWenZen](http://code.google.com/p/givwenzen) does not have features at this point.  Since I originally wanted to use it with [FitNesse](http://fitnesse.org/) the closest idea to a Feature would be a suite.  I try to organize a suite of tests around a feature.  Suites can have a [SuiteSetUp](http://fitnesse.org/FitNesse.UserGuide.SpecialPages) and a [SuiteTearDown](http://fitnesse.org/FitNesse.UserGuide.SpecialPages) to have state that is shared between scenarios (test pages) in [FitNesse](http://fitnesse.org/)

#### [Cucumber Scenario](http://wiki.github.com/aslakhellesoy/cucumber/feature-introduction) ####
[GivWenZen](http://code.google.com/p/givwenzen) does not have the idea of a scenario at this point.  If you use it with [FitNesse](http://fitnesse.org/) the closest idea to a is a test page.  I try to organize such that each test page contains a single scenario.  Each page can have a [SetUp](http://fitnesse.org/FitNesse.UserGuide.SpecialPages) and [TearDown](http://fitnesse.org/FitNesse.UserGuide.SpecialPages) page similar to a scenario in Cucumber.

#### [Cucumber Tags](http://wiki.github.com/aslakhellesoy/cucumber/tags) ####
[GivWenZen](http://code.google.com/p/givwenzen) does not have the idea of a tag at this point.  If you use it with [FitNesse](http://fitnesse.org/) you can use the [FitNesse's](http://fitnesse.org/) built tag support found in the properties of a page.