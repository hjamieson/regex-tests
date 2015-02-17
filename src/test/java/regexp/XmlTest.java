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

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Description:
 * User: jamiesoh
 * Date: 2/17/15
 * Time: 12:57 PM
 * &copy;2013 OCLC Data Architecture Group
 */
public class XmlTest {
    @Test
    public void testGetTypeAttribute() throws IOException {
        String xml = IOUtils.toString(this.getClass().getResourceAsStream("/xmltest.xml"));
        Pattern p = Pattern.compile("<Identity type=\"(\\w+).*");
        Matcher m = p.matcher(xml);
        assertThat(m.matches(), is(true));
        assertThat(m.group(1), equalTo("personal"));

    }
}
