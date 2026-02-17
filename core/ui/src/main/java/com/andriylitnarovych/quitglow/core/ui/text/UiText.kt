package com.andriylitnarovych.quitglow.core.ui.text

import android.content.Context
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes

/**
 * Represents text that can be either dynamic or resource-based.
 *
 * This abstraction allows UI models to remain independent
 * from Android framework classes.
 */
sealed class UiText {

    /**
     * Plain dynamic text.
     */
    data class Dynamic(
        val value: String
    ) : UiText()

    /**
     * String resource reference.
     */
    data class Resource(
        @StringRes val id: Int,
        val args: List<Any> = emptyList()
    ) : UiText()

    /**
     * Plural string resource reference.
     */
    data class Plural(
        @PluralsRes val id: Int,
        val quantity: Int,
        val args: List<Any> = emptyList()
    ) : UiText()

    /**
     * Resolves the text to a string using the provided [context].
     */
    fun asString(context: Context): String = when (this) {
        is Dynamic -> value
        is Resource -> context.getString(id, *args.toTypedArray())
        is Plural -> context.resources.getQuantityString(
            id,
            quantity,
            *args.toTypedArray()
        )
    }
}