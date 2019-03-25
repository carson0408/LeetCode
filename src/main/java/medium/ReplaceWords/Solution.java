package medium.ReplaceWords;

import java.util.ArrayList;
import java.util.List;

/**
 * In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.
 *
 * Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.
 *
 * You need to output the sentence after the replacement.
 *
 * Example 1:
 *
 * Input: dict = ["cat", "bat", "rat"]
 * sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 *
 *
 *
 * Note:
 *
 *     The input will only have lower-case letters.
 *     1 <= dict words number <= 1000
 *     1 <= sentence words number <= 1000
 *     1 <= root length <= 100
 *     1 <= sentence words length <= 1000
 */
public class Solution {
    /**
     *
     * @param dict
     * @param sentence
     * @return
     * 解题思路：先将sentence以空格分割成字符串数组，依次遍历数组，对于每个单词，都对dict中的单词进行判断
     * 判断方法就是判断dict中的词是否在word的首部，可以使用indexOf()是否等于0来进行判断。
     */
    public String replaceWords(List<String> dict, String sentence) {
        int dictLen = dict.size();
        String[] words = sentence.split(" ");
        int wordsLen = words.length;
        List<String> list = new ArrayList<String>();
        for(int i = 0;i<wordsLen;i++){
            boolean flag = true;
            String temp = null;
            for(int j = 0;j<dictLen;j++){
                if(words[i].indexOf(dict.get(j))==0){
                    flag = false;
                    temp = dict.get(j);
                    break;
                }
            }
            if(flag){
                list.add(words[i]);
            }
            else{
                list.add(temp);
            }
        }
        int listLen = list.size();
        String ans = "";
        for(int i = 0;i<listLen-1;i++){
            ans+=list.get(i)+" ";
        }
        ans+=list.get(listLen-1);
        return ans;
    }
    public static void main(String[] args){
        String sentence = "the cattle was rattled by the battery";
        List<String> dict = new ArrayList<String>();
        String[] d = {"cat","bat","rat"};
        for(int i=0;i<d.length;i++){
            dict.add(d[i]);
        }
        System.out.println(new Solution().replaceWords(dict,sentence));
    }
}
