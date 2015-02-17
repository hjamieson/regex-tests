/****************************************************************************************************************
 *
 *  Copyright (c) 2014 OCLC, Inc. All Rights Reserved.
 *
 *  OCLC proprietary information: the enclosed materials contain
 *  proprietary information of OCLC, Inc. and shall not be disclosed in whole or in 
 *  any part to any third party or used by any person for any purpose, without written
 *  consent of OCLC, Inc.  Duplication of any portion of these materials shall include this notice.
 *
 ******************************************************************************************************************/

package regexp;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Description:
 * User: jamiesoh
 * Date: 12/4/14
 * Time: 9:10 AM
 * &copy;2013 OCLC Data Architecture Group
 */
public class ViafFilterTest {
    @Test
    public void testMatchViaf(){
        Pattern p = Pattern.compile("^VIAF:[0-9]+$");
        assertThat(p.matcher("VIAF:12345").matches(), is(true));
        assertThat(p.matcher("FAST:12345").matches(), is(false));

    }

    @Test
    public void testReverseKey(){
        String key = "VIAF:100119650";
        System.out.println(StringUtils.reverse(key));
    }

    @Test
    public void testFindViaf(){
        String noise = "this is some random text VIAF:12345678that is in my data";
        Pattern p = Pattern.compile("(VIAF:[0-9]+)");
        Matcher m = p.matcher(noise);
        assertThat(m.find(), is(true));
        assertThat(m.group(1), equalTo("VIAF:12345678"));
    }
}
