package com.qatester.ex02.controllers;

import com.qatester.ex02.beans.Kitap;
import com.qatester.ex02.repository.KitapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kitap")
public class KitapController {

    @Autowired
    KitapRepository kitapRepository;

    @GetMapping
    public List<Kitap> getAllKitap(){
        return kitapRepository.findAll();
    }

    @GetMapping("/{id}")
    public Kitap getKitapById(@PathVariable Long id){
        return kitapRepository.findById(id).get();
    }

    @PostMapping(consumes = "application/json")
    public List<Kitap>  addKitap(@RequestBody Kitap kitap)
    {
      kitapRepository.save(kitap);
      return kitapRepository.findAll();

    }

    @PutMapping(consumes = "application/json")
    public List<Kitap> replaceKitapList(@RequestBody List<Kitap> kitapList){
       kitapRepository.deleteAll();
       kitapRepository.saveAll(kitapList);
       return kitapRepository.findAll();
    }

    @PutMapping(value="/{id}", consumes = "application/json" )
    public List<Kitap> replaceKitap(@PathVariable Long id, @RequestBody Kitap kitap)
    {
        kitapRepository.deleteById(id);
        kitapRepository.save(kitap);
        return kitapRepository.findAll();
    }

    @PatchMapping(value="/{id}", consumes = "application/json" )
    public List<Kitap> updateKitap(@PathVariable Long id, @RequestBody Kitap yeniKitap)
    {
        Kitap aktifKitap = kitapRepository.findById(id).get();

        aktifKitap.setKitapAdi(yeniKitap.getKitapAdi());
        aktifKitap.setTur(yeniKitap.getTur());
        aktifKitap.setBasimTarihi(yeniKitap.getBasimTarihi());

        kitapRepository.save(aktifKitap);
        return kitapRepository.findAll();
    }

    @DeleteMapping(value="/{id}")
    public List<Kitap> deleteKitap(@PathVariable Long id){
        kitapRepository.deleteById(id);
        return kitapRepository.findAll();
    }

    @DeleteMapping()
    public List<Kitap> deleteAllKitaps(){
        kitapRepository.deleteAll();
        return kitapRepository.findAll();
    }






}
