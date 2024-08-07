package com.example.citysearch.domain.interactor

import com.example.citysearch.data.models.City
import com.example.citysearch.data.repository.CityRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CityUC @Inject constructor(
    private val cityRepository: CityRepository
) {
    suspend fun loadCities(): Flow<List<City>> {
        return cityRepository.loadCityData()
    }

    fun filterCities(prefix: String): List<City> {
        return cityRepository.filterCities(prefix)
    }
}