package DATABASE;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.os.AsyncTask;

import java.util.List;

import DAO.wordDao;
import Entity.Word;

public class wordRepo {

    private wordDao mDao;
    private LiveData<List<Word>> mAllwords;
//this is a constructor where we initialize the member variable

    public wordRepo(Application application) {
        //here we create an instance of the database class
        wordRoomDatabase db = wordRoomDatabase.getDatabase(application);
        mDao = db.wordDao(); //here we call on the abstract getter method od wordDao in the databaseclass
        mAllwords = mDao.getAllwords(); //here we call on the Select Query in the Dao class


    }
 //here we create a method to do the Select Query and call it get all word and
 // it will return Livedata type of Data
    public LiveData<List<Word>> getmAllwords(){
        return mAllwords;
    }
//the insert method here helps with the  insert operation
    public void insert (Word word) {
        new insertAsyncTask(mDao).execute(word);
    }

    //here we declare an inner static class with one mwthod
    //the class extends asyncTask to implement the Insert method of the dao class in the background
    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private wordDao mAsyncTaskDao;

        insertAsyncTask(wordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            //the params here is the first table in the word class
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }


}
