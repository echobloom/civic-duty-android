package nyc.ignitelabs.civicduty.address.viewmodel.models

class DisplayableError(val type: ErrorType, val message: String? = null){
    enum class ErrorType{
        NONE,
        GENERAL
    }
}