package Database;

import android.provider.BaseColumns;

public final class UsersMaster {
    
    private UsersMaster() {
    }

    protected static class Users implements BaseColumns{

        protected static final String TABLE_NAME = "users";
        protected static final String COLUMN_NAME_USERNAME = "username";
        protected static final String COLUMN_NAME_PASSWORD = "password";

    }
}
