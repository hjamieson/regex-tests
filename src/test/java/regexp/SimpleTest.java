package regexp;

import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Description:
 * User: jamiesoh
 * Date: 4/21/14
 * Time: 2:37 PM
 * &copy;2013 OCLC Data Architecture Group
 */
public class SimpleTest {
    @Test
    public void testFindWordsOr(){
        List<String> actuals = Arrays.asList(new String[]{"alpha","beta","gamma","delta","epsilon","theta","eta","zeta","iota","kappa","lambda"});
        List<String> found = new ArrayList<String>();
        Pattern p = Pattern.compile("ep.*|gamma");
        for (String a: actuals){
            Matcher m = p.matcher(a);
            if (m.matches()){
                found.add(a);
            }
        }
        System.out.println(found);
        String[] results = {"gamma", "epsilon"};
        Assert.assertThat(found, hasItems(results));
    }

    @Test
    public void testStripHash() {
        String u1 = "http://worldcat.org/test/12345#simple";
        String u2 = "http://worldcat.org/test/12345";
        String u3 = "http://worldcat.org/test/5678#simple/one#order";
        String u4 = "http://worldcat.org/issn/1064-7449#7";
        assertEquals(u1.replaceAll("#.*",""), "http://worldcat.org/test/12345");
        assertEquals(u2.replaceAll("#.*",""), "http://worldcat.org/test/12345");
        assertEquals(u3.replaceAll("#.*",""), "http://worldcat.org/test/5678");
        assertTrue(u4.contains("#"));
        assertEquals(u4.replaceAll("#.*",""), "http://worldcat.org/issn/1064-7449");
    }

    @Test
    public void testChangeMiddle() {
        String sample = "this string has \"embedded\" quotes and \\backslashes\\ that need \\\\ replaced";
        System.out.println(sample);
        String result = sample.replaceAll("([^\\\\])(\\\\)([^\\\\])", "$1\\\\\\\\$3");
        System.out.println(result);
        System.out.println(StringEscapeUtils.escapeXml(sample));

    }
    @Test
    public void testObvious(){
        String sample = "this is a test of the emergency broadcast system";
        assertTrue(sample.matches(".*test of the.*"));
    }

}
