package Func;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Section {
    // attributes belonging to section
    private String course_id;
    private String sec_id;
    private String semester;
    private String year;
    private String building;
    private String room_number;
    private String date;

    // attributes in course
    private String credit;
    private String title;
    private String dept_name;

    // attribute in teaches
    private String instructor_id;
    // attribute in instructor
    private String instructor_name;

    // store sections temporarily
    private static ArrayList<Section> sections = null;

    // students who selected the section
    private ArrayList<Student> students = null;

    public Section(String course_id, String sec_id, String title, String dept_name, String semester, String year) {
        this.course_id = course_id;
        this.sec_id = sec_id;
        this.title = title;
        this.dept_name = dept_name;
        this.semester = semester;
        this.year = year;
        init();
    }

    /**
     *  initialize non-primary key of a section
     */
    private void init() {
        String init = "select * from section natural join course natural join teaches natural join " +
                "instructor where course_id = '" + this.course_id + "' and sec_id = '" + this.sec_id + "' and " +
                "semester = '" + this.semester + "' and year = '" + this.year;
        ResultSet resultSet = Connect2DB.query(init);
        try {
            while (resultSet.next()) {
                this.building = resultSet.getString("building");
                this.room_number = resultSet.getString("room_number");
                this.date = resultSet.getString("date");
                this.credit = resultSet.getString("credit");
                this.title = resultSet.getString("title");
                this.dept_name = resultSet.getString("dept_name");
                this.instructor_id = resultSet.getString("ID");
                this.instructor_name = resultSet.getString("name");
            }
        }   catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * initialize the students array
     */
    private void initStudents() {
        Student temp = null;
        String getStudents = "select T.* from section natural left outer join takes natural left outer join" +
                " student as T where course_id = '" + this.course_id + "' and sec_id = '" + this.sec_id + "' and " +
                "semester = '" + this.semester + "' and year = '" + this.year;
        ResultSet resultSet = Connect2DB.query(getStudents);
        try {
            while (resultSet.next()) {
                temp = new Student(resultSet.getString("ID"));
                students.add(temp);
            }
            Connect2DB.connection.close();
        }   catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将选中的课程插入takes表
     */
    public static void takeSec(String stuID, Section take) {
        String takeSec = "insert into takes values(" + stuID + "," +take.course_id + ", " + take.sec_id +
                ", " + take.semester + ", " + take.year + ", null, null)";
        Connect2DB.modify(takeSec);
    }

    /**
     * 将选中的课程从takes表中删除
     */
    public static void dropSec(String stuID, Section drop) {
        String dropSec = "delete from takes where ID = '" + stuID + "' and course_id = '" + drop.course_id +
                "' and sec_id = '" + drop.sec_id + "' and semester = '" + drop.semester + "' and year = '" + drop.year + "'";
        Connect2DB.modify(dropSec);
    }

    /**
     * 将section填入arraylist
     * @param arrayList
     * @param sql
     */
    public static void initSec(ArrayList arrayList, String sql) {
        String query = sql;
        Section temp = null;

        ResultSet resultSet = Connect2DB.query(query);
        try {
            while (resultSet.next()) {
                temp = new Section(resultSet.getString("course_id"), resultSet.getString("sec_id"),
                        resultSet.getString("title"), resultSet.getString("dept_name"),
                        resultSet.getString("semester"), resultSet.getString("year"));
                arrayList.add(temp);
            }
            Connect2DB.connection.close();
        }   catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * method to get Section
     * @param sql
     * @return
     */
    public static ArrayList<Section> getSections(String sql) {
        sections = new ArrayList<>();
        initSec(sections, sql);
        return sections;
    }

    /**
     * update grade in takes
     */
    public static void setGrade(Section select, Student student, String grade) {
        String setGrade = "update takes set grade = '" + grade + "' where course_id = '" +
                select.course_id + "' and sec_id = '" + select.sec_id + "' and semester = '" +
                select.semester + "' and year = " + select.year + "' and ID = '" + student.getID();
        Connect2DB.modify(setGrade);
    }

    /**
     * get all students who have selected the section
     * @return
     */
    public ArrayList<Student> getStudents() {
        return this.students;
    }


    @Override
    public String toString() {
        return this.course_id + " " + this.sec_id + " " + this.title + " " + this.dept_name + " " +
                this.semester + " " + this.year + " " + this.credit + " " + this.building + " " +
                this.room_number + " " + this.date + " " + this.instructor_id + " " + this.instructor_name;
    }
}
