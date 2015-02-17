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

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Description:
 * User: jamiesoh
 * Date: 11/11/14
 * Time: 10:05 AM
 * &copy;2013 OCLC Data Architecture Group
 */
public class GetSubjectTest {
    @Test
    public void testGetSubject(){
        String sample = "<http://experiment.worldcat.org/entity/work/data/246638439#Person/na_ss_a\u0085shild> <http://schema.org/name> \"NÃ¦ss, Ã\u0085shild.\" .\n";
//        String sample = "<http://experiment.worldcat.org/entity/work/data/246638439#Person/na_ss_a_shild> <http://schema.org/name> \"NÃ¦ss,\u0085Ã_shild.\" .";
//        String sample = "<http://worldcat.org/entity/work/id/191236358> <http://schema.org/name> \"\u009Aℓ\u0080\u0083̐ư? þ\u0085æøưæ\u0080\u0083̐ư?̐ư?ðı\u0080 ̐ư?ı̐ư?ðℓø \u009Fʻ\u0080æưæ̐ư?ı̐ư?ʻ \u0095\u0084\u0080æơʻ℗Łı\u0080ıưʻ. II: ̐ư?\u0091, \u009Fℓđℓþ. 71ʻ\" .";
        Pattern pat = Pattern.compile("^\\s*<([^>]+)>.*", Pattern.DOTALL);
        Matcher m = pat.matcher(sample);
        assertThat(m.matches(), is(true));

        assertThat(m.group(1), notNullValue());

    }
}
