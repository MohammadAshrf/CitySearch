package com.example.citysearch.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.citysearch.data.models.City
import com.example.citysearch.domain.interactor.CityUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityViewModel @Inject constructor(
    private val cityUseCase: CityUC
) : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _cities = MutableStateFlow<List<City>>(emptyList())
    val cities: StateFlow<List<City>> = _cities

    private val _filteredCities = MutableStateFlow<List<City>>(emptyList())
    val filteredCities: StateFlow<List<City>> = _filteredCities

    init {
        loadCities()
    }

    private fun loadCities() {
        viewModelScope.launch {
            _isLoading.value = true
            cityUseCase.loadCities()
                .catch { e ->
                    e.printStackTrace()
                    _isLoading.value = false
                }
                .collect { cityList ->
                    _cities.value = cityList
                    _isLoading.value = false
                }
        }
    }

    fun filterCities(prefix: String) {
        _filteredCities.value = cityUseCase.filterCities(prefix)
    }
}