package nyc.ignitelabs.civicduty.address.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import nyc.ignitelabs.civicduty.R
import nyc.ignitelabs.civicduty.databinding.FragmentAddressEditBinding
import nyc.ignitelabs.civicduty.address.viewmodel.AddressViewModel

class AddressEditFragment : Fragment() {

    private val viewModel: AddressViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val binding: FragmentAddressEditBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_address_edit, container, false
        )
        val view: View = binding.root

        binding.vm = viewModel

        return view
    }
}