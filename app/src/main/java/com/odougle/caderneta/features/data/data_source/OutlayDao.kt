package com.odougle.caderneta.features.data.data_source

import androidx.room.*
import com.odougle.caderneta.features.domain.model.Outlay
import kotlinx.coroutines.flow.Flow

@Dao
interface OutlayDao {

    @Query("SELECT * FROM outlay")
    suspend fun getOutlays() : Flow<List<Outlay>>

    @Query("SELECT * FROM outlay WHERE id = :id")
    suspend fun getOutlayById(id: Int) : Outlay?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOutlay(outlay: Outlay)

    @Delete
    suspend fun deleteOutlay(outlay: Outlay)
}