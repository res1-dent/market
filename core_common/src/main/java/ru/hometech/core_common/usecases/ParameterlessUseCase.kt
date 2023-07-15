package ru.hometech.core_common.usecases

import kotlinx.coroutines.flow.Flow

interface ParameterlessUseCase<Result> {
    suspend operator fun invoke(): Result
}

interface UseCase<Params, Result> {
    suspend operator fun invoke(params: Params): Result
}

interface ParameterlessUseCaseFlow<Result> {
    operator fun invoke(): Flow<Result>
}