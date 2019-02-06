package Entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "word_table") //this declares a table with name word_table
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWorld;

    public Word(String mWorld) {
        this.mWorld = mWorld;
    }

    public String getWorld() {
        return mWorld;
    }

    public void setWorld(String mWorld) {
        this.mWorld = mWorld;
    }
}
