package nyc.ignitelabs.civicduty.address.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import nyc.ignitelabs.civicduty.R
import nyc.ignitelabs.civicduty.testLifecycleOwner
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule


class AddressViewModelTest {
    private val address : String = "1234 Awesome St, Great City, Best State"

    @JvmField
    @Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private var viewModel: AddressViewModel = AddressViewModel()

    @Test
    fun editAddress() {
        viewModel.navigate.observe(testLifecycleOwner(), Observer {
            assert( it.actionId == R.id.action_main_to_editView ) { "when editing address, should navigate to Edit" }
        })

        viewModel.editAddress()
    }

    @Test
    fun updatedAddress(){
        viewModel.navigate.observe(testLifecycleOwner(), Observer {
            assert( it.actionId == R.id.action_editView_to_main) { "when updated address, should navigate back to Details" }
        })

        viewModel.address.observe(testLifecycleOwner(), Observer {
            assert(it == address) { "when updated address, value should change" }
        })

        viewModel.updatedAddress( address )
    }
}