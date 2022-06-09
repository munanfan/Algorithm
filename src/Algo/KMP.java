package Algo;

/**
 * KMP算法
 * 难点在在于next数组的求解，而next数组的表示方法有两种，一种是next[0]=0, 另外一种是next[0]=-1。
 * 两种数组的表示含义也不相同；
 * 其中，next[0]=0 起始的数组，数组中元素 next[i] 表示的是字符串 [0,i] 的最长公共前后缀的长度；
 * 而 next[0]=-1 起始的数组，数组中元素 next[i] 表示的是字符串 [0,i] 的最长公共前后缀中前缀的下标
 */
public class KMP {
    /**
     * 计算next数组
     * @param str 子串
     * @return next数组
     */
    public int[] getNext(String str){
        int[] next = new int[str.length()];
        // 初始化 next[0]
        next[0] = 0;
        int i = 1;      // i可以看成代表的是后缀的最后一个字母，[0,i]相当于求公共前后缀的那个字符串；
        int j = 0;      // j可以看成代表的是前缀的最后一个字母；
        while(i < str.length()){    // calculate all next elements of str
            if(j == 0 && str.charAt(i) != str.charAt(j)){   // 和第一个字符也不相等，说明需要公共前后缀长度为0；
                next[i++] = j;
                continue;
            }
            if(str.charAt(i) != str.charAt(j)){     // 出现字符不相等情况，缩小前后缀范围；
                j = next[j-1];
            }else{
                next[i++] = ++j;        // 如果相等，设置当前最长公共前后缀长度为j+1（因为是长度，所以下标需要+1）；
            }
        }
        return next;
    }

    public int findStr(String text, String str){
        int[] next = getNext(str);
        int i = 0;
        int j = 0;
        while(i < text.length()){   // 对字符串进行比较
            if(j == 0 && text.charAt(i) != str.charAt(j)){
                // 当 j==0，还不相等，从下一个字符开始比较
                i++;
                continue;
            }
            if(text.charAt(i) == str.charAt(j)){
                // 两个字符相等，向后移动一位继续比较
                i++;j++;
                if(j == str.length()){      // 如果子串已经比较完了，说明已经找到了子串
                    return i - str.length();
                }
            }else{
                // 两个字符不相等，查看是否有其他的公共前后缀
                j = next[j];
            }
        }
        return -1;
    }
}