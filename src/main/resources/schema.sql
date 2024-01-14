DROP TABLE IF EXISTS PRICES;
DROP TABLE IF EXISTS BRANDS;

CREATE TABLE BRANDS (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(20) NOT NULL
);

CREATE TABLE PRICES (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    BRAND_ID INT NOT NULL,
    START_DATE TIMESTAMP NOT NULL,
    END_DATE TIMESTAMP NOT NULL,
    RATE INT NOT NULL,
    PRODUCT_ID VARCHAR(10) NOT NULL,
    PRIORITY INT NOT NULL,
    PRICE DOUBLE NOT NULL,
    CURRENCY VARCHAR(3) NOT NULL,
    foreign key (BRAND_ID) references BRANDS(ID)
);

CREATE INDEX idx_brand_product_start_end
ON PRICES (brand_id, product_id, start_date, end_date, priority DESC);
