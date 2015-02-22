package info.unamuno.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by annie on 2/22/15.
 * Adapted from http://www.vogella.com/tutorials/AndroidSQLite/article.html
 */
public class DataSource {

        // Database fields
        private SQLiteDatabase database;
        private Data dbHelper;
        private String[] allColumns = { Data.COLUMN_ID,
                Data.COLUMN_COMMENT };

        public DataSource(Context context) {
            dbHelper = new Data(context);
        }

        public void open() throws SQLException {
            database = dbHelper.getWritableDatabase();
        }

        public void close() {
            dbHelper.close();
        }

        public Comment createComment(String comment) {
            ContentValues values = new ContentValues();
            values.put(Data.COLUMN_COMMENT, comment);
            long insertId = database.insert(Data.TABLE_COMMENTS, null,
                    values);
            Cursor cursor = database.query(Data.TABLE_COMMENTS,
                    allColumns, Data.COLUMN_ID + " = " + insertId, null,
                    null, null, null);
            cursor.moveToFirst();
            Comment newComment = cursorToComment(cursor);
            cursor.close();
            return newComment;
        }

        public void deleteComment(Comment comment) {
            long id = comment.getId();
            System.out.println("Comment deleted with id: " + id);
            database.delete(Data.TABLE_COMMENTS, Data.COLUMN_ID
                    + " = " + id, null);
        }

        public List<Comment> getAllComments() {
            List<Comment> comments = new ArrayList<Comment>();

            Cursor cursor = database.query(Data.TABLE_COMMENTS,
                    allColumns, null, null, null, null, null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Comment comment = cursorToComment(cursor);
                comments.add(comment);
                cursor.moveToNext();
            }
            // make sure to close the cursor
            cursor.close();
            return comments;
        }

        private Comment cursorToComment(Cursor cursor) {
            Comment comment = new Comment();
            comment.setId(cursor.getLong(0));
            comment.setComment(cursor.getString(1));
            return comment;
        }
}
