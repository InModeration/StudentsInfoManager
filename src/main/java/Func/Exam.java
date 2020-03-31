package Func;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * class Exam -- one student and one course
 */
public class Exam implements UserInit{

    // attributes of exam table
    private String ID;
    private String course_id;
    private String date;
    private String grade;
    private String GPA;

    // all the exams
    private static ArrayList<Exam> exams = null;
    // the sql
    private static String getExams = "select * from exam";

    public Exam(String ID, String course_id) {
        this.course_id = course_id;
        this.ID = ID;
        init_attributes();
    }

    /**
     * set the exam grade
     * @param grade
     */
    public void setGrade(String grade) {
        String set = "update exam set grade = '" + grade + "' where course_id = '" +
                this.course_id + "' and ID = '" + this.ID + "'";
        Connect2DB.modify(set);
    }

    /**
     * 将exam填入arraylist
     */
    public static void initExams(ArrayList<Exam> arrayList, String init) {
        Exam temp = null;

        ResultSet resultSet = Connect2DB.query(init);
        try {
            while (resultSet.next()) {
                temp = new Exam(resultSet.getString("ID"),
                        resultSet.getString("course_id"));
                arrayList.add(temp);
            }
            // close the connection
            Connect2DB.connection.close();
        }   catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * get all the exams
     * @return
     */
    public static ArrayList<Exam> getExams() {
        exams = new ArrayList<>();
        initExams(exams, getExams);
        return exams;
    }

    @Override
    public void init_attributes() {
        String init = "select * from exam where ID = '" + this.ID +
                "' and course_id = '" + this.course_id + "'";
        ResultSet resultSet = Connect2DB.query(init);
        try {
            while (resultSet.next()) {
                this.date = resultSet.getString("date");
                this.GPA = resultSet.getString("GPA");
                this.grade = resultSet.getString("grade");
            }
            Connect2DB.connection.close();
        }   catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.ID + " " + this.course_id + " " + this.date + " " +
                this.grade + " " + this.GPA;
    }
}
