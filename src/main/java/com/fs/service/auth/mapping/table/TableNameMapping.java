package com.fs.service.auth.mapping.table;

public final class TableNameMapping {

    public static class TableBaseModel {
        public static final String id = "id";
        public static final String createdBy = "created_by";
        public static final String lastModifiedDate = "last_modified_date";
        public static final String createdDate = "created_date";
        public static final String modifiedBy = "modified_by";
        public static final String deleted = "deleted";
    }

    public static final class TableUserModel extends TableBaseModel {
        public static final String TABLE_NAME = "user_model";
        public static final String email = "email";
        public static final String password = "password";
        public static final String name = "name";
        public static final String role = "role";
    }

}
