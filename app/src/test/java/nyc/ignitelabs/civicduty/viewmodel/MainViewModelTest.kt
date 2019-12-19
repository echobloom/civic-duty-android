package nyc.ignitelabs.civicduty.viewmodel

import android.app.Activity
import android.content.Intent
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import nyc.ignitelabs.civicduty.Constants
import nyc.ignitelabs.civicduty.testLifecycleOwner
import nyc.ignitelabs.civicduty.viewmodel.models.DisplayableError
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

    private var viewModel: MainViewModel = MainViewModel()
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

    @Test
    fun onActivityResult_success() {
        viewModel.updateAddress.observe(testLifecycleOwner(), Observer {
            assert(it == address)
        })

        viewModel.error.observe(testLifecycleOwner(), Observer {
            assert(it.type == DisplayableError.ErrorType.NONE) { "shouldn't be an error when successful" }
        })

        viewModel.onActivityResult(Constants.CODE_REQUEST_ADDRESS, Activity.RESULT_OK, editIntent )
    }

    @Test
    fun onActivityResult_fail() {
        viewModel.updateAddress.observe(testLifecycleOwner(), Observer {
            assert(false) { "shouldn't update address if result wasn't successful" }
        })
        viewModel.error.observe(testLifecycleOwner(), Observer {
            assert(it.type == DisplayableError.ErrorType.GENERAL) { "error should be of correct type" }
        })

        viewModel.onActivityResult(Constants.CODE_REQUEST_ADDRESS, Activity.RESULT_CANCELED, editIntent )
    }
}