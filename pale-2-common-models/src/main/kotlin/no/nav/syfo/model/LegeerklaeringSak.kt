package no.nav.syfo.model

data class LegeerklaeringSak(
    val ReceivedLegeerklaering: ReceivedLegeerklaering,
    val validationResult: ValidationResult
)