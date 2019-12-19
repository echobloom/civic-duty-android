package nyc.ignitelabs.civicduty.viewmodel

import android.os.Bundle
import android.text.Editable
import android.text.SpannableStringBuilder
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import nyc.ignitelabs.civicduty.Constants

class EditViewModel : ViewModel(){
    private val _addressUpdated = MutableLiveData<String>()
    private val _address = MutableLiveData<SpannableStringBuilder>()

    //region getters
    val addressUpdated : LiveData<String> = _addressUpdated
    val address : LiveData<SpannableStringBuilder> = _address
    //endregion

    //region public methods
    fun address ( extras: Bundle? ){
        _address.value = SpannableStringBuilder(extras?.getString(Constants.KEY_ADDRESS))
    }

    fun updateAddress( address: Editable ){
        _addressUpdated.value = address.toString()
    }
    //endregion
}