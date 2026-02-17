package com.andriylitnarovych.quitglow.core.domain.container

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Represents a state container for asynchronous data loading.
 *
 * Used to model UI state in a predictable and explicit way.
 *
 * @param T the type of wrapped value
 */
sealed class Container<out T> {

    /**
     * Indicates that the data is currently being loaded.
     */
    data object Pending : Container<Nothing>()

    /**
     * Indicates that loading failed with a [throwable].
     */
    data class Error(
        val throwable: Throwable
    ) : Container<Nothing>()

    /**
     * Indicates successful loading with a [value].
     */
    data class Success<T>(
        val value: T
    ) : Container<T>()
}

/**
 * Maps the wrapped value inside [Container.Success] using [mapper].
 *
 * Other states are propagated unchanged.
 */
inline fun <T, R> Container<T>.map(
    mapper: (T) -> R
): Container<R> = when (this) {
    is Container.Error -> this
    Container.Pending -> Container.Pending
    is Container.Success -> Container.Success(mapper(value))
}

/**
 * Executes [block] if this container is [Container.Success].
 */
inline fun <T> Container<T>.onSuccess(
    block: (T) -> Unit
): Container<T> {
    if (this is Container.Success) block(value)
    return this
}

/**
 * Executes [block] if this container is [Container.Error].
 */
inline fun <T> Container<T>.onError(
    block: (Throwable) -> Unit
): Container<T> {
    if (this is Container.Error) block(throwable)
    return this
}

/**
 * Maps a [Flow] of containers using [mapper].
 */
inline fun <T, R> Flow<Container<T>>.containerMap(
    crossinline mapper: (T) -> R
): Flow<Container<R>> = map { it.map(mapper) }

/**
 * Maps list values inside a container.
 */
inline fun <T, R> Container<List<T>>.mapList(
    mapper: (T) -> R
): Container<List<R>> = map { list -> list.map(mapper) }

/**
 * Maps list values inside a flow of containers.
 */
inline fun <T, R> Flow<Container<List<T>>>.containerMapList(
    crossinline mapper: (T) -> R
): Flow<Container<List<R>>> = map { it.mapList(mapper) }