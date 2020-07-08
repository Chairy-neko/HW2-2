package com.example.chapter2.recycler;

import java.util.ArrayList;
import java.util.List;

public class TestDataSet {

    public static List<TestData> getData() {
        List<TestData> result = new ArrayList();
        result.add(new TestData("游戏小助手","刚刚","抖出好游戏"));
        result.add(new TestData("抖音小助手", "昨天","#收下我的双下巴"));
        result.add(new TestData("系统消息", "07-06","账号登录游戏提醒"));
        result.add(new TestData("我是豆豆啊哇塞", "07-01","转发[视频]"));
        result.add(new TestData("陌生人消息", "06-28","test1: 转发[直播]: 七舅脑爷"));
        result.add(new TestData("喂喂卫", "06-12","[Hi]"));
        result.add(new TestData("李垭超", "06-04","转发[视频]"));
        result.add(new TestData("tesyyu", "05-01","我是tessyu，让我们开始聊天吧"));
        result.add(new TestData("柴郡猫", "04-19","转发[视频]"));
        result.add(new TestData("龙傲天", "04-10","你好"));
        result.add(new TestData("叶良辰", "04-10","[Bye]"));
        return result;
    }

}
