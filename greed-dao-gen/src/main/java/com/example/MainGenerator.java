package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MainGenerator {

    private static final String PROJECT_DIR = System.getProperty("user.dir");

    public static void main(String[] args) {
        Schema schema = new Schema(1, "com.kanvalkalra.colormemory.db");
        schema.enableKeepSectionsByDefault();

        addTables(schema);

        try {
            /* Use forward slashes if you're on macOS or Unix, i.e. "/app/src/main/java"  */
            new DaoGenerator().generateAll(schema, PROJECT_DIR + "/app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTables(final Schema schema) {
        Entity highScoreUser = addHighScoreUser(schema);
    }

    private static Entity addHighScoreUser(Schema schema) {
        Entity highScoreUser = schema.addEntity("HighScoreUser");
        highScoreUser.addStringProperty("name").notNull();
        highScoreUser.addLongProperty("score").notNull();

        return highScoreUser;
    }


}


