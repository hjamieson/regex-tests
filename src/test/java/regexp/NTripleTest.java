package regexp;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Description:
 * User: jamiesoh
 * Date: 6/19/14
 * Time: 10:48 AM
 * &copy;2013 OCLC Data Architecture Group
 */
public class NTripleTest {
    @Test
    public void testExtractSubjectFromTriple(){
        String t1 = "<http://worldcat.org/entity/work/id/100050217> <http://schema.org/datePublished> \"1999\" .";
        String t2 = "<http://worldcat.org/entity/work/id/100050217> <http://schema.org/pagination> \"10-16\" .";
        String t3 = "<http://worldcat.org/entity/work/id/100050217> <http://schema.org/workExample> <http://www.worldcat.org/oclc/5145556792> .";
        String t4 = "<http://worldcat.org/entity/work/id/100050217> <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> <http://schema.org/Article> .";
        String bad = "\"larry\" <http://schema.org/isPartOf> <http://worldcat.org/issn/1064-7449#7_1_2> .";

        Pattern subjrgx = Pattern.compile("^\\s*<([^>]+)>.*");
        Matcher m1 = subjrgx.matcher(t1);
        assertThat("expression matches", m1.matches(), is(true));
        assertThat("value is", m1.group(1), equalTo("http://worldcat.org/entity/work/id/100050217"));
        m1 = subjrgx.matcher(t2);
        assertThat("expression matches", m1.matches(), is(true));
        assertThat("value is", m1.group(1), equalTo("http://worldcat.org/entity/work/id/100050217"));
        m1 = subjrgx.matcher(t3);
        assertThat("expression matches", m1.matches(), is(true));
        assertThat("value is", m1.group(1), equalTo("http://worldcat.org/entity/work/id/100050217"));

        m1 = subjrgx.matcher(bad);
        assertThat("should not match", m1.matches(), is(false));
    }
}
