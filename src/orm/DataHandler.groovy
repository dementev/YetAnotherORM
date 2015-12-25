package orm

interface DataHandler<DBType, JavaType> {

    DBType fromJavaToDB(JavaType javaValue);
    JavaType fromDBToJava(DBType dbValueValue);

    static class NoHandler implements DataHandler<Object, Object> {

        @Override
        Object fromJavaToDB(Object javaValue) {
            return javaValue;
        }

        @Override
        Object fromDBToJava(Object dbValueValue) {
            return dbValueValue;
        }
    }
}