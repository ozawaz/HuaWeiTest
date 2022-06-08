import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author ozawa
 * @version 1.0
 * @date 2022
 * @description PACKAGE_NAME
 * @since JDK1.8
 * https://www.nowcoder.com/practice/184edec193864f0985ad2684fbc86841?tpId=37&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 * 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
 * 数据范围：输入的字符串长度满足1 ≤ n ≤ 100
 */
public class HJ20 {

    private static final Pattern PATTERN_NUMERICAL = Pattern.compile("[0-9]");
    private static final Pattern PATTERN_UPPERCASE = Pattern.compile("[A-Z]");
    private static final Pattern PATTERN_LOWERCASE = Pattern.compile("[a-z]");
    private static final Pattern PATTERN_SPECIAL = Pattern.compile("[^a-zA-Z0-9]");

    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        // 循环获取
        while (in.hasNext()) {
            // 当前字符串
            String str = in.next();
            // 开始判断
            // 长度
            if (str.length() <= 8) {
                System.out.println("NG");
                continue;
            }
            // 字符种类
            if (isThreeKinds(str)) {
                System.out.println("NG");
                continue;
            }
            // 不能有长度大于2的包含公共元素的子串重复
            if (isRepeated(str)) {
                System.out.println("NG");
                continue;
            }

            System.out.println("OK");
        }
    }

    private static boolean isRepeated(String str) {
        Set<String> set = new HashSet<>();
        int index = 0;
        while (index < str.length() - 3) {
            if (!set.add(str.substring(index, index + 3))) {
                return true;
            }
            index++;
        }
        return false;
    }

    private static boolean isThreeKinds(String str) {
        // 种类
        int count = 0;

        // 是否有数字
        if (PATTERN_NUMERICAL.matcher(str).find()) {
            count++;
        }
        // 是否有大写字母
        if (PATTERN_UPPERCASE.matcher(str).find()) {
            count++;
        }
        // 是否有小写字母
        if (PATTERN_LOWERCASE.matcher(str).find()) {
            count++;
        }
        // 是否有特殊字符
        if (PATTERN_SPECIAL.matcher(str).find()) {
            count++;
        }

        return count < 3;
    }


}
