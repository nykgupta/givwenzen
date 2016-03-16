## Introduction ##

`GivWenZen` now supports two build frameworks. Ant and Maven 2. This guide is for those more inclined to use the latter.


## Required Steps ##

  1. Add `GivWenZen` repo to your Maven 2 settings file. In ~/.m2/settings.xml add the following entry:
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
  1. In order to deploy to the `GivWenZen Maven repo`, you must have the proper credentials. In your settings.xml file, add the following, where username is your svn googlecode username and password is your googlecode svn password:
```
<settings>
..
..
<servers>
  <server>
    <id>givwenzen-repo</id>
    <username>username</username>
    <password>password</password>
  </server>
</servers>
..
..
</settings>
```
  1. For IntelliJ Idea users, you can simply import `GivWenZen` as a Maven project. Just select "Open Project" then point to the pom.xml file.
  1. For Eclipse users, you can either use the [m2eclipse](http://m2eclipse.sonatype.org/) eclipse plugin or the [q4e](http://code.google.com/p/q4e/) eclipse plugin. Then just import as Maven project to Eclipse.
  1. You can also use Maven to generate your IDE descriptor files instead of directly importing them. e.g.: mvn idea:idea, mvn eclipse:eclipse.
  1. In order to deploy to the Maven repo, just invoke `mvn deploy`, given that you have accomplished steps 1 and 2.