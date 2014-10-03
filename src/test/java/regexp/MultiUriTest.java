package regexp;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Description:
 * User: jamiesoh
 * Date: 6/20/14
 * Time: 11:54 AM
 * &copy;2013 OCLC Data Architecture Group
 */
public class MultiUriTest {
    @Test
    public void testFindMulti() throws IOException {
        Pattern pat = Pattern.compile("<schema:isPartOf rdf:resource=\"http://worldcat.org/issn/([0-9]{4}-[0-9]{3}[0-9X])(\"/>|#[^/]*\"/>)");
        String sampleXml = IOUtils.toString(this.getClass().getResourceAsStream("/multiuritest.txt"));
        Matcher m1 = pat.matcher(sampleXml);
        int cnt = 0;

        /*        0091-8369 1234-5678#40_3 2345-6789#40_3_4 */
        String[] expected = {"0091-8369", "1234-5678", "2345-6789"};
        HashSet<String> found = new HashSet<String>();
        while (m1.find()) {
            found.add(m1.group(1));
            cnt++;
        }
        System.out.println("found=>" + found);
        assertThat(cnt, is(3));
        for (String f : expected) {
            assertThat(found.contains(f), is(true));
        }
    }

    @Test
    public void testReplacement() throws IOException {
        String sampleXml = IOUtils.toString(this.getClass().getResourceAsStream("/multiuritest.txt"));
        String expected = IOUtils.toString(this.getClass().getResourceAsStream("/multiuritest-expected.txt"));
        String result = replaceIssn("0091-8369", "http://magic.issn/0091-8369", sampleXml);
        result = replaceIssn("1234-5678", "http://magic.issn/1234-5678", result);
        result = replaceIssn("2345-6789", "http://magic.issn/2345-6789", result);
        assertThat(result, equalTo(expected));
    }

    private String replaceIssn(String issn, String uri, String rdfxml) {
        return rdfxml.replaceAll("http://worldcat.org/issn/"+issn, uri);
    }
}
