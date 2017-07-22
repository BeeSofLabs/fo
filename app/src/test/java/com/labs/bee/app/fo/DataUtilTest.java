package com.labs.bee.app.fo;

import org.junit.Test;

import core.tools.util.DataUtil;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by arysuryawan on 7/21/17.
 */

public class DataUtilTest {

    @Test
    public void testBooleanType() {
        boolean boolValue = DataUtil.booleanValue(1);
        assertThat(true, equalTo(boolValue));
    }
}
