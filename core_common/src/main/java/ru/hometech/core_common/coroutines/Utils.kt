package ru.hometech.core_common.coroutines

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


fun <T, V> Flow<List<T>>.mapIterable(block: (T) -> V): Flow<List<V>> {
    return map { list -> list.map(block) }
}