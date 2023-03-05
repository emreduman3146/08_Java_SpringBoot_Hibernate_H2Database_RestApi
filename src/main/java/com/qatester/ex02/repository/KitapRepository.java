package com.qatester.ex02.repository;

import com.qatester.ex02.beans.Kitap;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KitapRepository extends JpaRepository<Kitap, Long> {
}
