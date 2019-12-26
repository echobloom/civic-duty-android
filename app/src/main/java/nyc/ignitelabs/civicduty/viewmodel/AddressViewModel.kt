package nyc.ignitelabs.civicduty.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import nyc.ignitelabs.civicduty.ui.AddressDetailsFragmentDirections
import nyc.ignitelabs.civicduty.ui.AddressEditFragmentDirections
import nyc.ignitelabs.civicduty.viewmodel.models.DisplayableError

class AddressViewModel : ViewModel() {
    private val _address = MutableLiveData<String>()
    private val _error = MutableLiveData<DisplayableError>()
    private val _navigate = MutableLiveData<NavDirections>()

    val address : LiveData<String> = _address
    val error : LiveData<DisplayableError> = _error
    val navigate : LiveData<NavDirections> = _navigate

    fun editAddress(){
        _navigate.value = AddressDetailsFragmentDirections.actionMainToEditView()
    }

    fun updatedAddress( address : String ){
        _address.value = address
        _navigate.value = AddressEditFragmentDirections.actionEditViewToMain()
    }
}
