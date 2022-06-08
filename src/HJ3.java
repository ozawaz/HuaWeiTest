import java.util.BitSet;
import java.util.Scanner;

/**
 * @author ozawa
 * @version 1.0
 * @date 2022
 * @description PACKAGE_NAME
 * @since JDK1.8
 * https://www.nowcoder.com/practice/3245215fffb84b7b81285493eae92ff0?tpId=37&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 * 明明生成了NN个1到500之间的随机整数。
 * 请你删去其中重复的数字，即相同的数字只保留一个，
 * 把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
 * 数据范围： 1≤n≤1000  ，输入的数字大小满足 1≤val≤500
 */
public class HJ3 {
    public static void main(String[] args) {
        // 位图，存放数字
        BitSet bitSet = new BitSet(501);
        // 输入
        Scanner in = new Scanner(System.in);
        // 去除第一位
        int val = in.nextInt();
        // 循环添加位图
        while (in.hasNext()) {
            // 获取输入的数字
            val = in.nextInt();
            // 存放位图
            bitSet.set(val);
        }
        // 根据位图每位是否为1来输出
        for (int i = 1; i <= 500 ; i++) {
            if (bitSet.get(i)) {
                System.out.println(i);
            }
        }
    }
}
