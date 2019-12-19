package nyc.ignitelabs.civicduty.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

import kotlinx.android.synthetic.main.activity_main.*
import nyc.ignitelabs.civicduty.Constants.CODE_REQUEST_ADDRESS
import nyc.ignitelabs.civicduty.R
import nyc.ignitelabs.civicduty.databinding.ActivityMainBinding
import nyc.ignitelabs.civicduty.viewmodel.MainViewModel
import nyc.ignitelabs.civicduty.viewmodel.models.DisplayableError

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = viewModel

        setupSubscriptions()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        viewModel.onActivityResult(requestCode, resultCode, data)
    }

    //region helper methods
    private fun setupSubscriptions() {
        viewModel.editAddress.observe(this, Observer {
            onEditAddress(it)
        })

        viewModel.updateAddress.observe(this, Observer {
            onUpdateAddress(it)
        })

        viewModel.error.observe(this, Observer {
            onError(it)
        })
    }

    private fun onError(error: DisplayableError) {
        when(error.type){
            DisplayableError.ErrorType.GENERAL ->
                Toast.makeText(this, getString(R.string.error_general), Toast.LENGTH_LONG).show()
            DisplayableError.ErrorType.NONE -> return
        }

    }

    private fun onUpdateAddress(newAddress: String) {
        address.text = newAddress
    }

    private fun onEditAddress(address: String) {
        startActivityForResult(
            addressEditIntent(
                this@MainActivity,
                address),
            CODE_REQUEST_ADDRESS)
    }
    //endregion
}
