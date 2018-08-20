package com.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import ct7liang.android.databasecreate.dateData.Year;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "YEAR".
*/
public class YearDao extends AbstractDao<Year, Long> {

    public static final String TABLENAME = "YEAR";

    /**
     * Properties of entity Year.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Year = new Property(1, int.class, "year", false, "YEAR");
        public final static Property Days = new Property(2, int.class, "days", false, "DAYS");
        public final static Property Month = new Property(3, int.class, "month", false, "MONTH");
        public final static Property LeapMonth = new Property(4, int.class, "leapMonth", false, "LEAP_MONTH");
        public final static Property MonthType = new Property(5, String.class, "monthType", false, "MONTH_TYPE");
        public final static Property LeapMonthDays = new Property(6, int.class, "leapMonthDays", false, "LEAP_MONTH_DAYS");
    }


    public YearDao(DaoConfig config) {
        super(config);
    }
    
    public YearDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"YEAR\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"YEAR\" INTEGER NOT NULL ," + // 1: year
                "\"DAYS\" INTEGER NOT NULL ," + // 2: days
                "\"MONTH\" INTEGER NOT NULL ," + // 3: month
                "\"LEAP_MONTH\" INTEGER NOT NULL ," + // 4: leapMonth
                "\"MONTH_TYPE\" TEXT NOT NULL ," + // 5: monthType
                "\"LEAP_MONTH_DAYS\" INTEGER NOT NULL );"); // 6: leapMonthDays
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"YEAR\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Year entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getYear());
        stmt.bindLong(3, entity.getDays());
        stmt.bindLong(4, entity.getMonth());
        stmt.bindLong(5, entity.getLeapMonth());
        stmt.bindString(6, entity.getMonthType());
        stmt.bindLong(7, entity.getLeapMonthDays());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Year entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getYear());
        stmt.bindLong(3, entity.getDays());
        stmt.bindLong(4, entity.getMonth());
        stmt.bindLong(5, entity.getLeapMonth());
        stmt.bindString(6, entity.getMonthType());
        stmt.bindLong(7, entity.getLeapMonthDays());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Year readEntity(Cursor cursor, int offset) {
        Year entity = new Year( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // year
            cursor.getInt(offset + 2), // days
            cursor.getInt(offset + 3), // month
            cursor.getInt(offset + 4), // leapMonth
            cursor.getString(offset + 5), // monthType
            cursor.getInt(offset + 6) // leapMonthDays
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Year entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setYear(cursor.getInt(offset + 1));
        entity.setDays(cursor.getInt(offset + 2));
        entity.setMonth(cursor.getInt(offset + 3));
        entity.setLeapMonth(cursor.getInt(offset + 4));
        entity.setMonthType(cursor.getString(offset + 5));
        entity.setLeapMonthDays(cursor.getInt(offset + 6));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Year entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Year entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Year entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}