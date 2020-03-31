package Func;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Course {
    // Func.Course attributes
    private String course_id;
    private String title;
    private String dept_name;
    private String credits;

    private String initCourse;

    // 所有课程的集合 -- 类的域
    private static ArrayList<Course> courses = null;

    // 课程下的section集合
    private ArrayList<Section> sections = null;

    public Course(String course_id) {
        this.course_id = course_id;
        // 初始化该课程
        initCourse(this.course_id);
        // 初始化课程所属的课程段
        initSections();
    }

    /**
     * Course类的初始化
     * 将所有课程加入至集合中
     */
    public static void classInit(){
        courses = new ArrayList<>();

        String init = "select * from course";
        ResultSet resultSet = Connect2DB.query(init);
        try {
            while (resultSet.next()) {
                Course temp = new Course(resultSet.getString("course_id"));
                courses.add(temp);
            }
            Connect2DB.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * set the grade of a student's exam
     * @param course
     * @param student
     * @param grade
     */
    public static void setExamGrade(Course course, Student student, String grade) {
        // use course.course_id and student.ID to specify to a tuple
        String setExamGrade = "update exam set grade = '" + grade + "' where course_id = '" +
                course.course_id + "' and ID = '" + student.getID() + "'";
        Connect2DB.modify(setExamGrade);
    }

    /**
     * 根据course_id初始化Section集合
     * 添加该课程下的section
     */
    private void initSections() {
        sections = new ArrayList<>();
        String init = "select * from section natural join course where course_id = '" + course_id + "'";
        Section.initSec(sections, init);
    }

    /**
     * get sections of a course
     * @return
     */
    public ArrayList<Section> getSections() {
        return this.sections;
    }

    /**
     * @return  array list which contains all the courses
     */
    public static ArrayList<Course> getCourses() {return courses;}

    /**
     * initialize the course by course_id
     */
    private void initCourse(String course_id) {
        initCourse = "select * from course where course_id = '" + course_id + "'";
        ResultSet resultSet = Connect2DB.query(initCourse);
        try {
            while (resultSet.next()) {
                this.title = resultSet.getString("title");
                this.dept_name = resultSet.getString("dept_name");
                this.credits = resultSet.getString("credits");
            }
            Connect2DB.connection.close();
        }   catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.course_id + " " + this.title + " " +
                this.dept_name + " " + this.credits;
    }
}
