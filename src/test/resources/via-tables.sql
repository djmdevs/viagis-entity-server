/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Sergio
 * Created: 28/fev/2021
 */

CREATE TABLE criterio (id INT NOT NULL, code VARCHAR(20), description VARCHAR(100), "type" VARCHAR(20), intervencao_cost DECIMAL(30, 2), transito_value INT, icp_value INT, numero_acidente INT, volume_transito_value INT, capacidade_flluxo_value DECIMAL(10, 2), co2_value DECIMAL(10, 2), social_value INT, political_value TIME, PRIMARY KEY (id));

CREATE TABLE seguimento_via (id INT NOT NULL, code VARCHAR(10), description VARCHAR(100), indice_medicao_value INT, indice_dedutivo_value INT, latitude_value DECIMAL(10, 2), longitude_value DECIMAL(10, 2), PRIMARY KEY (id));

CREATE TABLE intervencao_type (id INT NOT NULL, code VARCHAR(10), description VARCHAR(100), custo_value DECIMAL(30, 2), PRIMARY KEY (id));



