package com.example.qlsinhvien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.qlsinhvien.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class DB_QLSV extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME="QLSV_manager";
    private static final String TABLE_NAME="tbQLSV";
    private static final String ID="id";
    private static final String NAME="name";
    private static final String EMAIL="email";
    private static final String MSSV="mssv";
    private static final String BIRTHDAY="birthday";


    private static final String QueryCreateTB="create table "+TABLE_NAME+"("+
            ID +" integer primary key,"+
            NAME+" text,"+
            MSSV+" text,"+
            BIRTHDAY+" text,"+
            EMAIL+ "text)" ;

    public DB_QLSV(Context context)
    {
        super(context,DATABASE_NAME,null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.beginTransaction();
        try {
            db.execSQL(QueryCreateTB);
            db.execSQL("insert into tbQLSV(name,mssv,birthday,email) values('Nguyễn Khánh Hưng','20194297','10/02/2001','hung.nk194297@sis.hust')");
            db.setTransactionSuccessful();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            db.endTransaction();
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public Long addStudent(Student student)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put(NAME,student.getFullname());
        values.put(MSSV,student.getMssv());
        values.put(BIRTHDAY,student.getBirthday());
        values.put(EMAIL,student.getEmail());


        Long id= db.insert(TABLE_NAME,null,values);
        db.close();
        return id; //nếu id=-1 là lỗi
    }
    public int updateStudent(Student student)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put(NAME,student.getFullname());
        values.put(MSSV,student.getMssv());
        values.put(BIRTHDAY,student.getBirthday());
        values.put(EMAIL,student.getEmail());



        int succ=db.update(TABLE_NAME,values,ID +"=?",new String[]{String.valueOf(student.getId())});
        if(succ>0) //thành công
        {

        }
        db.close();
        return succ;
    }
    public List<Student> getAllStudent()
    {
        List<Student> list=new ArrayList<>();

        String select="select * from "+TABLE_NAME;
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(select,null);
        cursor.moveToPosition(-1);
        while (cursor.moveToNext())
        {
            Student student=new Student();
            student.setId(cursor.getInt(0));
            student.setFullname(cursor.getString(1));
            student.setMssv(cursor.getString(2));
            student.setBirthday(cursor.getString(3));
            student.setEmail(cursor.getString(4));

            list.add(student);
        }
        db.close();
        return list;
    }
    public int deleteStudent(Student student)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME,ID+"=?",new String[]{String.valueOf(student.getId())});
    }

}
