package regexp;

import org.junit.Test;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Description: User: jamiesoh Date: 10/20/14 Time: 10:21 AM &copy;2013 OCLC Data Architecture Group
 */
public class HeaderSplitTest {
    @Test
    public void testHeaderRegex(){
        Pattern p = Pattern.compile("\\s*([a-zA-Z0-9-/]+)=([a-zA-Z0-9-/]+)\\s*");
        String s1 = "foo=bar bar=baz, Accept=application-json alpha=true X-OCLC-ClientId=rdfLookup";
//        assertThat(p.matcher(s1).matches(), is(true));
        Matcher m = p.matcher(s1);
        HashMap<String, String> map = new HashMap<String, String>();
        while (m.find()){
            assertThat(m.groupCount(), is(2));
            map.put(m.group(1), m.group(2));
        }
        assertThat(map.size(), is(5));
        assertThat(map.get("foo"), equalTo("bar"));
        assertThat(map.get("alpha"), equalTo("true"));
        assertThat(map.get("Accept"), equalTo("application-json"));
        assertThat(map.get("X-OCLC-ClientId"), equalTo("rdfLookup"));
    }
}
