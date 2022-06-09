import java.util.HashMap;
import java.util.Scanner;

/**
 * @author ozawa
 * @version 1.0
 * @date 2022
 * @description PACKAGE_NAME
 * @since JDK1.8
 * https://www.nowcoder.com/practice/05182d328eb848dda7fdd5e029a56da9?tpId=37&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，
 * 则把出现次数最少的字符都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 数据范围：输入的字符串长度满足 1 ≤ n ≤ 20  ，保证输入的字符串中仅出现小写字母
 */
public class HJ23 {
    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        // 循环获取
        while (in.hasNext()) {
            // 当前字符串
            String str = in.next();
            // 次数记录
            HashMap<Character, Integer> map = new HashMap<>(str.length());
            // 遍历记录数字
            for (char ch : str.toCharArray()) {
                // 记录
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            // 最少次数
            int min = Integer.MAX_VALUE;
            for (int times : map.values()) {
                min = Math.min(min, times);
            }
            // 结果字符串
            StringBuilder builder = new StringBuilder();
            for (char ch : str.toCharArray()) {
                if (map.get(ch) != min) {
                    builder.append(ch);
                }
            }
            System.out.println(builder);
        }
    }
}
