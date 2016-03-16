### Getting started with [GivWenZen](http://code.google.com/p/givwenzen) ###

### 1) Download the zip with the full project and unzip it into a directory. Go to [downloads](http://code.google.com/p/givwenzen/downloads/list) ###

### 2) Go to a command line and cd to the directory you unzipped the files to and run `java -jar ./lib/fitnesse.jar` ###

### 3) Run the example [SliM](http://fitnesse.org/FitNesse.UserGuide.SliM) test at http://localhost/SlimExamples and the [SliM](http://fitnesse.org/FitNesse.UserGuide.SliM) tests for GWZ http://localhost/GivWenZenTests ###

### 4) Create your own example [FitNesse](http://fitnesse.org/FrontPage) page modeled after the example test ###

##### import and start should go in [SetUp](http://fitnesse.org/FitNesse.UserGuide.SpecialPages) or [SuiteSetUp](http://fitnesse.org/FitNesse.UserGuide.SpecialPages) #####
```
|import|
|org.givwenzen|

|script|
|start|giv wen zen for slim|
```
##### this is your test #####
```
|script|
| given| a ToDo item is due tomorrow |
| when | the date changes to tomorrow  |
| then | a notification exists indicating the ToDo is due |
```
### 5) Create the [step class](StepClass.md) and [methods](StepMethod.md) like the class below ###
```
package bdd.steps;

@DomainSteps
public class ExampleSteps {

  @DomainStep( “a ToDo item is due (.*)” )
  public void createToDoWithDueDateOf(String date) {
    // do something
  }

  @DomainStep( “the date changes to (.*)” )
  public void theDateIs(String date) {
    // do something
  }

  @DomainStep( “a notification exists indicating the ToDo is due” )
  public boolean verifyNotificationExistsForDueToDo() {
    // do something
    return false;
  }

}
```

### 6) Run the test ###


---


### Dependencies: ###
#### required for main classes: ####
  * **java 6**
  * commons-logging.jar
  * javassist.jar
  * log4j-1.2.9.jar
  * google-collect-1.0-rc2.jar
  * reflections-0.9.4.jar
  * commons-vfs-1.0.jar
  * dom4j-1.6.1.jar
  * slf4j-api-1.5.6.jar
  * slf4j-simple-1.5.6.jar

#### additional requirements for test classes ####
  * hamcrest-core-1.1.jar" />
  * junit-4.5.jar" />
  * mockito-core-1.7.jar" />
  * objenesis-1.0.jar" />