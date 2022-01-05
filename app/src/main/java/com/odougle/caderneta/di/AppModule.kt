package com.odougle.caderneta.di

import android.app.Application
import androidx.room.Room
import com.odougle.caderneta.features.data.data_source.Database
import com.odougle.caderneta.features.data.repository.DatabaseRepositoryImpl
import com.odougle.caderneta.features.domain.repository.DatabaseRepository
import com.odougle.caderneta.features.domain.use_case.CadernetaUseCases
import com.odougle.caderneta.features.domain.use_case.goal.AddGoalUseCase
import com.odougle.caderneta.features.domain.use_case.goal.DeleteGoalUseCase
import com.odougle.caderneta.features.domain.use_case.goal.GetGoalUseCase
import com.odougle.caderneta.features.domain.use_case.goal.GetGoalsUseCase
import com.odougle.caderneta.features.domain.use_case.income.AddIncomeUseCase
import com.odougle.caderneta.features.domain.use_case.income.DeleteIncomeUseCase
import com.odougle.caderneta.features.domain.use_case.income.GetIncomeUseCase
import com.odougle.caderneta.features.domain.use_case.income.GetIncomesUseCase
import com.odougle.caderneta.features.domain.use_case.outlay.AddOutlayUseCase
import com.odougle.caderneta.features.domain.use_case.outlay.DeleteOutlayUseCase
import com.odougle.caderneta.features.domain.use_case.outlay.GetOutlayUseCase
import com.odougle.caderneta.features.domain.use_case.outlay.GetOutlaysUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): Database {
        return Room.databaseBuilder(
            app,
            Database::class.java,
            Database.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideDatabaseRepository(db: Database): DatabaseRepository {
        return DatabaseRepositoryImpl(db.databaseDao)
    }

    @Provides
    @Singleton
    fun provideCadernetaUseCases(repository: DatabaseRepository): CadernetaUseCases {
        return CadernetaUseCases(
            addGoalUseCase = AddGoalUseCase(repository),
            addIncomeUseCase = AddIncomeUseCase(repository),
            addOutlayUseCase = AddOutlayUseCase(repository),
            deleteGoalUseCase = DeleteGoalUseCase(repository),
            deleteIncomeUseCase = DeleteIncomeUseCase(repository),
            deleteOutlayUseCase = DeleteOutlayUseCase(repository),
            getGoalUseCase = GetGoalUseCase(repository),
            getGoalsUseCase = GetGoalsUseCase(repository),
            getIncomeUseCase = GetIncomeUseCase(repository),
            getIncomesUseCase = GetIncomesUseCase(repository),
            getOutlayUseCase = GetOutlayUseCase(repository),
            getOutlaysUseCase = GetOutlaysUseCase(repository)
        )
    }
}