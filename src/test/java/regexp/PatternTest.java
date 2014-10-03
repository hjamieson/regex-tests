package regexp;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Description:
 * User: jamiesoh
 * Date: 6/17/14
 * Time: 2:02 PM
 * &copy;2013 OCLC Data Architecture Group
 */
public class PatternTest {
    @Test
    public void testExtractPattern(){
        String sample = "<schema:pageStart>81</schema:pageStart><schema:creator rdf:resource=\"http://experiment.worldcat.org/entity/work/data/100000144#Person/khng_russell_heng_hiang\"/><schema:isPartOf rdf:resource=\"http://worldcat.org/issn/0091-8369#40_3_4\"/><schema:pagination>81-96</schema:pagination><schema:isPartOf rdf:resource=\"http://worldcat.org/issn/0091-8370#40_3_4\"/>";
        Pattern pat = Pattern.compile("<schema:isPartOf rdf:resource=\"http://worldcat.org/issn/([0-9]{4}-[0-9]{3}[0-9X])#[^/]*/>");
        Matcher m = pat.matcher(sample);
        if (m.find(0)){
            assertThat(m.group(1),equalTo("0091-8369"));
        } else {
            fail("did not match rgx");
        }

        int cnt = 0;
        m = pat.matcher(sample);
        while (m.find()){
            System.out.println(m.group(1));
            cnt++;
        }
        assertThat(cnt, equalTo(2));
    }
}
