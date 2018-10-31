package project.mobile.cau.sanchez.mathieu.mybmw;

import java.io.Serializable;

class MenuModel implements Serializable {

    String menuName;
    boolean hasChildren, isGroup;

    MenuModel( String menuName, boolean isGroup, boolean hasChildren ) {

        this.menuName = menuName;
        this.isGroup = isGroup;
        this.hasChildren = hasChildren;
    }

}