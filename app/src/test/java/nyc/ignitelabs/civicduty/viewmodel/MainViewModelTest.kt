package nyc.ignitelabs.civicduty.viewmodel

import android.content.Intent
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import nyc.ignitelabs.civicduty.Constants
import nyc.ignitelabs.civicduty.testLifecycleOwner
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock


class MainViewModelTest {
    private val address : String = "1234 Awesome St, Great City, Best State"

    @JvmField
    @Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private var viewModel: AddressViewModel = AddressViewModel()
    private var editIntent: Intent = mock(Intent::class.java)


    @Before
    fun setup() {
       `when`(editIntent.getStringExtra( Constants.KEY_ADDRESS )).thenReturn(address)
    }

    @Test
    fun editAddress() {
        viewModel.editAddress.observe(testLifecycleOwner(), Observer {
            assert(it == address)
        })

        viewModel.editAddress(address)
    }
}