package com.example.chapter2.TopRecycler;

import java.util.ArrayList;
import java.util.List;

public class TopDataSet {
    public static List<TopData> getData(){
        List<TopData> result = new ArrayList();
        result.add(new TopData("粉丝"));
        result.add(new TopData("赞"));
        result.add(new TopData("@我的"));
        result.add(new TopData("评论"));
        return result;
    }
}