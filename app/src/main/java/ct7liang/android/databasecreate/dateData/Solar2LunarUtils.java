package ct7liang.android.databasecreate.dateData;

import java.util.Calendar;

/**
 * Created by Administrator on 2018-08-15.
 *  阳历时间转阴历工具 仅限1990年到2049年
 */
public class Solar2LunarUtils {

    private String[] gan = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
    private String[] zhi = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};
    private String[] animals = {"猴", "鸡", "狗", "猪", "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊"};
    /**
     * 农历1990年到2049年信息
     * 例:
     * 0x15176对应于2017年
     * 十六进制数: 0x15176 转换为二进制数得: 0001 0101 0001 0111 0110
     * 该二进制数从右向左为三部分:
     *   第一部分 前四位: 0110
     *     转十进制数为 2^3*0+2^2*1+2^1*1+2^0*0=6 表示阴历2017年有闰月,且为闰六月
     *   第二部分 中间十二位: 0101 0001 0111
     *     从左向右数依次为阴历1,2,3,...12月, 0表示该月为小月即29天,1表示该月为大月即30天
     *   第三部分 最后四位: 0001
     *     表示闰月是大月还是小月  0001为大月 0000为小月 即阴历2017年闰六月为大月
     *   综上可求出阴历2017年的天数
     */
    private long[] lunarInfo = {
            0x04bd8, 0x04ae0, 0x0a570, 0x054d5, 0x0d260, 0x0d950, 0x16554, 0x056a0, 0x09ad0, 0x055d2,
            0x04ae0, 0x0a5b6, 0x0a4d0, 0x0d250, 0x1d255, 0x0b540, 0x0d6a0, 0x0ada2, 0x095b0, 0x14977,
            0x04970, 0x0a4b0, 0x0b4b5, 0x06a50, 0x06d40, 0x1ab54, 0x02b60, 0x09570, 0x052f2, 0x04970,
            0x06566, 0x0d4a0, 0x0ea50, 0x06e95, 0x05ad0, 0x02b60, 0x186e3, 0x092e0, 0x1c8d7, 0x0c950,
            0x0d4a0, 0x1d8a6, 0x0b550, 0x056a0, 0x1a5b4, 0x025d0, 0x092d0, 0x0d2b2, 0x0a950, 0x0b557,
            0x06ca0, 0x0b550, 0x15355, 0x04da0, 0x0a5d0, 0x14573, 0x052d0, 0x0a9a8, 0x0e950, 0x06aa0,
            0x0aea6, 0x0ab50, 0x04b60, 0x0aae4, 0x0a570, 0x05260, 0x0f263, 0x0d950, 0x05b57, 0x056a0,
            0x096d0, 0x04dd5, 0x04ad0, 0x0a4d0, 0x0d4d4, 0x0d250, 0x0d558, 0x0b540, 0x0b5a0, 0x195a6,
            0x095b0, 0x049b0, 0x0a974, 0x0a4b0, 0x0b27a, 0x06a50, 0x06d40, 0x0af46, 0x0ab60, 0x09570,
            0x04af5, 0x04970, 0x064b0, 0x074a3, 0x0ea50, 0x06b58, 0x055c0, 0x0ab60, 0x096d5, 0x092e0,
            0x0c960, 0x0d954, 0x0d4a0, 0x0da50, 0x07552, 0x056a0, 0x0abb7, 0x025d0, 0x092d0, 0x0cab5,
            0x0a950, 0x0b4a0, 0x0baa4, 0x0ad50, 0x055d9, 0x04ba0, 0x0a5b0, 0x15176, 0x052b0, 0x0a930,//2019
            0x07954, 0x06aa0, 0x0ad50, 0x05b52, 0x04b60, 0x0a6e6, 0x0a4e0, 0x0d260, 0x0ea65, 0x0d530,
            0x05aa0, 0x076a3, 0x096d0, 0x04bd7, 0x04ad0, 0x0a4d0, 0x1d0b6, 0x0d250, 0x0d520, 0x0dd45,
            0x0b5a0, 0x056d0, 0x055b2, 0x049b0, 0x0a577, 0x0a4b0, 0x0aa50, 0x1b255, 0x06d20, 0x0ada0  };

    private String[] erjinzhi = {
            "100101111011000", "100101011100000", "1010010101110000", "101010011010101", "1101001001100000",
            "1101100101010000", "10110010101010100", "101011010100000", "1001101011010000", "101010111010010",
            "100101011100000", "1010010110110110", "1010010011010000", "1101001001010000", "11101001001010101",
            "1011010101000000", "1101011010100000", "1010110110100010", "1001010110110000", "10100100101110111",
            "100100101110000", "1010010010110000", "1011010010110101", "110101001010000", "110110101000000",
            "11010101101010100", "10101101100000", "1001010101110000", "101001011110010", "100100101110000",
            "110010101100110", "1101010010100000", "1110101001010000", "110111010010101", "101101011010000",
            "10101101100000", "11000011011100011", "1001001011100000", "11100100011010111", "1100100101010000",
            "1101010010100000", "11101100010100110", "1011010101010000", "101011010100000", "11010010110110100",
            "10010111010000", "1001001011010000", "1101001010110010", "1010100101010000", "1011010101010111",
            "110110010100000", "1011010101010000", "10101001101010101", "100110110100000", "1010010111010000",
            "10100010101110011", "101001011010000", "1010100110101000", "1110100101010000", "110101010100000",
            "1010111010100110", "1010101101010000", "100101101100000", "1010101011100100", "1010010101110000",
            "101001001100000", "1111001001100011", "1101100101010000", "101101101010111", "101011010100000",
            "1001011011010000", "100110111010101", "100101011010000", "1010010011010000", "1101010011010100",
            "1101001001010000", "1101010101011000", "1011010101000000", "1011010110100000", "11001010110100110",
            "1001010110110000", "100100110110000", "1010100101110100", "1010010010110000", "1011001001111010",
            "110101001010000", "110110101000000", "1010111101000110", "1010101101100000", "1001010101110000",
            "100101011110101", "100100101110000", "110010010110000", "111010010100011", "1110101001010000",
            "110101101011000", "101010111000000", "1010101101100000", "1001011011010101", "1001001011100000",
            "1100100101100000", "1101100101010100", "1101010010100000", "1101101001010000", "111010101010010",
            "101011010100000", "1010101110110111", "10010111010000", "1001001011010000", "1100101010110101",
            "1010100101010000", "1011010010100000", "1011101010100100", "1010110101010000", "101010111011001",
            "100101110100000", "1010010110110000", "10101000101110110", "101001010110000", "1010100100110000",
            "111100101010100", "110101010100000", "1010110101010000", "101101101010010", "100101101100000",
            "1010011011100110", "1010010011100000", "1101001001100000", "1110101001100101", "1101010100110000",
            "101101010100000", "111011010100011", "1001011011010000", "100101111010111", "100101011010000",
            "1010010011010000", "11101000010110110", "1101001001010000", "1101010100100000", "1101110101000101",
            "1011010110100000", "101011011010000", "101010110110010", "100100110110000", "1010010101110111",
            "1010010010110000", "1010101001010000", "11011001001010101", "110110100100000", "1010110110100000"
    };

    /**
     *  0000 0101 1011 0101 0010
     */

    private int[] days = {
            384, 354, 355, 383, 354, 355, 384, 354, 355, 384,
            354, 384, 354, 354, 384, 354, 355, 384, 355, 384,
            354, 354, 384, 354, 354, 385, 354, 355, 384, 354,
            383, 354, 355, 384, 355, 354, 384, 354, 384, 354,
            354, 384, 355, 354, 385, 354, 354, 384, 354, 384,
            354, 355, 384, 354, 355, 384, 354, 383, 355, 354,
            384, 355, 354, 384, 355, 353, 384, 355, 384, 354,
            355, 384, 354, 354, 384, 354, 384, 354, 355, 384,
            355, 354, 384, 354, 384, 354, 354, 384, 355, 355,
            384, 354, 354, 383, 355, 384, 354, 355, 384, 354,
            354, 384, 354, 355, 384, 354, 385, 354, 354, 384,
            354, 354, 384, 355, 384, 354, 355, 384, 354, 354,
            384, 354, 355, 384, 354, 384, 354, 354, 384, 355,
            354, 384, 355, 384, 354, 354, 384, 354, 354, 384,
            355, 355, 384, 354, 384, 354, 354, 384, 354, 355
    };

    private Calendar calendar;
    //查询日期与起始日期相隔的天数
    private long offsetDateNum;



    public Solar2LunarUtils(Calendar calendar){
        this.calendar = calendar;
        long currentDateNum = calendar.getTimeInMillis();
        Calendar start = Calendar.getInstance();
        start.clear();
        start.set(1900, 0, 31, 0, 0, 0);
        long startTimeInMillis = start.getTimeInMillis();
        offsetDateNum = (currentDateNum - startTimeInMillis) / 86400000L;
    }

    /**
     * 获取阴历年
     */
    public void getLunarYear(){

    }

    /**
     * 获取阴历月
     */
    public void getLunarMonth(){

    }

    /**
     * 获取阴历日
     */
    public void getLunarDate(){

    }

    /**
     * 获取年属性
     */
    public String getLunarAnimal(){
//        int i = calendar.get(Calendar.YEAR);
//        return animals[i%12];
        return null;
    }
}