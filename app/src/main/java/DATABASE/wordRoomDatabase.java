package DATABASE;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import DAO.wordDao;
import Entity.Word;

@Database(entities = {Word.class}, version = 1) //this declares that the class is a database and also specifiy the entities
public abstract class wordRoomDatabase extends RoomDatabase {

    public abstract wordDao wordDao(); //this is an abstract getter method for the dao class

   //here we make the class a singleton
    private static volatile wordRoomDatabase INSTANCE;

    static wordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (wordRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    //the databasebuilder class takes in the context, the database class, and the name of database
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            wordRoomDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
