/*
 * Copyright 2014-2020 JetBrains s.r.o and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package io.ktor.client.utils

import io.ktor.util.*
import io.ktor.utils.io.*

/**
 * If the exception contains cause that differs from [CancellationException] returns it otherwise returns itself.
 */
@InternalAPI
actual fun Throwable.unwrapCancellationException(): Throwable {
    var exception: Throwable? = this
    while (exception is CancellationException) {
        exception = exception.cause
    }

    return exception ?: this
}
