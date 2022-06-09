package Test;

import Algo.KMP;
import Utils.OutUtils;

public class TestKMP {
    public static void main(String[] args) {
        KMP kmp = new KMP();
        String text = "stonemanmunanfan";
        String str = "nfan";
        int strIndex = kmp.findStr(text, str);
        System.out.println(str + "在字符串" + text + "的位置是：" + strIndex);
    }
}
