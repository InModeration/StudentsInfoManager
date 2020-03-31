package Func;

import MyFrame.LogFrame;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * 入口类，仅加载一次
 */
public class Enter {

    //
    private static String logInfo;

    // 1-student 2-instructor 3-dean
    private static int role;

    // 存储登录资料
    private static ArrayList<String> stuLog = null;
    private static ArrayList<String> insLog = null;
    private static ArrayList<String> deanLog = null;

    // sql to get the information of logging
    private static String getLog = "select R.ID, R.password, S.ID, S.password, T.ID, T.password " +
            "from student as R, instructor as S, dean as T";

    /**
     * 绘制登录界面
     * 获取登录信息-所有用户的ID及密码
     * 获取用户输入并核对身份信息
     * 根据身份实例化相应的用户类
     */
    static {
        // get the log info
        stuLog = new ArrayList<>();
        insLog = new ArrayList<>();
        deanLog = new ArrayList<>();

        ResultSet resultSet = Connect2DB.query(getLog);
        try {
            while (resultSet.next()) {
                stuLog.add(resultSet.getString("R.ID") + " "
                        + resultSet.getString("R.password"));
                insLog.add(resultSet.getString("S.ID") + " "
                        + resultSet.getString("S.password"));
                deanLog.add(resultSet.getString("T.ID") + " "
                        + resultSet.getString("T.password"));
            }
            Connect2DB.connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }

        // make sure there are no duplicated tuples
        stuLog = new ArrayList<>(new HashSet<>(stuLog));
        insLog = new ArrayList<>(new HashSet<>(insLog));
        deanLog = new ArrayList<>(new HashSet<>(deanLog));

        // initialize the log frame
        new LogFrame().initFrame();


        // get the input and create Func.User
        //enter();
    }

    /**
     * 获取用户信息核对身份
     * 实例化用户
     */
    /*public static void enter() {
        String ID = null;
        String password = null;
        String information = null;
        Scanner scanner = null;
        int length = 0;

        while (information == null) {
            System.out.println("请输入用户ID：");
            scanner = new Scanner(System.in);
            if (scanner.hasNext())
                ID = scanner.next();
            System.out.println("请输入用户密码：");
            scanner = new Scanner(System.in);
            if (scanner.hasNext())
                password = scanner.next();
            information = ID + " " + password;
            if (log.contains(information))  break;
            information = null;
            System.out.println("用户ID或密码错误！重新输入！");
        }

        // assume that studentID length is 9 instructor 7 and dean 5
        length = ID.length();
        if (length == 9) {
            Student student = new Student(ID);
        }
        else if (length == 7) {
            // new Instuctor()
        }
        else {
            // new dean()
        }
    }*/

    /**
     * judge if the information is right
     * @param info
     * @param ro
     * @return  if has logged on successfully
     */
    public static boolean log(String info, int ro) {
        logInfo = info;
        role = ro;
        if (role == 1 && stuLog.contains(logInfo))
            return true;
        if (role == 2 && insLog.contains(logInfo))
            return true;
        if (role == 3 && deanLog.contains(logInfo))
            return true;
        return false;
    }
}
