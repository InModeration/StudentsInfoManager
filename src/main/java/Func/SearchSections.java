package Func;

import java.util.ArrayList;

public class SearchSections implements Search {
    /**
     * 根据标题搜索课程
     * 输入相关内容获取搜索到的section
     * @param info  used to search
     */
    @Override
    public ArrayList<Section> searchSecByTitle(String info) {
        String sql = "select * from section natural join course where title like '%" + info + "%'";
        return Section.getSections(info);
    }

    /**
     * 根据course_id搜索课程
     * @param info
     * @return
     */
    @Override
    public ArrayList<Section> searchSecByCourse_id(String info) {
        String sql = "select * from section natural join course where course_id like '%" + info + "%'";
        return Section.getSections(info);
    }
}
