import java.util.ArrayList;
import java.util.List;

public class SklepKomputerowy {
    private List<Produkt> produkty = new ArrayList<>();
    private List<Klient> klienci = new ArrayList<>();
    private List<Zamowienie> zamowienia = new ArrayList<>();
    private int liczbaProduktow = 0;
    private int liczbaKlientow = 0;
    private int liczbaZamowien = 0;

    public void dodajProdukt(Produkt produkt) {
        produkty.add(produkt);
        liczbaProduktow++;
    }

    public void dodajKlienta(Klient klient) {
        klienci.add(klient);
        liczbaKlientow++;
    }

    public void utworzZamowienie(Klient klient, Produkt[] produkty, int[] ilosci) {
        Zamowienie zamowienie = new Zamowienie(liczbaZamowien + 1, klient, produkty, ilosci, "2025-03-26", "Nowe");
        zamowienia.add(zamowienie);
        liczbaZamowien++;
        aktualizujStanMagazynowy(zamowienie);
    }

    public void aktualizujStanMagazynowy(Zamowienie zamowienie) {
        for (int i = 0; i < zamowienie.getProdukty().length; i++) {
            Produkt produkt = zamowienie.getProdukty()[i];
            produkt.setIloscWMagazynie(produkt.getIloscWMagazynie() - zamowienie.getIlosci()[i]);
        }
    }

    public void zmienStatusZamowienia(int idZamowienia, String nowyStatus) {
        for (Zamowienie zamowienie : zamowienia) {
            if (zamowienie.getId() == idZamowienia) {
                zamowienie.setStatus(nowyStatus);
                break;
            }
        }
    }

    public void wyswietlProduktyWKategorii(String kategoria) {
        for (Produkt produkt : produkty) {
            if (produkt.getKategoria().equals(kategoria)) {
                produkt.wyswietlInformacje();
            }
        }
    }

    public void wyswietlZamowieniaKlienta(int idKlienta) {
        for (Zamowienie zamowienie : zamowienia) {
            if (zamowienie.getKlient().getId() == idKlienta) {
                zamowienie.wyswietlSzczegoly();
            }
        }
    }
}

