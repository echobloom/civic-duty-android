package nyc.ignitelabs.civicduty.viewmodel

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import nyc.ignitelabs.civicduty.Constants
import nyc.ignitelabs.civicduty.viewmodel.models.DisplayableError

class MainViewModel : ViewModel() {
    private val _updateAddress = MutableLiveData<String>()
    private val _editAddress = MutableLiveData<String>()
    private val _error = MutableLiveData<DisplayableError>()

    //region getters
    val updateAddress : LiveData<String> = _updateAddress
    val editAddress : LiveData<String> = _editAddress
    val error : LiveData<DisplayableError> = _error
    //endregion

    //region public methods
    fun editAddress( newAddress : CharSequence ){
        _editAddress.value = newAddress.toString()
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        if( resultCode != Activity.RESULT_OK ){
            _error.value = DisplayableError(DisplayableError.ErrorType.GENERAL)

            return
        }

        _error.value = DisplayableError(DisplayableError.ErrorType.NONE)

        when( requestCode ){
            Constants.CODE_REQUEST_ADDRESS ->
                _updateAddress.value = data?.getStringExtra(Constants.KEY_ADDRESS)
        }
    }
    //endregion
}
