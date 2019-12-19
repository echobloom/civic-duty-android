package nyc.ignitelabs.civicduty.viewmodel

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import nyc.ignitelabs.civicduty.Constants

class EditViewModel : ViewModel(){
    private val _addressUpdated = MutableLiveData<String>()
    private val _address = MutableLiveData<String>()

    //region getters
    val addressUpdated : LiveData<String> = _addressUpdated
    val address : LiveData<String> = _address
    //endregion

    //region public methods
    fun address ( extras: Bundle? ){
        _address.value = extras?.getString(Constants.KEY_ADDRESS)
    }

    fun updateAddress( address: String ){
        _addressUpdated.value = address
    }
    //endregion
}