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

package odds;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static org.junit.Assert.fail;

/**
 * Description:
 * User: jamiesoh
 * Date: 11/4/14
 * Time: 8:49 AM
 * &copy;2013 OCLC Data Architecture Group
 */
public class OddballTest {
    @Test
    public void testDeUnicode() {
        String sample = "Fölsing, Albrecht";
        try {
            String sample1 = new String("http://dbpedia.org/resource/Albrecht_F\u00F6lsing".getBytes(), "UTF-8");
            System.out.println("sample1=>"+sample1);
            InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(sample1.getBytes()));
            char[] myBuffer = new char[2048];
            isr.read(myBuffer);
            String sample2 = new String(myBuffer);
            System.out.println("sample2=>"+sample2);

            OutputStreamWriter writer = new OutputStreamWriter(System.out, "UTF-8");
            System.out.print("sample3=>");
            writer.write(sample);
            writer.flush();
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }
}
