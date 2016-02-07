package bmle.hackatbrown2016;

import android.provider.BaseColumns;

/**
 * Created by FrankChiem on 2/7/16.
 */
public class TableData {

    public TableData() {

    }

    public static abstract class TableInfo implements BaseColumns {

        public static final String QUESTION = "question";
        public static final String DESCRIPTION = "description";
        public static final String DATABASE_NAME = "user_question";
        public static final String TABLE_NAME = "reg_info";
    }
}
