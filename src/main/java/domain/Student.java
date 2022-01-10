package domain;

import json.*;

import java.util.ArrayList;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    private ArrayList<Tuple<String, Integer>> exams;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);
        this.exams = new ArrayList<>();
        for (Tuple<String, Integer> exam : exams) {
            this.exams.add(exam);
        }
    }

    @Override
    public JsonObject toJsonObject() {
        JsonObject jsonObject = super.toJsonObject();
        JsonObject[] examsObject = new JsonObject[this.exams.size()];
        for (int i = 0; i < this.exams.size(); i++) {
            examsObject[i] = new JsonObject(
                    new JsonPair("course", new JsonString(exams.get(i).key)),
                    new JsonPair("mark", new JsonNumber(exams.get(i).value)),
                    new JsonPair("passed", new JsonBoolean(exams.get(i).value.compareTo(2) > 0))
            );
        }
        jsonObject.add(new JsonPair("exams", new JsonArray(examsObject)));
        return jsonObject;
    }
}