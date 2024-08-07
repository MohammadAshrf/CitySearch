package com.example.citysearch.data.repository

import android.content.Context
import com.example.citysearch.android.extensions.parseJsonFile
import com.example.citysearch.data.models.City
import com.example.citysearch.data.structure.Trie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CityRepository @Inject constructor(
    private val context: Context
) {
    private lateinit var cityList: List<City>
    private lateinit var trie: Trie

    suspend fun loadCityData(): Flow<List<City>> = flow {
        cityList = parseJsonFile(context, "cities.json")
        trie = Trie().apply {
            cityList.forEach { insert(it) }
        }
        emit(cityList)
    }.flowOn(Dispatchers.IO)

    fun filterCities(prefix: String): List<City> {
        return if (::trie.isInitialized) {
            trie.search(prefix).sortedBy { it.name }
        } else {
            emptyList()
        }
    }
}