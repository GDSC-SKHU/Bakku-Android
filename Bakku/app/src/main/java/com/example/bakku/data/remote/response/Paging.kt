package com.example.bakku.data.remote.response

data class Sort(
    val empty: Boolean,
    val sorted: Boolean,
    val unsorted: Boolean,
)

data class Pageable(
    val sort: Sort,
    val offset: Int,
    val pageNumber: Int,
    val pageSize: Int,
    val paged: Boolean,
    val unpaged: Boolean
)

data class Paging<Content>(
    val content: ArrayList<Content>,
    val pageable: Pageable,
    val size: Int,
    val first: Boolean,
    val last: Boolean,
    val number: Int,
    val sort: Sort,
    val numberOfElements: Int,
    val empty: Boolean,
)
