package com.example.webapi.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.webapi.network.SimpleServiceApi
import com.example.webapi.network.MarsApiFilter
import com.example.webapi.network.KriptoValuta
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

enum class MarsApiStatus { LOADING, ERROR, DONE }

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<MarsApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<MarsApiStatus>
        get() = _status

    // Internally, we use a MutableLiveData, because we will be updating the List of MarsProperty
    // with new values
    private val _properties = MutableLiveData<List<KriptoValuta>>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val properties: LiveData<List<KriptoValuta>>
        get() = _properties

    // LiveData to handle navigation to the selected property
    private val _navigateToSelectedProperty = MutableLiveData<KriptoValuta>()
    val navigateToSelectedProperty: LiveData<KriptoValuta>
        get() = _navigateToSelectedProperty


    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     */
    init {
        getMarsRealEstateProperties(MarsApiFilter.SHOW_ALL)
    }

    /**
     * Gets filtered Mars real estate property information from the Mars API Retrofit service and
     * updates the [MarsProperty] [List] and [MarsApiStatus] [LiveData]. The Retrofit service
     * returns a coroutine Deferred, which we await to get the result of the transaction.
     * @param filter the [MarsApiFilter] that is sent as part of the web server request
     */
    private fun getMarsRealEstateProperties(filter: MarsApiFilter) {
        viewModelScope.launch {
            _status.value = MarsApiStatus.LOADING
            try {
                _properties.value = SimpleServiceApi.retrofitService.getProperties(filter.value)
                _status.value = MarsApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MarsApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }


}