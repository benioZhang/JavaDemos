package algorithm;

import org.junit.Assert;
import org.junit.Test;

public class CharStatisticsTest {

    @Test
    public void test() throws Exception{
        String str;
        char c;
        str = "abbcad";
        c = CharStatistics.findFirstNotRepeatingChar(str);
        Assert.assertEquals('c', c);

        str = "";
        c = CharStatistics.findFirstNotRepeatingChar(str);
        Assert.assertEquals('\0', c);

        str = "goog";
        c = CharStatistics.findFirstNotRepeatingChar(str);
        Assert.assertEquals('\0', c);

        str = "g";
        c = CharStatistics.findFirstNotRepeatingChar(str);
        Assert.assertEquals('g', c);

        str = "googl";
        c = CharStatistics.findFirstNotRepeatingChar(str);
        Assert.assertEquals('l', c);
    }
}