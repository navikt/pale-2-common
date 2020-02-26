package no.nav.syfo.model

import java.time.LocalDateTime

data class ReceivedLegeerklaering(
    val legeerklaering: Legeerklaering,
    val personNrPasient: String,
    val pasientAktoerId: String,
    val personNrLege: String,
    val navLogId: String,
    val msgId: String,
    val legekontorOrgNr: String?,
    val legekontorHerId: String?,
    val legekontorReshId: String?,
    val legekontorOrgName: String,
    val mottattDato: LocalDateTime,
    /**
     * Full fellesformat as a XML payload, this is only used for infotrygd compat and should be removed in thefuture
     */
    @Deprecated("Only used for infotrygd compat, will be removed in the future")
    val fellesformat: String,
    /**
     * TSS-ident, this is only used for infotrygd compat and should be removed in thefuture
     */
    @Deprecated("Only used for infotrygd compat, will be removed in the future")
    val tssid: String?
)
