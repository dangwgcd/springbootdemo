package com.my.util;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//import org.junit.Test;

/**
 * Created by wt on 2017/9/27.
 */
public class ListUtils {
    /**
     * 取两个集合的交集
     *
     * @param list1
     * @param list2
     * @return
     */
    public static <T> List<T> intersection(List<T> list1,
                                           List<T> list2) {
        if (list1 == null ||list1.size()==0|| list2 == null||list2.size()==0) {
            return new ArrayList<T>();
        }

        HashSet<T> set1 = new HashSet<T>(list1);
        HashSet<T> set2 = new HashSet<T>(list2);

        Sets.SetView<T> result = Sets.intersection(set1, set2);

        return new ArrayList<>(result);
    }

    /**
     * 取两个集合的并集
     *
     * @param list1
     * @param list2
     * @return
     */
    public static <T> List<T> union(List<T> list1,
                                    List<T> list2) {
        if (list1 == null || list1.size() == 0) {
            return list2;
        }

        if (list2 == null || list2.size() == 0) {
            return list1;
        }

        HashSet<T> set1 = new HashSet<T>(list1);
        HashSet<T> set2 = new HashSet<T>(list2);

//        Sets.SetView<T> result = Sets.union(set1, set2);
        set1.addAll(set2);
        return new ArrayList<>(set1);
//        return new ArrayList<>(result);
    }


/**
     * 取两个集合的差集 list1 - list2
     *
     * @param list1
     * @param list2
     * @return
     */
    public static <T> List<T> difference(List<T> list1,
                                    List<T> list2) {
        if (list1 == null||list1.size()==0) {
            return new ArrayList<T>();
        }

        if (list2 == null||list2.size()==0) {
            return list1;
        }

        HashSet<T> set1 = new HashSet<T>(list1);
        HashSet<T> set2 = new HashSet<T>(list2);

        Sets.SetView<T> result = Sets.difference(set1, set2);

        return new ArrayList<>(result);
    }


//    @Test
    public void testIntersection() {
        List<Integer> list1 = new ArrayList<Integer>();

        List<Integer> list2 = new ArrayList<Integer>();

        for (int i = 1; i <= 10; i++) {
            list1.add(i);
        }


        for (int i = 5; i <= 15; i++) {
            list2.add(i);
        }

        List<Integer> list = intersection(list1, list2);
        System.out.println(list);
    }

//    @Test
    public void testUnion() {
        List<Integer> list1 = new ArrayList<Integer>();

        List<Integer> list2 = new ArrayList<Integer>();

        for (int i = 1; i <= 10; i++) {
            list1.add(i);
        }


        for (int i = 5; i <= 15; i++) {
            list2.add(i);
        }

        List<Integer> list = union(list1, list2);
        System.out.println(list);
    }

//    @Test
    public void testDifference() {
        List<Integer> list1 = new ArrayList<Integer>();

        List<Integer> list2 = new ArrayList<Integer>();

        for (int i = 1; i <= 10; i++) {
            list1.add(i);
        }


        for (int i = 5; i <= 15; i++) {
            list2.add(i);
        }

        List<Integer> list = difference(list1, list2);
        System.out.println(list);
    }
}
