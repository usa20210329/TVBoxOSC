package com.github.tvbox.osc.cache;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

/**
 * @author pj567
 * @date :2021/1/7
 * @description:
 */
@Dao
public interface VodCollectDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(VodCollect record);

    @Query("select * from vodCollect  order by updateTime desc")
    List<VodCollect> getAll();

    @Query("select * from vodCollect where `id`=:id")
    VodCollect getVodCollect(int id);

    @Query("delete from vodCollect where `id`=:id")
    void delete(int id);

    @Query("select * from vodCollect where `sourceKey`=:sourceKey and `vodId`=:vodId")
    VodCollect getVodCollect(String sourceKey, String vodId);

    @Delete
    int delete(VodCollect record);
    
    @Query("select count(*) from vodRecord")
    int getCount();

    /**
     * 保留最新指定条数, 其他删除.
     * @param size 保留条数
     * @return
     */
    @Query("DELETE FROM vodRecord where id NOT IN (SELECT id FROM vodRecord ORDER BY updateTime desc LIMIT :size)")
    int reserver(int size);
}
