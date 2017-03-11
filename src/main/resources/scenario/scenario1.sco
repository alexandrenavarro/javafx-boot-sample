given a sales "irmat.villet"
given a trader "samuel.raux"

when the sales send a rfq {
}

then wait scenarioStatus "NEW"
then wait scenarioStatus "BEING-PRICED"

send price {
}

then wait scenarioStatus "PRICED"
send order accepted {
}

then wait scenarioStatus "ORDER-ACCEPTED"
