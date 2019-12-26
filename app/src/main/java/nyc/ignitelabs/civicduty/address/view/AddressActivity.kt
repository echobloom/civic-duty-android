package nyc.ignitelabs.civicduty.address.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import nyc.ignitelabs.civicduty.R
import nyc.ignitelabs.civicduty.address.viewmodel.AddressViewModel
import nyc.ignitelabs.civicduty.address.viewmodel.models.DisplayableError

class AddressActivity : AppCompatActivity() {
    private val viewModel: AddressViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_address)

        viewModel.error.observe(this, Observer {
            displayErrorMessage(it)
        })

        viewModel.navigate.observe(this, Observer {
            findNavController(R.id.nav_host_fragment).navigate(it)
        })
    }

    private fun displayErrorMessage(error: DisplayableError) {
        when(error.type){
            DisplayableError.ErrorType.GENERAL ->
                Toast.makeText(this, getString(R.string.error_general), Toast.LENGTH_LONG).show()
            DisplayableError.ErrorType.NONE -> return
        }
    }
}
