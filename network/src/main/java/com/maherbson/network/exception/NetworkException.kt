package com.maherbson.network.exception

import java.io.IOException

private const val NO_INTERNET_CONNECTION = "No Connection"

class NetworkException(
    override val message: String = NO_INTERNET_CONNECTION
) : IOException()
