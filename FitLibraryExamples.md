# Now you can use [FitLibrary](http://fitlibrary.wiki.sourceforge.net/) with `GivWenZen` #

My previous examples of using `GivWenZen` to write BDD style tests with `FitNesse` were done with the SLiM test system.  This was mostly due to an issue getting `FitLibrary` to run with the latest version of `FitNesse`.  However, Rick Mugridge has released a new version that fixes this issue as well as a few other nice enhancements.  Fixing of autowrapping of booleans, Strings, and other native java types was also big benefit to helping the BDD test read better.

Using `GivWenZen` with `FitLibrary` is very easy.  Create your own fixture that extends `DoFixture`, or any of the related type fixtures, and set the system under test to your instance of the `GivWenZenExecutor`.  The following is a simple example with a `DoFixture` extension.

```
import fitlibrary.DoFixture;

public class GivWenZenDoFixture extends DoFixture {

    public GivWenZenDoFixture() {
        super(new GivWenZenExecutor());
    }
}
```
This will allow you to have a FitLibrary specification/test like the following:
```
!|GivWenZenDoFixture|

|given|i turn on the calculator| 
|and|i have entered 50 into the calculator| 
|and|i have entered 75 into the calculator| 
|when|i press add| |then|the total is 125| 
```
A new `FitLibrary` feature that I really like is plain text specification / test.  I was amazed at how easy it was to do.  To use plain text we can use the same Fixture we used above.  And we simply change the test to look like the following:
```
!|GivWenZenDoFixture|

- given i turn on the calculator
- and i have entered 50 into the calculator
- and i have entered 75 into the calculator 
- when i press add 
- then the total is 125 
```
For the test you simple write the sentence and prefix it with a '- '.  It would be nice if the '- ' was not required. I would prefer an assumption that a line is a specification step and require a special character to indicate a comment.  However, I do like the feature and it is a step in the right direction toward plain text.

Since I really would like the to write the test in plain text without and indicator that it is plain text, the '- ' in this case, I have done an override of the `fitlibrary.utility.ParseUtility` class.  Unfortunately it is not extensible because it is mostly static methods. :(  My override of this class simply changes the place that looks for '- " to look for one of the GivWenZen/BDD keywords, given, when, then or and.  Here is the part I changed/added.
```

    public static String tabulize(String originalHtml) {
        String html = originalHtml;
        while (true) {
            int start = isGivWenZenLine(html);
            if (start < 0)
                break;
            int end = html.indexOf("<br/>", start + 5);
            if (end < 0)
                end = html.length();
            String table = "\n<table><tr><td><i>run plain</i></td><td>" + html.substring(start + 5, end)
                            + "</td></tr>\n</table>\n";
            html = html.substring(0, start + 5) + table + html.substring(end);
        }
        return html;
    }

    private static int isGivWenZenLine(String html) {
        String[] givWenZenKeywords = { "given", "when", "then", "and" };
        for (int i = 0; i < givWenZenKeywords.length; i++) {
            int start = html.indexOf("<br/>" + givWenZenKeywords[i]);
            if (start >= 0)
                return start;
        }
        return -1;
    }
```
I added  the static int isGivWenZenLine(String html) method and replaced a line that was simply looking for '<br />- ' with a call to this method. See [ParseUtility](http://code.google.com/p/givwenzen/source/browse/trunk/src/main/java/fitlibrary/utility/ParseUtility.java?spec=svn132&r=132) is the example source.