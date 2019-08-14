package com.avito.test;

public class ClassParametrs {
   private Parameters[] params;

    public static class Parameters {
        private int id;
        private String title, value = "";
        private Values[] values;

        private static class Values {
            private int id;
            private String title;
            private Parameters[] params;
        }

    }
    public int sizeParam(){
        return params.length;
    }
    public int sizeValues(int i){
        return params[i].values.length;
    }
    public int getId(int i){
        return i < params.length ? params[i].id : 0;
    }
    public void setValuesParams(int p,int v,String val, int idVal){
                 if (params[p].values[v].params[0].values != null){
                     for (int i=0; i< params[p].values[v].params[0].values.length;i++){
                         if (val.equals(""+params[p].values[v].params[0].values[i].id)){
                             params[p].values[v].params[0].value = params[p].values[v].params[0].values[i].title;
                         }
                     }
                 } else {
                     if (params[p].values[v].params[0].id == idVal){
                         params[p].values[v].params[0].value = val;
                     }
                 }

    }
    public void setValue(int idVal,String val){
        for (int i = 0; i< params.length;i++){
            if (existValues(i)){
               for(int j = 0; j < params[i].values.length;j++){
                    if (val.equals("" +params[i].values[j].id)){
                        params[i].value = params[i].values[j].title;
                    }
                }
            } else {
                if (params[i].id == idVal){
                    params[i].value = val;
                }
            }
        }
    }
    public boolean existValues(int i){
       return params[i].values != null ;
    }
    public int getValuesParamsId(int i, int j) {
            return (params[i].values[j].params != null &&
                    i < params.length && j < params[i].values.length) ?
                    params[i].values[j].params[0].id : 0;

    }

    public void getParam(){
        for (int i = 0; i< params.length;i++){
            System.out.println(params[i].value);
            if (existValues(i)) {
                for (int j = 0; j < params[i].values.length; j++){
                    if (params[i].values[j].params != null) {
                        System.out.println("   "+params[i].values[j].params[0].value);
                    }
                }
            }

        }

    }
    public boolean Error(){
        boolean bool = true;
        for (int i = 0; i< params.length;i++){
            if (params[i].value == "") {
                bool = false;
            }
        }
        return bool;
    }
}