package nyc.ignitelabs.civicduty.viewmodel

import android.os.Bundle
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import nyc.ignitelabs.civicduty.Constants
import nyc.ignitelabs.civicduty.testLifecycleOwner
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class EditViewModelTest {
    private val address: String = "1234 Awesome St, Great City, Best State"

    @JvmField
    @Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private var viewModel: EditViewModel = EditViewModel()

    private var extras : Bundle = mock(Bundle::class.java)

    @Test
    fun address() {
        viewModel.address.observe(testLifecycleOwner(), Observer {
            assert(it == address) { "address should match" }
        })

        `when`(extras.getString(Constants.KEY_ADDRESS)).thenReturn(address)

        viewModel.address(extras)
    }

    @Test
    fun updateAddress() {
        viewModel.addressUpdated.observe(testLifecycleOwner(), Observer {
            assert(it.toString() == address) { "address should match" }
        })

        viewModel.updateAddress( address )
    }
}