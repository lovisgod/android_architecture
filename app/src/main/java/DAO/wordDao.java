package DAO;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import Entity.Word;

@Dao
public interface wordDao {

    @Insert
    void insert(Word word); //this does work of inserting into table Word

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>>getAllwords();//here we get all word from the database and returna Livedata that has List datatype






}
