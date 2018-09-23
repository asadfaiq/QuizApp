package com.quiz.thequiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.quiz.thequiz.QuizContract.*;
import android.os.Build;

import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;

public class QuizDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Quiz.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase sqLiteDatabase;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;

        final String SQL_CREATE_QUESTION_TABLE = " CREATE TABLE " +
                QuizContract.QuestionsTable.TABLE_NAME + "( " +
                QuestionsTable._ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                QuestionsTable.COLUMN_QUESTION + "TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + "INTEGER" +
                ")";
        sqLiteDatabase.execSQL(SQL_CREATE_QUESTION_TABLE);
        fillQuestionsTable();


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP  TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    private void fillQuestionsTable() {


        Question q1 = new Question("WHO IS FOUNDER OF PAKISTAN", "A", "B", "C", 1);
        addQuestion(q1);

        Question q2 = new Question("HOW MANY PILLERS OF ISLAM", "A", "B", "C", 2);
        addQuestion(q2);

        Question q3 = new Question("What is gravity of earth", "A", "B", "C", 3);
        addQuestion(q3);

        Question q4 = new Question("2+2-2*2", "A", "B", "C", 4);
        addQuestion(q4);

        Question q5 = new Question("WHAT IS CIPHER TEXT", "A", "B", "C", 5);
        addQuestion(q5);
        Question q6 = new Question("2+2-2*2 Again", "A", "B", "C", 4);
        addQuestion(q6);
        Question q7 = new Question("WHO IS FOUNDER OF PAKISTAN", "A", "B", "C", 1);
        addQuestion(q7);
    }


    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());

        sqLiteDatabase.insert(QuestionsTable.TABLE_NAME, null, cv);

    }

    public List<Question> getALLQuestion() {
        List<Question> questionList = new ArrayList<>();
        sqLiteDatabase = getReadableDatabase();
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
        if (c.moveToFirst()) {

            do {

                Question question = new Question();
                question.setQuestion1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToFirst());
        }

        c.close();
        return questionList;
    }
}

