package nyc.ignitelabs.civicduty.address.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import nyc.ignitelabs.civicduty.R
import nyc.ignitelabs.civicduty.databinding.FragmentAddressDetailsBinding
import nyc.ignitelabs.civicduty.address.viewmodel.AddressViewModel

class AddressDetailsFragment : Fragment() {
    val vm: AddressViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentAddressDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_address_details, container, false
        )

        binding.vm = vm

        return binding.root
    }
}
