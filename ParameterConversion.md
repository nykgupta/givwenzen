### How are parameter converted to types ###

You can use custom types in your [step method](StepMethod.md) parameters.

Like [SliM](http://fitnesse.org/FitNesse.UserGuide.SliM) the step executor will use a [PropertyEditor](http://java.sun.com/j2se/1.5.0/docs/api/java/beans/PropertyEditor.html).

By default [property editors](http://java.sun.com/j2se/1.5.0/docs/api/java/beans/PropertyEditor.html) can be in the same package as the object type or in the `bdd.parse` package.

#### See: ####

BadStepParameter

http://fitnesse.org/FitNesse.UserGuide.SliM.CustomTypes

http://java.sun.com/javase/6/docs/api/java/beans/PropertyEditorSupport.html

http://javadude.com/articles/propedit/index.html