import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generateParenthesis(3));
    }
}



class Solution {
    /**
     *
     * @param list 结果
     * @param str 当前子串
     * @param left 左括号剩余数
     * @param right 右括号剩余数
     */
    private void generateParenthesisFunc(List list, String str, int left, int right) {
        //1.先放置左括号，后放置右括号，所以右括号数不能多于左括号数（指的是使用的括号数，不是剩余的），否则生成的括号无法配对
        if (left > right) return;

        //3.如果剩余左右括号数均为0，保存结果
        if (left == right && right == 0) {
            list.add(str);
            return;
        }

        //4.继续放置左括号，继续放置有括号
        if (left > 0) generateParenthesisFunc(list, str + "(", left - 1, right);
        if (right > 0) generateParenthesisFunc(list, str + ")", left, right - 1);
    }

    /**
     *
     * @param n 括号对数
     * @return ans
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        //特殊情况
        if (n == 0) return ans;
        //构造括号对
        generateParenthesisFunc(ans,"", n, n);
        return ans;
    }
}

