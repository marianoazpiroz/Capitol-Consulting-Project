CREATE TABLE TBL_PRICES (
					ID LONG AUTO_INCREMENT,
				 	BRAND_ID INTEGER DEFAULT 1 NOT NULL,
				 	START_DATE TIMESTAMP  NOT NULL,
				 	END_DATE TIMESTAMP  NOT NULL,
				 	PRICE_LIST INTEGER,
				 	PRODUCT_ID INTEGER DEFAULT 35455,
				 	PRIORITY INTEGER NOT NULL,
				 	PRICE REAL,
				 	CURR TEXT(3) 
				 )