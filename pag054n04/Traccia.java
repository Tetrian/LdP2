class Traccia {/*
  Realizzare le classi WiFi e Network, che rappresentano un elenco di reti WiFi
  e una singola rete. La classe WiFi offre un costruttore senza argomenti e i
  seguenti metodi:
      addNetwork: memorizza e restituisce una nuova rete, caratterizzata da nome
                  (SSID) e intensità del segnale. Misurata in dBm (decibel-
                  milliwatt), l’intensità è un numero negativo ed il segnale è
                  più intenso quanto più il valore è vicino allo zero.
      strongest: restituisce la rete con l’intensità più alta (più vicina allo
                 zero).
  Inoltre, gli oggetti WiFi devono essere iterabili, dando la possibilità di
  scorrere le reti inserite, in ordine di intensità decrescente.
  La classe Network offre soltanto il metodo updateStrength, che aggiorna
  l’intensità del segnale. Fare in modo che l’unico modo per creare oggetti
  Network sia tramite il metodo addNetwork.                                   */
  public static void main(String[] argv) {
    // L’implementazione deve rispettare il seguente esempio d’uso:
    WiFi manager = new WiFi();
    WiFi.Network home = manager.addNetwork("Vodafone", -40.5);
    WiFi.Network hotel = manager.addNetwork("Hotel Vesuvio",-53.05);
    WiFi.Network neighbor = manager.addNetwork("Casa Esposito",-48.95);
    neighbor.updateStrength(-39.6);
    WiFi.Network x = manager.strongest();
    System.out.println(x);
  }
  // Output: Casa Esposito (-39.6 dBm)
}
