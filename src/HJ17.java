import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static jdk.nashorn.internal.runtime.JSType.isNumber;

/**
 * @author ozawa
 * @version 1.0
 * @date 2022
 * @description PACKAGE_NAME
 * @since JDK1.8
 * https://www.nowcoder.com/practice/119bcca3befb405fbe58abe9c532eb29?tpId=37&tqId=21240&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
 * 从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 * 输入：
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 * 坐标之间以;分隔。
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 * 下面是一个简单的例子 如：
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 处理过程：
 * 起点（0,0）
 * +   A10   =  （-10,0）
 * +   S20   =  (-10,-20)
 * +   W10  =  (-10,-10)
 * +   D30  =  (20,-10)
 * +   x    =  无效
 * +   A1A   =  无效
 * +   B10A11   =  无效
 * +  一个空 不影响
 * +   A10  =  (10,-10)
 * 结果 （10， -10）
 * 数据范围：每组输入的字符串长度满足 1\le n \le 10000 \1≤n≤10000  ，
 * 坐标保证满足− 2^31 ≤x,y≤ 2^31 −1  ，且数字部分仅含正数
 */
public class HJ17 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            String s = scanner.nextLine();
            int x = 0 , y = 0;
            String[] sArray = s.split(";");
            String res = "[ADWS]\\d{1}\\d?";
            Map<Character, Integer> map = new HashMap<>(sArray.length + 1);
            for (String value : sArray) {
                if (value.matches(res)) {
                    map.put(value.charAt(0),
                            map.getOrDefault(value.charAt(0), 0) +
                                    Integer.parseInt(value.substring(1)));
                }
            }
            x = x - map.get('A') + map.get('D');
            y = y - map.get('S') + map.get('W');
            System.out.println(x+","+y);
            map.clear();
        }

        scanner.close();
    }
}
