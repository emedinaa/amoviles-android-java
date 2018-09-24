package com.emedinaa.myfirstapp.storage;

import android.app.Application;
import android.os.AsyncTask;
import com.emedinaa.myfirstapp.model.NoteDbEntity;

import java.util.List;

/**
 * Created by eduardomedina on 27/02/18.
 */

public class NoteRepository {

    private NoteDao noteDao;
    private List<NoteDbEntity> notes;

    /*
        Error
        Caused by: java.lang.IllegalStateException: Cannot access database on the main thread since it may potentially lock the UI for a long period of time.
     */
    public NoteRepository(Application application) {
        NoteDataBase db = NoteDataBase.getDatabase(application);
        noteDao = db.noteDao();
       // notes = noteDao.getAll();
    }

    public void getAllNotes(PopulateCallback populateCallback){
        //return notes = noteDao.getAll();
        /*new PopulateAsyncTask(noteDao, new PopulateCallback() {
            @Override
            public void onSuccess(List<NoteDbEntity> noteEntities) {

            }

            @Override
            public void onFailure(Exception e) {

            }
        }).execute();*/
        new PopulateAsyncTask(noteDao, populateCallback).execute();
    }

    public void add(NoteDbEntity noteDbEntity){
        //noteDao.insert(noteDbEntity);
        new InsertAsyncTask(noteDao).execute(noteDbEntity);
    }

    /**
     * Error
     * Caused by: android.database.sqlite.SQLiteConstraintException: UNIQUE constraint failed: tb_notes.id (code 1555)
     */
    public void addNotes(NoteDbEntity... noteList){
        //noteDao.insertAll(noteList);
        new InsertEntitiesAsyncTask(noteDao).execute(noteList);
    }

    public void update(NoteDbEntity noteDbEntity){
        noteDao.update(noteDbEntity);
    }

    public void delete(NoteDbEntity noteDbEntity){
        noteDao.delete(noteDbEntity);
    }


    //Asynctask ------

    public interface PopulateCallback{
        void onSuccess(List<NoteDbEntity> noteEntities);
        void onFailure(Exception e);
    }

    private static class InsertAsyncTask extends AsyncTask<NoteDbEntity, Void, Void> {

        private final NoteDao mAsyncTaskDao;

        InsertAsyncTask(NoteDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final NoteDbEntity... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class InsertEntitiesAsyncTask extends AsyncTask<NoteDbEntity, Void, Void> {

        private final NoteDao mAsyncTaskDao;

        InsertEntitiesAsyncTask(NoteDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final NoteDbEntity... params) {
            mAsyncTaskDao.insertAll(params);
            return null;
        }
    }

    private static class PopulateAsyncTask extends AsyncTask<Void, Void, List<NoteDbEntity>> {

        private final NoteDao mAsyncTaskDao;
        private final PopulateCallback populateCallback;

        PopulateAsyncTask(NoteDao dao, PopulateCallback populateCallback) {
            mAsyncTaskDao = dao;
            this.populateCallback = populateCallback;
        }

        @Override
        protected List<NoteDbEntity> doInBackground(Void... voids) {
            return mAsyncTaskDao.getAll();
        }

        @Override
        protected void onPostExecute(List<NoteDbEntity> noteEntities) {
            super.onPostExecute(noteEntities);
            if(populateCallback!=null){
                populateCallback.onSuccess(noteEntities);
            }

        }
    }

    /*
     private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
        }
     */
}
