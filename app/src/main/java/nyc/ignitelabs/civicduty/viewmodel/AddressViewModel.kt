package nyc.ignitelabs.civicduty.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import nyc.ignitelabs.civicduty.viewmodel.models.DisplayableError

class AddressViewModel : ViewModel() {
    private val _addressUpdated = MutableLiveData<String>()
    private val _editAddress = MutableLiveData<String>()
    private val _error = MutableLiveData<DisplayableError>()

    val addressUpdated : LiveData<String> = _addressUpdated
    val editAddress : LiveData<String> = _editAddress
    val error : LiveData<DisplayableError> = _error

    fun editAddress( newAddress : CharSequence ){
        _editAddress.value = newAddress.toString()
    }

    fun addressUpdated(newAddress : CharSequence ){
        _addressUpdated.value = newAddress.toString()
    }
}
