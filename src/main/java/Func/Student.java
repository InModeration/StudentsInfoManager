package Func;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import MyFrame.*;

/**
 * Student类的数据：
 * 1.ID等学生的信息 - 在该Student对象创建后便获取并存储
 * 2.所选课程相关的信息 - 在调用查看选课等方法时才进行访问并存储
 * （所有数据仅访问一次）
 */
public class Student extends User implements UserInit {
    // Func.Student attributes
    private String ID;
    private String name;
    private String dept_name;
    private String tot_cred;
    private String phone;
    private String enroll_year;
    private String gender;
    private String nationality;
    private String birthplace;

    private String getTakes;

    // Func.Student takes
    // course_id, sec_id, semester, year, building,

    // selected course information

    // 该学生已选课程
    private ArrayList<Section> takes = null;

    // 该学生考试科目
    private ArrayList<Exam> exams = null;

    /**
     * 初始化属性域
     * 创建StudentFrame
     * 初始化相关的sql语句
     */
    public Student(String ID){
        this.ID = ID;
        //  initialize related information about the student
        init_attributes();

        // paint the StudentFrame
        new StudentFrame(ID, this).initFrame();
    }

    /**
     * 根据学生ID初始化所有的信息,将其存储
     */
    @Override
    public void init_attributes() {
        String init = "select * from student where ID = " + ID;
        ResultSet info = Connect2DB.query(init);
        try{
            while (info.next()) {
                this.name = info.getString("Name");
                this.dept_name = info.getString("dept_name");
                this.tot_cred = info.getString("tot_cred");
                this.phone = info.getString("phone");
                this.enroll_year = info.getString("enroll_year");
                this.gender = info.getString("gender");
                this.birthplace = info.getString("birthplace");
                this.nationality = info.getString("nationality");
            }
            Connect2DB.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印学生信息
     */
    private void printInfo() {
        // print ID、name、dept_name、phone_number、year

        // System.out.println(this.toString());
    }

    /**
     * 进入选课界面
     * 1.查看个人选课结果
     * 2.退课
     * 3.所搜课程并选课
     */
    public void take() {
        // takeFrame()

        // click on 查看选课结果
        checkTakes();

        // click on 搜索


        // click on 选课
        //take();

        // click on 退课
        //dropSection();

    }

    /**
     * 查看选课结果
     */
    public void checkTakes() {
        // print takes
        // System.out.println("takes:");
        // Iterator iterator = takes.iterator();
        // while (iterator.hasNext())
        //    System.out.println(iterator.next().toString());
    }


    /**
     * 选课
     * 1.将该课程插入takes表
     * 2.将该课程加入takes数组
     */
    private void take(Section take) {
        // take为鼠标点击选中的课程

        // 将该课程插入takes表
        Section.takeSec(this.ID, take);

        // 将该课程插入数组takes中
        takes.add(take);
    }

    /**
     * 退课选项
     *  1.将该课程从takes表删除
     *  2.将该课程从takes数组删除
     */
    private void dropSection(Section drop) {
        // drop为选中的课程

        // 从表中删除
        Section.dropSec(this.ID, drop);

        // 从数组删除
        takes.remove(drop);
    }

    /**
     * get the sections the student has taken
     * @return
     */
    public ArrayList<Section> getTakes() {
        return this.takes;
    }

    /**
     * 初始化takes数组
     */
    private void initTakes() {
        takes = new ArrayList<>();
        getTakes = "select * from student natural join takes natural join section natural join course where ID = '" + ID + "'";
        Section.initSec(takes, getTakes);
    }

    /**
     * get exams the student has
     * @return
     */
    public ArrayList<Exam> getExams() {
        return this.exams;
    }

    /**
     * initialize the exams the student has
     */
    private void initExams() {
        exams = new ArrayList<>();
        String init = "select * from exam where ID ='" + this.ID + "'";
        Exam.initExams(exams, init);
    }

    public String getName() {return name;}

    public String getID () {return  ID;}

    @Override
    public String toString() {
        return this.ID + " " + this.name + " " + this.dept_name + " " + this.phone + " " +
                this.enroll_year + " " + this.tot_cred;
    }
}
