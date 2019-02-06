package ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import DATABASE.wordRepo;
import Entity.Word;

public class wordViewModel extends AndroidViewModel {

    private wordRepo mRepository;

    private LiveData<List<Word>> mAllWords;


    public wordViewModel(@NonNull Application application) {
        super(application);

        mRepository = new wordRepo(application);
        mAllWords = mRepository.getmAllwords();
    }

    public LiveData<List<Word>> getAllWords() { return mAllWords; }

    public void insert(Word word) { mRepository.insert(word); }
}
