package com.ecommerce.mspriceretriever.infrastucture.adapter.output.persistence.repository;

import com.ecommerce.mspriceretriever.infrastucture.adapter.output.persistence.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface SpringJpaH2PriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query("""
            select  p
            from PRICES p
            where p.brandId = ?1 and p.productId = ?2 and ?3 between p.startDate and p.endDate
            order by p.priority DESC
            LIMIT 1
            """)
    Optional<PriceEntity> findCurrentPriceByBrandIdAndProductId(final int brandId, final String productId, final LocalDateTime date);
}
