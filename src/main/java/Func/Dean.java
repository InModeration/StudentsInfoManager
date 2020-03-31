package Func;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * class of Dean
 */
public class Dean extends User implements UserInit {
    // attributes of a dean
    private String ID;
    private String name;
    private String dept_name;
    private String phone;

    // 所有的dean都可以更改所有的student、instructor信息
    private static ArrayList<Student> students = null;
    private static ArrayList<Instructor> instructors = null;

    public Dean(String ID) {
        this.ID = ID;
        init_attributes();
    }

    /**
     * set the exam grade of a student on specific course
     */
    public void setExamGrade(Course course, Student student, String grade) {
        Course.setExamGrade(course, student, grade);
    }

    /**
     * operations on exam
     */
    public void manageExams() {
        // ExamFrame()

        //  update exam information
        //updateExams();

        //  insert exam
        //insertExams();

        // delete exam
        //deleteExams();
    }

    /**
     * sub method
     * update information of an exam
     */
    private void updateExams(String ID, String course_id, String ) {

    }

    /**
     * sub method
     * insert a new exam
     */
    private void insertExams() {

    }


    //@Overwrite
    public void setExamGrade(Exam exam, String grade) {
        exam.setGrade(grade);
    }




    @Override
    public void init_attributes() {
        String init = "select * from dean where ID = '" + this.ID + "'";
        ResultSet resultSet = Connect2DB.query(init);
        try {
            while (resultSet.next()) {
                this.name = resultSet.getString("name");
                this.dept_name = resultSet.getString("dept_name");
                this.phone = resultSet.getString("phone");
            }
            Connect2DB.connection.close();
        }   catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
