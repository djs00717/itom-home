import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by djs on 2017/10/26.
 */
public class Log4j2Test {

    private static Logger logger = LogManager.getLogger(Log4j2Test.class.getName() );

    public static void main(String[] args) {

        logger.info("info ...."+ getNumbers("T200P56529590151645401"));
        logger.info("info ...."+ "CAE_CHARITY_59328398270014580123123".substring(12,"CAE_CHARITY_59328398270014580".length()));
        logger.warn("warn .... warn"+getNumbers("代扣款（扣款用途：聚划算佣金(31943200125660322)34564564564564，付款方：浙江天猫技术有限公司，Email：ju.tuangou@service.taobao.com）"));
    }

    //截取数字
    public static String getNumbers(String content) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            if (matcher.group(0).length() > 10) {
                return matcher.group(0);
            }
        }
        return "";
    }

}
