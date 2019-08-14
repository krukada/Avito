package com.avito.test;

public class ClassValues {
    private Values[] values;

    public class Values {
        private int id;
        private String value;

    }
    public int sizeValues(){
        return values.length;
    }
    public int getId(int i){
        if (i < values.length){
            return values[i].id;
        } else
            return 0;
    }
    public String getValue(int i){
        if (i < values.length){
            return values[i].value;
        } else
            return "";
    }

}
