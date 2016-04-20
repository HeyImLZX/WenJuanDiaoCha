package com.ice.wenjuandiaocha.Application;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ice.greendao.DaoMaster;
import com.ice.greendao.DaoSession;
import com.ice.greendao.PersonInfoDao;
import com.ice.greendao.QuestionResult;
import com.ice.greendao.QuestionResultDao;
import com.ice.greendao.SimpleInfo;
import com.ice.greendao.SimpleInfoDao;

/**
 * Created by ice on 2016/3/12.
 */
public class MyApplication extends Application {
    private static Context context;

    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private static DaoSession daoSession;
    private static Cursor cursor;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();


        // 官方推荐将获取 DaoMaster 对象的方法放到 Application 层，这样将避免多次创建生成 Session 对象
        setupDatabase();
        // 获取 NoteDao 对象
        // getPersonInfoDao();

        cursor = db.query(getPersonInfoDao().getTablename(), getPersonInfoDao().getAllColumns(), null, null, null, null, null);

    }

    public static Context getContext() {
        return context;
    }

    private void setupDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        db = helper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public static PersonInfoDao getPersonInfoDao() {
        return daoSession.getPersonInfoDao();
    }

    public static SimpleInfoDao getSimpleInfoDao() {
        return daoSession.getSimpleInfoDao();
    }

    public static QuestionResultDao getQuestionResultDao() {
        return daoSession.getQuestionResultDao();
    }

    public static Cursor getCursor() {
        return cursor;
    }


    public static void insertDao(String timeStamp, String personId, String tableId, String blank, String result, String score, String TAG) {


        // 插入操作，简单到只要你创建一个 Java 对象
        QuestionResult questionResult = new QuestionResult(null
                , timeStamp
                , personId
                , tableId
                , blank
                , result
                , score
        );
        getQuestionResultDao().insert(questionResult);
        Log.d(TAG, "Inserted new note, ID: " + questionResult.getId());
        //   cursor.requery();
    }

}
