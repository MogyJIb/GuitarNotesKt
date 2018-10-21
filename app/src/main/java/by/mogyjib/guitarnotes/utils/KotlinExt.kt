package by.mogyjib.guitarnotes.utils

import java.util.*


fun IntRange.rand() = Random().nextInt((endInclusive + 1) - start) + start