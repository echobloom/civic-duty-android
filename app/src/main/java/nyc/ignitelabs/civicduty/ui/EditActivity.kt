package nyc.ignitelabs.civicduty.ui

import android.os.Bundle
import android.text.Editable
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_edit.*
import nyc.ignitelabs.civicduty.R
import nyc.ignitelabs.civicduty.databinding.ActivityEditBinding
import nyc.ignitelabs.civicduty.viewmodel.EditViewModel



class EditActivity : AppCompatActivity() {

    private val viewModel: EditViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityEditBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_edit)

        binding.viewModel = viewModel

        setupSubscriptions()
    }

    private fun setupSubscriptions () {
        viewModel.addressUpdated.observe(this, Observer {
            onAddressUpdated(it)
        })

        viewModel.address.observe(this, Observer {
            onAddressSet(it)
        })

        viewModel.address( intent.extras )
    }

    private fun onAddressSet( address: Editable ){
        address_edit.text = address
    }

    private fun onAddressUpdated( address : String ){
        setResult(RESULT_OK,
            addressEditSuccessIntent(address)
        )
        this@EditActivity.finish()
    }
}