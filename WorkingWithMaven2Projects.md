## Introduction ##

`FitNesse` is not really designed to work with Maven 2 projects out of the box. But there are ways to make it work.

For the specific way detailed below, we will be able to make `FitNesse` and `GivWenZen` work with an existing Maven 2 project with the help of Lars Vonk's [Maven Classpath Plugin](http://github.com/lvonk/fitnesse-maven-classpath).


## Requirements ##

You will need:
  * Latest [FitNesse jar](http://fitnesse.org/FrontPage.FitNesseDevelopment.DownLoad)
  * Latest [Maven Classpath Plugin jar](http://github.com/lvonk/fitnesse-maven-classpath/downloads)


## Steps ##

  1. Create a directory. For this example we will name it "fitnesse." Recommended is to make it at least a peer to your current maven project. Point being, it is easier to navigate to the pom file from `FitNesse`. e.g.
```
+ fitnesse
- mavenProject
  - pom.xml
  - src
    + main
    + test
```
  1. Place fitnesse jar inside the fitnesse directory. Create a "plugins" directory inside the fitesse directory and place the maven classpath plugin jar there. Create a plugins.properties file inside the fitnesse directory, and write "`WikiWidgets = fitnesse.wikitext.widgets.MavenClasspathWidget`" in one line without the quotes. You should now have something like this:
```
- fitnesse
  - fitnesse.jar
  - plugins.properties
  - plugins
    - maven-classpath-plugin-XX-jar-with-dependencies.har
```
  1. Add the `GivWenZen` maven repo to your settings.xml file. In .m2/settings.xml, add the following entry:
```
<settings>
..
..
  <profiles>
    <profile>
      <id>givwenzen-profile</id>
      <activation>
        <activeByDefault>true</activeByDefault>
      </activation>

      <repositories>
        <repository>
      	  <id>givwenzen-repo</id>
      	  <name>GivWenZen Repository</name>
      	  <url>http://givwenzen.googlecode.com/svn/maven2</url>
      	  <releases>
            <enabled>true</enabled>
          </releases>
     	  <snapshots>
            <enabled>true</enabled>
      	  </snapshots>
        </repository>
    </profile>
  </profiles>  
..
..
</settings>
```
  1. Add `GivWenZen` as a dependency to your project scoped for tests. Your pom.xml should have this entry:
```
  <dependency>
    <groupId>com.googlecode.givwenzen</groupId>
    <artifactId>givwenzen</artifactId>
    <version>1.0</version>
    <scope>test</scope>
  </dependency>
```
  1. With `GivWenZen` in your classpath, you can now create step classes from within your test directory:
```
- mavenProject
  - src
    - test
      - java
        - bdd.steps
          - StepClass.java
```
  1. Compile your project by invoking at least to "test" lifecycle of Maven (mvn test). Run `FitNesse` by invoking "java -jar fitnesse.jar" from the commandline at the fitnesse directory level.
  1. On your suite or test page in `FitNesse`, reference your project's pom.xml by adding this: "!pomFile /path/to/pom.xml." From our example, you can create a `SetUp` page with the following:
```
!contents -R2 -g -p -f -h

!**> setup test system

!define TEST_SYSTEM {slim}

!pomFile ../mavenProject/pom.xml

*!
```

