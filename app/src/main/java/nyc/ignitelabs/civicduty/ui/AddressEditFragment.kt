package nyc.ignitelabs.civicduty.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import nyc.ignitelabs.civicduty.R
import nyc.ignitelabs.civicduty.databinding.FragmentEditBinding
import nyc.ignitelabs.civicduty.viewmodel.AddressViewModel

class AddressEditFragment : Fragment() {

    private val viewModel: AddressViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val binding: FragmentEditBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_edit, container, false
        )
        val view: View = binding.root

        binding.vm = viewModel

        return view
    }

}