package com.zxin.zxinlib.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.zxin.zxinlib.entity.HttpUrl;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "HTTP_URL".
*/
public class HttpUrlDao extends AbstractDao<HttpUrl, Long> {

    public static final String TABLENAME = "HTTP_URL";

    /**
     * Properties of entity HttpUrl.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property CreateTimer = new Property(1, String.class, "createTimer", false, "CREATE_TIMER");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property Lable = new Property(3, String.class, "lable", false, "LABLE");
        public final static Property Url = new Property(4, String.class, "url", false, "URL");
        public final static Property LastTime = new Property(5, String.class, "lastTime", false, "LAST_TIME");
        public final static Property Times = new Property(6, long.class, "times", false, "TIMES");
        public final static Property OrderNum = new Property(7, int.class, "orderNum", false, "ORDER_NUM");
        public final static Property IsEffective = new Property(8, int.class, "isEffective", false, "IS_EFFECTIVE");
        public final static Property ModifyTime = new Property(9, String.class, "modifyTime", false, "MODIFY_TIME");
    }


    public HttpUrlDao(DaoConfig config) {
        super(config);
    }
    
    public HttpUrlDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"HTTP_URL\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"CREATE_TIMER\" TEXT," + // 1: createTimer
                "\"NAME\" TEXT," + // 2: name
                "\"LABLE\" TEXT," + // 3: lable
                "\"URL\" TEXT," + // 4: url
                "\"LAST_TIME\" TEXT," + // 5: lastTime
                "\"TIMES\" INTEGER NOT NULL ," + // 6: times
                "\"ORDER_NUM\" INTEGER NOT NULL ," + // 7: orderNum
                "\"IS_EFFECTIVE\" INTEGER NOT NULL ," + // 8: isEffective
                "\"MODIFY_TIME\" TEXT);"); // 9: modifyTime
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"HTTP_URL\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, HttpUrl entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String createTimer = entity.getCreateTimer();
        if (createTimer != null) {
            stmt.bindString(2, createTimer);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String lable = entity.getLable();
        if (lable != null) {
            stmt.bindString(4, lable);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(5, url);
        }
 
        String lastTime = entity.getLastTime();
        if (lastTime != null) {
            stmt.bindString(6, lastTime);
        }
        stmt.bindLong(7, entity.getTimes());
        stmt.bindLong(8, entity.getOrderNum());
        stmt.bindLong(9, entity.getIsEffective());
 
        String modifyTime = entity.getModifyTime();
        if (modifyTime != null) {
            stmt.bindString(10, modifyTime);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, HttpUrl entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String createTimer = entity.getCreateTimer();
        if (createTimer != null) {
            stmt.bindString(2, createTimer);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String lable = entity.getLable();
        if (lable != null) {
            stmt.bindString(4, lable);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(5, url);
        }
 
        String lastTime = entity.getLastTime();
        if (lastTime != null) {
            stmt.bindString(6, lastTime);
        }
        stmt.bindLong(7, entity.getTimes());
        stmt.bindLong(8, entity.getOrderNum());
        stmt.bindLong(9, entity.getIsEffective());
 
        String modifyTime = entity.getModifyTime();
        if (modifyTime != null) {
            stmt.bindString(10, modifyTime);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public HttpUrl readEntity(Cursor cursor, int offset) {
        HttpUrl entity = new HttpUrl( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // createTimer
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // lable
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // url
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // lastTime
            cursor.getLong(offset + 6), // times
            cursor.getInt(offset + 7), // orderNum
            cursor.getInt(offset + 8), // isEffective
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9) // modifyTime
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, HttpUrl entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCreateTimer(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setLable(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setUrl(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setLastTime(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setTimes(cursor.getLong(offset + 6));
        entity.setOrderNum(cursor.getInt(offset + 7));
        entity.setIsEffective(cursor.getInt(offset + 8));
        entity.setModifyTime(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(HttpUrl entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(HttpUrl entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(HttpUrl entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
