DROP TABLE IF EXISTS listing;

CREATE TABLE listing (
                              dealer_id VARCHAR(100) NOT NULL,
                              code VARCHAR(100) NOT NULL,
                              make VARCHAR(100) NOT NULL,
                              model VARCHAR(100) NOT NULL,
                              kw INT NOT NULL,
                              color VARCHAR(100) NOT NULL,
                              year INT NOT NULL,
                              price INT NOT NULL,
                              PRIMARY KEY(dealer_id, code)
);

INSERT INTO listing (dealer_id, code, make, model, kw, color, year, price) VALUES
                        ('D1', 'C1', 'VW', 'Golf', 100, 'Black', 2015, 12450),
                        ('D1', 'C2', 'VW', 'Golf', 150, 'Red', 2018, 1700),
                        ('D2', 'C2', 'VW', 'Golf', 120, 'Blue', 2017, 14300);