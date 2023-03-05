package com.qatester.ex02.bootstraps;

import com.qatester.ex02.beans.Kitap;
import com.qatester.ex02.repository.KitapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class KitapBootstrap implements CommandLineRunner {
    @Autowired
    KitapRepository kitapRepository;


    @Override
    public void run(String... args) throws Exception {
        Kitap kitap1 = new Kitap();
        kitap1.setKitapAdi("Kitap1");
        kitap1.setTur("Umut");
        kitap1.setBasimTarihi(LocalDate.parse("2020-01-01"));
        kitapRepository.save(kitap1);

        kitapRepository.save(Kitap.builder().kitapAdi("Kitap2").tur("Korku").basimTarihi(LocalDate.parse("2022-01-01")).build());
        kitapRepository.save(new Kitap(0L,"Kitap3", LocalDate.parse("2019-01-01"),"Roman"));
        kitapRepository.save(new Kitap("Kitap4"));





    }
}
