package nyc.ignitelabs.civicduty.ui

import android.content.Context
import android.content.Intent
import nyc.ignitelabs.civicduty.Constants

fun  addressEditIntent(context: Context, address: String ) : Intent {
    return Intent(context, EditActivity::class.java).putExtra(Constants.KEY_ADDRESS, address)
}

fun  addressEditSuccessIntent(address: String ) : Intent {
    return Intent().putExtra(Constants.KEY_ADDRESS, address)
}