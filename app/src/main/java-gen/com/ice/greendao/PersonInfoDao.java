package com.ice.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.ice.greendao.PersonInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "PERSON_INFO".
 */
public class PersonInfoDao extends AbstractDao<PersonInfo, Long> {

    public static final String TABLENAME = "PERSON_INFO";

    /**
     * Properties of entity PersonInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Sex = new Property(2, String.class, "sex", false, "SEX");
        public final static Property Birthday = new Property(3, String.class, "birthday", false, "BIRTHDAY");
        public final static Property Height = new Property(4, String.class, "height", false, "HEIGHT");
        public final static Property Weight = new Property(5, String.class, "weight", false, "WEIGHT");
        public final static Property Provider = new Property(6, String.class, "provider", false, "PROVIDER");
        public final static Property Relation = new Property(7, String.class, "relation", false, "RELATION");
        public final static Property Religion = new Property(8, String.class, "religion", false, "RELIGION");
        public final static Property Idcard = new Property(9, String.class, "idcard", false, "IDCARD");
        public final static Property Education = new Property(10, String.class, "education", false, "EDUCATION");
        public final static Property Occupation = new Property(11, String.class, "occupation", false, "OCCUPATION");
        public final static Property Marriage = new Property(12, String.class, "marriage", false, "MARRIAGE");
        public final static Property Payment = new Property(13, String.class, "payment", false, "PAYMENT");
        public final static Property Home = new Property(14, String.class, "home", false, "HOME");
        public final static Property Economy = new Property(15, String.class, "economy", false, "ECONOMY");
        public final static Property Oldhelp = new Property(16, String.class, "oldhelp", false, "OLDHELP");
        public final static Property Accident = new Property(17, String.class, "accident", false, "ACCIDENT");
        public final static Property Wish1 = new Property(18, String.class, "wish1", false, "WISH1");
        public final static Property Wish2 = new Property(19, String.class, "wish2", false, "WISH2");
    }

    ;


    public PersonInfoDao(DaoConfig config) {
        super(config);
    }

    public PersonInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PERSON_INFO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"NAME\" TEXT NOT NULL ," + // 1: name
                "\"SEX\" TEXT," + // 2: sex
                "\"BIRTHDAY\" TEXT," + // 3: birthday
                "\"HEIGHT\" TEXT," + // 4: height
                "\"WEIGHT\" TEXT," + // 5: weight
                "\"PROVIDER\" TEXT," + // 6: provider
                "\"RELATION\" TEXT," + // 7: relation
                "\"RELIGION\" TEXT," + // 8: religion
                "\"IDCARD\" TEXT," + // 9: idcard
                "\"EDUCATION\" TEXT," + // 10: education
                "\"OCCUPATION\" TEXT," + // 11: occupation
                "\"MARRIAGE\" TEXT," + // 12: marriage
                "\"PAYMENT\" TEXT," + // 13: payment
                "\"HOME\" TEXT," + // 14: home
                "\"ECONOMY\" TEXT," + // 15: economy
                "\"OLDHELP\" TEXT," + // 16: oldhelp
                "\"ACCIDENT\" TEXT," + // 17: accident
                "\"WISH1\" TEXT," + // 18: wish1
                "\"WISH2\" TEXT);"); // 19: wish2
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PERSON_INFO\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, PersonInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(3, sex);
        }
 
        String birthday = entity.getBirthday();
        if (birthday != null) {
            stmt.bindString(4, birthday);
        }
 
        String height = entity.getHeight();
        if (height != null) {
            stmt.bindString(5, height);
        }
 
        String weight = entity.getWeight();
        if (weight != null) {
            stmt.bindString(6, weight);
        }
 
        String provider = entity.getProvider();
        if (provider != null) {
            stmt.bindString(7, provider);
        }
 
        String relation = entity.getRelation();
        if (relation != null) {
            stmt.bindString(8, relation);
        }
 
        String religion = entity.getReligion();
        if (religion != null) {
            stmt.bindString(9, religion);
        }
 
        String idcard = entity.getIdcard();
        if (idcard != null) {
            stmt.bindString(10, idcard);
        }
 
        String education = entity.getEducation();
        if (education != null) {
            stmt.bindString(11, education);
        }
 
        String occupation = entity.getOccupation();
        if (occupation != null) {
            stmt.bindString(12, occupation);
        }
 
        String marriage = entity.getMarriage();
        if (marriage != null) {
            stmt.bindString(13, marriage);
        }
 
        String payment = entity.getPayment();
        if (payment != null) {
            stmt.bindString(14, payment);
        }
 
        String home = entity.getHome();
        if (home != null) {
            stmt.bindString(15, home);
        }
 
        String economy = entity.getEconomy();
        if (economy != null) {
            stmt.bindString(16, economy);
        }
 
        String oldhelp = entity.getOldhelp();
        if (oldhelp != null) {
            stmt.bindString(17, oldhelp);
        }
 
        String accident = entity.getAccident();
        if (accident != null) {
            stmt.bindString(18, accident);
        }
 
        String wish1 = entity.getWish1();
        if (wish1 != null) {
            stmt.bindString(19, wish1);
        }
 
        String wish2 = entity.getWish2();
        if (wish2 != null) {
            stmt.bindString(20, wish2);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }

    /** @inheritdoc */
    @Override
    public PersonInfo readEntity(Cursor cursor, int offset) {
        PersonInfo entity = new PersonInfo( //
                cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
                cursor.getString(offset + 1), // name
                cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // sex
                cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // birthday
                cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // height
                cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // weight
                cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // provider
                cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // relation
                cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // religion
                cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // idcard
                cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // education
                cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // occupation
                cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // marriage
                cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // payment
                cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // home
                cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // economy
                cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // oldhelp
                cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // accident
                cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // wish1
                cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19) // wish2
        );
        return entity;
    }

    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, PersonInfo entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setSex(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setBirthday(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setHeight(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setWeight(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setProvider(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setRelation(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setReligion(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setIdcard(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setEducation(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setOccupation(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setMarriage(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setPayment(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setHome(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setEconomy(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setOldhelp(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setAccident(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setWish1(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setWish2(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
    }

    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(PersonInfo entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }

    /** @inheritdoc */
    @Override
    public Long getKey(PersonInfo entity) {
        if (entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /**
     * @inheritdoc
     */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}