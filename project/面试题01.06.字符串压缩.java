class Solution {
    public String compressString(String S) {
        if(S.length() <= 2){//如果传入的字符串长度小于等于2,转换过后也不符合题意，直接返回即可
            return S;
        }
        StringBuilder stringBuilder = new StringBuilder();//定义一个StringBuilder用来拼接字符串，效率比String高
        char[] chars = S.toCharArray();//把字符串转换成字符数组
        int count = 1;//定义一个变量用来记录相邻相同的字符数量，起始值为1
        int i = 0;//字符数组的下标，定义在外面，最后拼接的时候使用
        for (i = 0; i < chars.length - 1; i++) {
            if(chars[i] == chars[i+1]){//判断i索引上的字符与i+1索引上的字符是否相同
                count++;//相同则count++
            }else { //如果不相同则拼接结果
                stringBuilder.append(chars[i]);//先拼接字符
                stringBuilder.append(count);//在拼接数量
                count = 1;//把变量count重置为1，重新开始记录下一个字符的数量
            }
        }
        stringBuilder.append(chars[i]);//用来拼接字符串最后一个字符
        stringBuilder.append(count);//最后一个字符的数量
        return S.length() <= stringBuilder.length() ? S : stringBuilder.toString();//返回并判断压缩后的字符串是否比原来的字符串短,如果小于则返回压缩后的字符串;
    }
}
