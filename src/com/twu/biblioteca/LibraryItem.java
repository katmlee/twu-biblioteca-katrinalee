package com.twu.biblioteca;
//
//import java.util.ArrayList;
//
/**
 * Created by klee on 17/1/17.
 */
interface LibraryItem {
    String getTitle();

    boolean getCheckedIn();

    String getCheckedOutBy();

    void setCheckedIn(boolean checkedIn);

    void setCheckedOutBy(String checkedOutBy);
}

