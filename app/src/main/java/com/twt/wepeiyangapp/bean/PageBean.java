package com.twt.wepeiyangapp.bean;

import java.util.List;

/**
 * Created by Arsener on 2017/4/1.
 */

public class PageBean {
    /**
     * error_code : -1
     * message :
     * data : [{"index":53424,"subject":"邂逅\u201c玫瑰独白\u201d 去听一个本应正视的故事","pic":"http://news.twt.edu.cn/public/news/wyynews/420_2017_04_01_13_04_33_cover_296.jpg","visitcount":38,"comments":0,"summary":"3月31日晚7时，在天津大学北洋园校区大学生活动中心报告厅内，北洋话剧社的年度大戏《..."},{"index":53421,"subject":"第二期海棠书院学院录取名单揭晓！","pic":"","visitcount":33,"comments":0,"summary":"&nbsp; &nbsp; &nbsp; &nbsp;经选拔，以下74位同学正式成为第二期\u201c海棠书院\u201d学员，其中北洋园..."},{"index":53420,"subject":"【北洋大讲堂】周琪院士的干细胞研究之路","pic":"http://news.twt.edu.cn/public/news/wyynews/420_2017_03_31_18_28_02_cover_292.jpg","visitcount":247,"comments":0,"summary":"3月30日下午3时30分，中国科学院大学副校长、动物研究所副所长、干细胞与生殖生物学国家..."},{"index":53415,"subject":"曲苑杂坛 百科全书 你在听吗","pic":"http://open.twtstudio.com/imgcache/8f7bb804fe9d747e96e3297c031a3f83.jpg","visitcount":51,"comments":0,"summary":"3月26日晚6时30分，北洋相声社的一场\u201c开箱\u201d相声表演，相聚在大通学生活动中心A区一楼10..."},{"index":53406,"subject":"光荣与梦想：\u201c两弹一星\u201d精神宣讲报告","pic":"http://news.twt.edu.cn/public/news/wyynews/420_2017_03_27_14_19_04_cover_280.jpg","visitcount":447,"comments":0,"summary":"3月26日下午2时30分, \u201c两弹一星\u201d精神永放光芒宣讲教育报告在卫津路校区大学生活动中心..."},{"index":53405,"subject":"机械工程学院学业辅导工程：用我的臂膀助你前行","pic":"http://open.twtstudio.com/imgcache/ac6d8107e53f9a4c97e5debdb5eb3e41.jpg","visitcount":391,"comments":0,"summary":"为了能够给予学业上有困难的学生相应的学业帮辅，自2016年起，天津大学机械工程学院就..."},{"index":53397,"subject":"【北洋大讲堂】日新月异  网络安全法讲座","pic":"http://news.twt.edu.cn/public/news/wyynews/420_2017_03_24_17_02_58_cover_276.jpg","visitcount":304,"comments":0,"summary":"3月23日晚7时,由天津大学法学院互联网政策与法律研究中心、天津大学法学院、共青团天津..."},{"index":53395,"subject":"美人当以诗词为心\u2014\u2014图书馆预约系统指南","pic":"http://open.twtstudio.com/imgcache/51c1e58dc38777d0d9b57d778ebd72b3.jpg","visitcount":182,"comments":0,"summary":"\u201c富家不用买良田，书中自有千锺粟；安居不用架高堂，书中自有黄金屋。\u201d开学以来，你..."},{"index":53389,"subject":"【男人世界专访】铁骨铮铮吴京安","pic":"http://news.twt.edu.cn/public/news/wyynews/420_2017_03_17_22_38_31_cover_296.jpg","visitcount":668,"comments":0,"summary":"3月17日晚6时30分，国家一级演员吴京安做客天津大学，受天津电视台的邀请参加《男人世界..."},{"index":53387,"subject":"【音乐下午茶】中西经典名曲音乐会","pic":"http://news.twt.edu.cn/public/news/wyynews/420_2017_03_16_22_27_26_cover_292.jpg","visitcount":697,"comments":0,"summary":"3月16日下午6时30分，由共青团天津大学委员会和天津大学艺术教育中心联合主办的\u201c美丽的..."},{"index":53384,"subject":"北洋园校区社团春季纳新活动成功举办","pic":"http://open.twtstudio.com/imgcache/dcc7890ee10f55482009eae331fcc572.jpg","visitcount":41,"comments":0,"summary":"春风十里只为你，百团翘首以盼卿。3月11日，北洋园结束一假期的寂静，人头攒动，热闹非..."},{"index":53379,"subject":"【图集】社团春纳 遇见新的精彩","pic":"http://news.twt.edu.cn/public/news/wyynews/420_2017_03_11_16_23_27_cover_282.jpg","visitcount":769,"comments":1,"summary":"3月11日上午8时，卫津路校区社团春季纳新活动在学一广场拉开帷幕。参加本次纳新的社团..."}]
     */

    public int error_code;
    public String message;
    public List<NewsBean> data;

    public static class NewsBean {
        /**
         * index : 53424
         * subject : 邂逅“玫瑰独白” 去听一个本应正视的故事
         * pic : http://news.twt.edu.cn/public/news/wyynews/420_2017_04_01_13_04_33_cover_296.jpg
         * visitcount : 38
         * comments : 0
         * summary : 3月31日晚7时，在天津大学北洋园校区大学生活动中心报告厅内，北洋话剧社的年度大戏《...
         */

        public int index;
        public String subject;
        public String pic;
        public int visitcount;
        public int comments;
        public String summary;
    }
}
