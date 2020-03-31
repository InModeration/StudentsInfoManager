package Func;

import java.util.ArrayList;

/**
 * implement some search methods
 */
public interface Search {
    ArrayList<Section> searchSecByTitle(String info);

    ArrayList<Section> searchSecByCourse_id(String info);
}
