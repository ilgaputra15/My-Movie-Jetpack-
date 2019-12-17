package com.gyosanila.mymoviejetpack.features.utils

import androidx.paging.PagedList
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock


/**
 * Created by ilgaputra15
 * on Sunday, 01/12/2019 14:58
 * Division Mobile - PT.Homecareindo Global Medika
 **/

fun <T> mockPagedList(list: List<T>): PagedList<T> {
    val pagedList = mock(PagedList::class.java) as PagedList<T>
    `when`(pagedList[anyInt()]).then { invocation ->
        val index = invocation.arguments.first() as Int
        list[index]
    }
    `when`(pagedList.size).thenReturn(list.size)
    return pagedList
}