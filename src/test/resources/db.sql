SET DATABASE SQL SYNTAX ORA TRUE;

CREATE TABLE COMPANY (
  company_id NUMBER NOT NULL,
  name VARCHAR(100) NOT NULL,
  CONSTRAINT pk_company_id PRIMARY KEY (company_id)
);

CREATE TABLE ADDRESS (
  address_id NUMBER NOT NULL,
  company_id NUMBER DEFAULT NULL,
  location VARCHAR(100) NOT NULL,
  street VARCHAR(100) NOT NULL,
  city VARCHAR(100) NOT NULL,
  postcode VARCHAR(100) NOT NULL,
  CONSTRAINT pk_address_id PRIMARY KEY (address_id),
  CONSTRAINT fk_address_id FOREIGN KEY (company_id) REFERENCES company(company_id),
);

CREATE TABLE PHASING_STRATEGY (
  phasing_strategy_id NUMBER NOT NULL,
  name VARCHAR(100) NOT NULL,
  company_id NUMBER NOT NULL,
  CONSTRAINT pk_phasing_strategy_id PRIMARY KEY (phasing_strategy_id),
  CONSTRAINT fk_company_id FOREIGN KEY (company_id) REFERENCES company(company_id),
)

CREATE TABLE PHASING_STRATEGY_CONTRIBUTIONS (
  phasing_strategy_cont_id  NUMBER NOT NULL,
  phasing_strategy_id NUMBER NOT NULL,
  effective_date DATE NOT NULL,
  ee_contribution NUMBER NOT NULL,
  er_contribution NUMBER NOT NULL,
  processed_date  DATE NOT NULL,
  CONSTRAINT pk_phasing_strategy_cont_id PRIMARY KEY (phasing_strategy_cont_id),
  CONSTRAINT fk_phasing_strategy_id FOREIGN KEY (phasing_strategy_id) REFERENCES phasing_strategy(phasing_strategy_id),
);

CREATE SEQUENCE COMPANY_ID_SEQ START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE ADDRESS_ID_SEQ START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE PHAS_STRAT_CONTRIBUTION_ID_SEQ START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE PHASING_STRATEGY_ID_SEQ START WITH 1 INCREMENT BY 1;