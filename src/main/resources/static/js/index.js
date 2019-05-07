
$(function() {
    $("#calendar").calendar({
        /*
         * 传入今天的时间
         * 默认：客户端时间
         * 可传入一个服务器的时间
         */
        date: new Date(),
        width: 800,
        height: 400,
        /* 左右框显示的比例 */
        rate: 0.69,
        /*
         * 休假和加班设置
         * JSON格式：Y加年-M加月-D加日
         * 0表示休假 1表示加吧
         */
        week: false, // 是否开启单双休
        rest: true, //x
        day : false, //b
        fest : true, //j
        bypass : false,
        week_walue: "2019/6/8", // 双休对应的周六
        isclick: true,
        // configDay: {
        //     "Y2019": {
        //         "M6": {
        //             "D3": "休",
        //             "D2": "班",
        //             "D1": "抢",
        //         }
        //     }
        // } // 系统配置
    });
});
