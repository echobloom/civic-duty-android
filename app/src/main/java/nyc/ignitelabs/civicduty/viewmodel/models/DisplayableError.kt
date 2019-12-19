package nyc.ignitelabs.civicduty.viewmodel.models

class DisplayableError(val type: ErrorType, val message: String? = null){
    enum class ErrorType{
        NONE,
        GENERAL
    }
}