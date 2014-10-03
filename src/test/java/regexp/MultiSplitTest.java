package regexp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Description:
 * User: jamiesoh
 * Date: 6/19/14
 * Time: 2:14 PM
 * &copy;2013 OCLC Data Architecture Group
 */
public class MultiSplitTest {
    @Test
    public void testSplitMulti(){
        String t1 = "1234-5678,this is text";
        String t2 = "1234-5678\tthis is text";
        String t3 = "1234-5678   this is text";
        assertThat(t1.split(",",2).length, equalTo(2));
        assertThat(t1.split(",|\\t",2).length, equalTo(2));
        assertThat(t2.split(",|\\t",2).length, equalTo(2));
        assertThat(t2.split(",|\\t|\\s",2).length, equalTo(2));


    }
}
