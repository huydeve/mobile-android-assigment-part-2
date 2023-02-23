package com.example.shop.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.ClipData;
import android.content.Context;
import com.example.shop.entity.Product;
import dao.ProductDao;

@Database(entities = {Product.class}, version = 1)
public abstract class ProductDatabase  extends RoomDatabase {

    private static ProductDatabase INSTANCE;
    public abstract ProductDao getProductsDAO();
    public static ProductDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.inMemoryDatabaseBuilder(context.getApplicationContext(), ProductDatabase.class)
                    // To simplify the codelab, allow queries on the main thread.
                    // Don't do this on a real app! See PersistenceBasicSample for an example.
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
    public static void destroyInstance() {
        INSTANCE = null;
    }


}
