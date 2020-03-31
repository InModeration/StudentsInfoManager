package Func;

import MyFrame.InstructorFrame;

import java.net.ConnectException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Instructor extends User implements UserInit {
    // attributes of an instructor
    private String ID;
    private String name;
    private String dept_name;

    private String salary;
    private String phone;

    // store the sections the instructor will teach
    private ArrayList<Section> teaches = null;

    private String init = "select * from instructor";

    public Instructor(String ID) {
        this.ID = ID;
        init_attributes();
        new InstructorFrame(ID).initFrame();
    }

    /**
     * initialize sections array that the instructor will teach
     */
    private void initTeaches() {
        teaches = new ArrayList<>();
        String initTeach = "select * from teaches where ID = " + this.ID;
        Section.initSec(teaches, initTeach);
    }

    /**
     * show the sections the instructor teaches
     */
    public void showTeaches() {
        // print this.teaches
    }

    /**
     * 察看该课程的详情
     * @param select    选中的课程
     */
    private void showSecDetails(Section select){
        // print select.toString()
    }

    /**
     *  查看选则该课程的学生信息
     * @param select    选中的课程
     */
    private void showSecStu(Section select){
        // print select.getStudents();
    }

    /**
     * instructor set grade for a student that he/she teaches
     * use the teach arraylist to get the section he/she teaches
     * then use the section.students to set student's grade
     * @param select the section selected
     * @param student the student selected
     */
    public void setGrade(Section select, Student student, String grade) {
        // this.getTeaches() to get the list of teaches<Section>
        // choose one section and use section.getStudents to get the list of students<Student>
        // choose one student and enter a grade
        Section.setGrade(select, student, grade);
    }

    public ArrayList getTeaches() {return this.teaches;}

    @Override
    public void init_attributes() {
        init = init + " where ID = " + ID;
        ResultSet resultSet = Connect2DB.query(init);
        try {
            while (resultSet.next()) {
                this.name = resultSet.getString("name");
                this.dept_name = resultSet.getString("dept_name");
                this.salary = resultSet.getString("salary");
                this.phone = resultSet.getString("phone");
            }
            Connect2DB.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
