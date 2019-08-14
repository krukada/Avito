package com.avito.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.*;


public class Main {
    public static void main(String[] args){
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("/Users/adelinazagitova/IdeaProjects/avitoProject/src/main/java/com/avito/test/TestcaseStructure"));
            ClassParametrs parameters = gson.fromJson(br,ClassParametrs.class);
             br = new BufferedReader(
                    new FileReader("/Users/adelinazagitova/IdeaProjects/avitoProject/src/main/java/com/avito/test/Values"));
            ClassValues values = gson.fromJson(br,ClassValues.class);


            for (int i = 0; i<parameters.sizeParam();i++){
                if (parameters.existValues(i)){
                    for (int h = 0; h< parameters.sizeValues(i);h++){
                        for (int j = 0; j<values.sizeValues();j++){
                            if (parameters.getValuesParamsId(i,h) == values.getId(j)){
                                parameters.setValuesParams(i,h,values.getValue(j),values.getId(j));
                            }

                        }
                    }
                }
                for (int j = 0; j<values.sizeValues();j++){
                    if (parameters.getId(i) == values.getId(j)){
                        parameters.setValue(parameters.getId(i),values.getValue(j));
                    }
                }
            }
            if (parameters.Error()) {
                FileWriter file = new FileWriter("/Users/adelinazagitova/IdeaProjects/avitoProject/src/main/java/com/avito/test/StructureWithValues.json");
                gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();
                String json = gson.toJson(parameters);
                file.write(json);
                file.flush();

            } else {
                Errors errors = new Errors();
                FileWriter file = new FileWriter("/Users/adelinazagitova/IdeaProjects/avitoProject/src/main/java/com/avito/test/error.json");
                gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();
                String json = gson.toJson(errors);
                file.write(json);
                file.flush();
            }

        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
