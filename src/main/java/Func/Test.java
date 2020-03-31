package Func;

import java.awt.*;
import java.awt.image.AreaAveragingScaleFilter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import MyFrame.*;
import sun.rmi.runtime.Log;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        //new Enter();

        // test on Section and Course
        Course.classInit();
        ArrayList<Course> courses = Course.getCourses();
        Iterator iterator = courses.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next().toString());
        System.out.println("-------------------");

        Course course = courses.get(0);
        ArrayList<Section> sections = course.getSections();
        iterator = sections.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next().toString());


        /*ArrayList<Course> test = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            test.add(new Course("CS -" + i));
            System.out.println("ok" + i);
        }*/

        /*Course test = null;
        int i = 0;
        while (i++ < 20) {
            test = new Course("" + i);
            System.out.println(test.toString());
        }*/

        /*String test = "select * from course where course_id = 'CS-347'";
        ResultSet resultSet = Connect2DB.query(test);
        Course ttest = null;
        try {
            while (resultSet.next()) {
                ttest = new Course(resultSet.getString("course_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(ttest.toString());*/

        /*Course test = new Course("cs-341");
        System.out.println(test.toString());*/

        /*ArrayList<Course> courses = new ArrayList<>();
        String test = "select * from course";
        ResultSet resultSet = Connect2DB.query(test);
        try {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("course_id"));
                courses.add(new Course(resultSet.getString("course_id")));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }*/



        /*ArrayList<String> stu = new ArrayList<>();
        ArrayList<String> ins = new ArrayList<>();

        String get = "SELECT T.ID, T.`password`, S.ID, S.`password`\n" +
                "FROM student as T, instructor as S";
        ResultSet resultSet = Connect2DB.query(get);
        try {
            while (resultSet.next()) {
                stu.add(resultSet.getString("T.ID") + " " + resultSet.getString("T.password"));
                ins.add(resultSet.getString("S.ID") + " " + resultSet.getString("S.password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        stu = new ArrayList<>(new HashSet<>(stu));
        ins = new ArrayList<>(new HashSet<>(ins));

        Iterator iterator_1 = stu.iterator();
        while (iterator_1.hasNext())
            System.out.println(iterator_1.next());

        System.out.println("---------------------");
        Iterator iterator_2 = ins.iterator();
        while (iterator_2.hasNext())
            System.out.println(iterator_2.next());*/
    }
}