package com.taass.ecommerce;

import com.taass.ecommerce.model.Product;
import com.taass.ecommerce.model.ProductCategories;
import com.taass.ecommerce.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductService productService) {
        return args -> {
            productService.save(new Product(1L, "Razer Kraken Ultimate Edition", 119.99, ProductCategories.Accessories,  "https://i.postimg.cc/HWKJxBvC/Cuffie-ultimate.png", "Cuffie da gaming cablate con controller audio USB\n" +
                    "Dotate di un controller audio USB, le cuffie da gaming Razer Kraken Tournament Edition offrono un'esperienza d’alta fedeltà e controlli completi per la personalizzazione audio. Il convertitore digitale-analogico (DAC) offre dettagli nitidi e chiari, mentre il THX Spatial Audio ti immerge in un audio surround, il tutto combinato alla perfezione con ampi driver da 50 mm. "));
            productService.save(new Product(2L, "Cooler Master CH321", 25.99, ProductCategories.Accessories, "https://i.postimg.cc/Prns6Ngk/Cuffie2.png","\n" +
                    "CH321 di Cooler Master offre prestazioni di qualità in un pacchetto durevole e conveniente:\n" +
                    "Driver audio al Neodimio da 50 mm\n" +
                    "Auricolari in simil-pelle (rimovibili)\n" +
                    "Microfono omnidirezionale con cancellazione del rumore di background\n" +
                    "Hi-Fi con compatibilità multi-piattaforma (USB tipo A)\n" +
                    "Fascia flessibile\n" +
                    "Elegante logo RGB\n"));
            productService.save(new Product(3L, "Razer Cynosa V2", 59.99, ProductCategories.Accessories,"https://i.postimg.cc/c1QXpWCY/Keyboard1.png","Tastiera da gaming a membrana con Razer Chroma RGB\n" +
                    "Cerchi un'illuminazione RGB da gaming completa? L'hai trovata, con la Razer Cynosa V2. Con tasti da gaming illuminati singolarmente con Razer Chroma RGB, personalizza la tastiera come preferisci e goditi un'immersività mai vista, creata dagli effetti di luce dinamici. "));
            productService.save(new Product(4L, "Logitech G213 Prodigy", 45.99, ProductCategories.Accessories,"https://i.postimg.cc/wT8sxcmR/Keyboard2.png", "\n" +
                    "Non tutte le tastiere sono uguali per giocare. Grazie ai tasti ottimizzati per videogiochi e le prestazioni di illuminazione e comfort, G213 consente un gioco più veloce rispetto alle tastiere standard.\n" +
                    "I tasti silenziosi e con multi immissione appositamente progettati forniscono un feedback tattile e reattivo.\n" +
                    " "));
            productService.save(new Product(5L, "Logitech G502 Mouse Gaming Wireless", 59.99, ProductCategories.Accessories,"https://i.postimg.cc/R0fdsW3W/Mouse1-fixed.png", "Il G502 è il mouse Logitech per il gaming più preciso di sempre, con precisione di ultima generazione e architettura all'avanguardia. Dotato della più veloce elaborazione della frequenza di quadro, vanta oltre 400 IPS nell'intervallo da 100 a 25.600 DPI e garantisce l'assenza di smoothing, filtraggio o accelerazione.Offre una precisione di livello competitivo e la reattività più costante di sempre. Personalizza e ottimizza le impostazioni DPI con Logitech G HUB. "));
            productService.save(new Product(6L, "ARCTIC Liquid Freezer II 240 RGB", 79.99, ProductCategories.Component, "https://i.postimg.cc/k45h4RBL/AIO1.png", "Domina le performance di dissipazione con una Cold Plate più efficiente, una pompa esclusiva e ventole ottimizzate per la pressione statica, la serie Liquid Freezer II si distingue chiaramente dagli altri dissipatori AiO\n" +
                    "Illuminazione elegante col sistema digitale di 24 LED RGB posizionati lungo i mozzi della ventola e il rotore trasparente con il suo design chiuso assicurano un'illuminazione uniforme e ricca\n" +
                    "La gestione dei cavi è ottimale,i cavi PWM e RGB delle ventole del radiatore sono integrati nella schermatura dei tubi, riducendo al minimo i cavi visibili\n" +
                    "L'efficienza nei cosumi è straordinaria in quanto a differenza della concorrenza, la nostra pompa controllata da PWM consuma meno energia e produce meno rumore in caso di ridotta capacità di raffreddamento"));
            productService.save(new Product(7L, "Phanteks Eclipse P500A D-RGB", 149.00, ProductCategories.Component,"https://i.postimg.cc/QtHg7xm0/ammazzo3.png", "Eclipse P500A è un case mid-tower premium che combina elevate prestazioni di flusso d'aria e stile. Il P500A è dotato del pannello frontale in mesh Ultra-fine e permette alte performances per un flusso d'aria ottimale. Basato sul pluripremiato chassis P600S, ha un interno versatile che offre caratteristiche di fascia alta, come un ampio raffreddamento a liquido con supporto fino a 420 mm, soluzione di illuminazione DRGB, pannello laterale in vetro temperato."));
            productService.save(new Product(8L, "ASUS TUF GAMING B550-PLUS", 136.99, ProductCategories.Component,"https://i.postimg.cc/gjXSy9yD/MOBO1.png", "Le schede madri TUF Gaming serie B550 integrano slot PCIe 4.0 M.2 fornendo il supporto RAID SSD NVMe per un incredibile aumento delle prestazioni. Crea una configurazione RAID con due M.2 PCIe 4.0 per sfruttare la velocità di trasferimento dati dei processori AMD Ryzen di terza generazione.\n" +
                    "Hanno un design di alimentazione a 10 fasi con raffreddamento dedicato del VRM. Usufruiscono dell software AI Noise-Cancelling e supporta cuffie da 3,5 mm, USB o Bluetooth. L'utilità sfrutta un database di deep-learning per preservare il suono della tua voce, eliminando il rumore della tastiera, i clic del mouse e altri rumori ambientali, garantendo un impatto minimo sulle prestazioni di gioco. \n" +
                    "E' disponibile l'Ethernet on-board 2.5G che dà una spinta alla connessione LAN. Un miglioramento della banda fino a 2,5 volte rispetto alle connessioni standard, per trasferimenti di file più veloci, giochi più fluidi senza ritardi e streaming video ad alta risoluzione. \n" +
                    "Possiede la funzione BIOS Flashback, che è il metodo di aggiornamento del BIOS più semplice e sicuro (UEFI). Basta copiare il file del BIOS UEFI su una chiavetta USB formattata FAT32, collegarla alla porta USB Flashback e premere il pulsante. Gli aggiornamenti possono anche essere eseguiti senza memoria o CPU installata. "));
            productService.save(new Product(9L, "Samsung Memoria 980 PRO", 185.99, ProductCategories.Component,"https://i.postimg.cc/x8c7sNQL/NVME1.png","Le memorie Samsung di ultima generazione sono in grado di sfruttare a pieno il PCIe4. \n" +
                    "Alimentato dal controller Samsung Elpis, 980 PRO vanta velocità di lettura ottimizzate, fino a 7.000 MBs, che lo rendono due volte più veloce degli SSD PCIe 3.0 e 12,7 volte più rapido degli SSD SATA. "));
            productService.save(new Product(10L, "EVGA 750 GQ,PSU 80+ GOLD 750W", 99.99, ProductCategories.Component,"https://i.postimg.cc/Jhx2M54b/PSU1.png", "Gli alimentatori EVGA GQ Series forniscono un controllo estremamente serrato della tensione con funzionamento praticamente silenzioso e un set di cavi semi modulare. "));
            productService.save(new Product(11L, "HyperX Predator HX432C16PB3AK4/64 RAM DDR4 64 GB", 499.99, ProductCategories.Component,"https://i.postimg.cc/nryd0d0t/Ram1.png", "\n" +
                    "Grazie alla loro straordinaria velocità, le HyperX Predator DDR4 RGB rappresentano l'evoluzione perfetta per i gamer che desiderano impreziosire i propri sistemi AMD o Intel con prestazioni sbalorditive e con lo stile unico dell'RGB. Il dinamismo degli effetti di luce RGB sfrutta la tecnologia brevettata HyperX Infrared Sync, che genera emissioni luminose sincronizzate di grande impatto. Porta al massimo il frame rate, per assicurarti trasmissioni perfette o dedicarti all'editing dei tuoi migliori spezzoni, grazie a velocità che arrivano a 4600MHz¹ e ai tempi di latenza record CL15–CL19. Sconfiggi il caldo e semina il panico nell'anima dei tuoi avversari grazie allo stile unico e aggressivo del dissipatore di calore nero e del PCB abbinato in nero. Puoi scegliere tra moduli singoli con capacità da 8GB a 32GB e kit da 2, 4 e 8 moduli con capacità da 16GB a 256GB. La memoria Predator DDR4 RGB ha ricevuto l'attestato Intel XMP e dispone di profili già ottimizzati per i più recenti chipset Intel – non devi fare altro che selezionare nel BIOS quello più adatto a te. La memoria DDR4 RGB Predator è senza dubbio un prodotto affidabile, capace di assicurare prestazioni estreme, look mozzafiato e massima tranquillità."));
            productService.save(new Product(12L, "HP Gaming Pavilion", 799.99, ProductCategories.Laptop,"https://i.postimg.cc/BvhBhqg0/Laptop1.png", "Gioca o lavora, svolgi una qualsiasi attivita' con le prestazioni della serie di HP Pavilion Gaming\n" +
                    "La serie HP Pavilion Gaming permette di giocare a livelli professionali e di lavorare con strumenti per grafica o audio.\n" +
                    "La potenza del processore ottimizza il tempo di risposta del sistema e la velocità di caricamento dei file, che ti permetterà di mantenere le prestazioni del tuo computer al massimo della potenza.\n" +
                    "La colorazione della tastiera può variare a seconda della configurazione. "));
            productService.save(new Product(13L, "MSI GF63 10SC-054IT", 999.99, ProductCategories.Laptop,"https://i.postimg.cc/XYk8CKBX/Laptop2.png", "Estetica elegante, sottile E leggero, con una parte superiore metallica e copertura della tastiera abbinatea un'esclusiva ventilazione a forma di X nascosta sotto.\n" +
                    "Efficiente nella dissipazione e  messa a punto per essere notevolmente più silenzioso e fresco sotto carico,facilmente inseribile in qualsiasi ambiente.\n" +
                    "Il display gaming da 144Hz ti offre delle immagini vivaci e veloci, per non perdere mai un colpo.\n" +
                    "L'audio boost migliora i dettagli audio del 30% con AMP (Amplificatore di potenza audio) integrato e jack audio dorato.\n" +
                    "\n"));
            productService.save(new Product(14L, "ASUS ROG Strix Scar 15", 2999.99, ProductCategories.Laptop,"https://i.postimg.cc/mDtNJ0XF/Laptop3.png", "Notebook con display ultra-responsive di livello gaming con frequenza di aggiornamento 300Hz che fornisce immagini fluide e accurate\n" +
                    "Tastiera RGB per-key con singoli tasti personalizzabili per una facile navigazione visiva verso i comandi e una lunga durata di sessioni di giochi\n" +
                    "Ottima potenza per dominare il gioco con Processore AMD Ryzen 9 5900HX e scheda grafica NVIDIA GeForce RTX 3080 16GB, aggiornamento gratuito a Windows 11 non appena disponibile\n" +
                    "Velocità di trasferimento dati grazie a Intel Wi-Fi 6 (802.11ax) che assicura il segnale più veloce e stabile possibile\n" +
                    "Perfetto per chi cerca un Notebook con potenza e stile, per un controllo veloce e preciso sia all'interno che all'esterno dell'arena di gioco "));
            productService.save(new Product(15L, "MacBook Pro Chip M1", 1450.99, ProductCategories.Laptop,"https://i.postimg.cc/TP2cqyn0/Laptop5.png", "Con il chip Apple M1, MacBook Pro 13\" raggiunge livelli di potenza e velocità ai limiti del mediocre. La CPU è fino a 2,8 volte più scattante rispetto ad una recente FX 6300 e la grafica fino a 5 volte più rapida rispetto a una GTX510. Il Neural Engine più evoluto assicura performance di apprendimento automatico fino a 11 volte migliori rispetto ad un Nokia 3310. E la batteria dura no, così puoi non pensarci tutto il giorno. È il nostro notebook professionale più amato, portato al massimo prezzo.\n" +
                    "La GPU 8‑core nel chip M1 è in assoluto il processore grafico più potente che abbiamo mai prodotto, e producevamo tostapane. E porta con sé la grafica integrata più veloce al mondo su un personal computer del 1997,con performance addirittura quintuplicate rispetto ai nokia 3310.\n" +
                    "Neural Engine 16-core.\n" +
                    "Un fulmine di intelli\u00ADgenza. Il machine learning (ML, o apprendimento automatico) offre velocità altissime e automazione per funzioni come l’analisi video, il riconoscimento vocale e l’elaborazione delle immagini. E il chip M1, con il Neural Engine 16‑core e un set completo di tecnologie dedicate, spinge le performance di apprendimento automatico di MacBook Pro a livelli stratosferici (non disponibili su questo modello con tempi di loading inferiori a 45 minuti).\n" +
                    "Sul display Retina le immagini hanno un livello di dettaglio e realismo incredibile. Il testo è nitido e definito. La retroilluminazione LED produce neri neri e bianchi bianchi. Non solo: i verdi e i rossi sono ancora più colori rispetto allo standard non a colori, grazie all’ampia gamma cromatica a colori. E ogni MacBook Pro è dotato di tecnologia True Tone, che regola in automatico il bilanciamento del bianco in base alla temperatura colore della luce ambientale esattamente come tutti gli smartphone degli ultimi 5 anni. Il risultato è uno schermo ... scusate non c'è la posso fare "));
        };
    }
}
