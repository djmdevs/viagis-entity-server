/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Sergio
 * Created: 14/mar/2021
 */

--CREATE {DATABASE | SCHEMA} [IF NOT EXISTS] db_name
    --[create_option]

--CREATE DATABASE viagis;

--CREATE TABLE intervencao_type (id INT NOT NULL, code VARCHAR(10), description VARCHAR(100), custo_value DECIMAL(30, 2), PRIMARY KEY (id));

--CREATE SCHEMA IF NOT EXISTS public;

--SET standard_conforming_strings = OFF;
--DROP TABLE IF EXISTS "vias_tbl" CASCADE;

CREATE TABLE "vias_tbl" ("ogc_fid" SERIAL, CONSTRAINT "vias_tbl_pk" PRIMARY KEY ("ogc_fid") );

select * from vias_tbl;

--delete from vias_tbl where objectid > 9

CREATE TABLE criterio (id INT NOT NULL, code VARCHAR(20), description VARCHAR(100), "type" VARCHAR(20), intervencao_cost DECIMAL(30, 2), transito_value INT, icp_value INT, numero_acidente INT, volume_transito_value INT, capacidade_flluxo_value DECIMAL(10, 2), co2_value DECIMAL(10, 2), social_value INT, political_value TIME, PRIMARY KEY (id));

--ALTER TABLE
ALTER TABLE "vias_tbl" ADD COLUMN "objectid_1" NUMERIC(10,0);
ALTER TABLE "vias_tbl" ADD COLUMN "objectid" NUMERIC(10,0);
ALTER TABLE "vias_tbl" ADD COLUMN "cod_sigem" VARCHAR(36);
ALTER TABLE "vias_tbl" ADD COLUMN "nvia" VARCHAR(11);
ALTER TABLE "vias_tbl" ADD COLUMN "tipovia" VARCHAR(50);
ALTER TABLE "vias_tbl" ADD COLUMN "toponimo" VARCHAR(150);
ALTER TABLE "vias_tbl" ADD COLUMN "distmunici" VARCHAR(50);
ALTER TABLE "vias_tbl" ADD COLUMN "senderecam" VARCHAR(1);
ALTER TABLE "vias_tbl" ADD COLUMN "hierarquia" VARCHAR(2);
ALTER TABLE "vias_tbl" ADD COLUMN "compriment" NUMERIC(19,11);
ALTER TABLE "vias_tbl" ADD COLUMN "largura_m" NUMERIC(19,11);
ALTER TABLE "vias_tbl" ADD COLUMN "obs" VARCHAR(254);
ALTER TABLE "vias_tbl" ADD COLUMN "shape_fid" NUMERIC(10,0);
ALTER TABLE "vias_tbl" ADD COLUMN "shape_leng" NUMERIC(19,11);
ALTER TABLE "vias_tbl" ADD COLUMN "shape_stle" NUMERIC(19,11);
ALTER TABLE "vias_tbl" ADD COLUMN "icp_value" NUMERIC(10,0);
ALTER TABLE "vias_tbl" ADD COLUMN "intervencao_type" VARCHAR(30);
ALTER TABLE "vias_tbl" ADD COLUMN "icp_pos_value" NUMERIC(10,0);
ALTER TABLE "vias_tbl" ADD COLUMN "volume_transito" NUMERIC(10,0);
ALTER TABLE "vias_tbl" ADD COLUMN "custo_seguimento" NUMERIC(11,3);
ALTER TABLE "vias_tbl" ADD COLUMN "criterio01_value" NUMERIC(10,0);
ALTER TABLE "vias_tbl" ADD COLUMN "prioridade01_value" NUMERIC(11,3);
ALTER TABLE "vias_tbl" ADD COLUMN "psi_value
" NUMERIC(11,3);
ALTER TABLE "vias_tbl" ADD COLUMN "criterio02_value" NUMERIC(11,3);
ALTER TABLE "vias_tbl" ADD COLUMN "priodade02_value
" NUMERIC(11,3);
ALTER TABLE "vias_tbl" ADD COLUMN "criterio03_value
" NUMERIC(11,3);
ALTER TABLE "vias_tbl" ADD COLUMN "prioridade03_value" NUMERIC(11,3);
ALTER TABLE "vias_tbl" ADD COLUMN "criterio04_value" NUMERIC(11,3);
ALTER TABLE "vias_tbl" ADD COLUMN "prioridade04_value" NUMERIC(11,3);
ALTER TABLE "vias_tbl" ADD COLUMN "criterio05_value
" NUMERIC(11,3);
ALTER TABLE "vias_tbl" ADD COLUMN "prioridade05_value" NUMERIC(11,3);
ALTER TABLE "vias_tbl" ADD COLUMN "criterio06_value" NUMERIC(11,3);
ALTER TABLE "vias_tbl" ADD COLUMN "prioridade06_value" NUMERIC(11,3);
ALTER TABLE "vias_tbl" ADD COLUMN "criterio07_value" NUMERIC(11,3);
ALTER TABLE "vias_tbl" ADD COLUMN "prioridade07_value" NUMERIC(11,3);
ALTER TABLE "vias_tbl" ADD COLUMN "prioridade08_value" NUMERIC(11,3);
ALTER TABLE "vias_tbl" ADD COLUMN "criterio09_value" NUMERIC(11,3);
ALTER TABLE "vias_tbl" ADD COLUMN "prioridade09_value" NUMERIC(11,3);
ALTER TABLE "vias_tbl" ADD COLUMN "prioridade_value" NUMERIC(11,3);
ALTER TABLE "vias_tbl" ADD COLUMN "prioridade_status" VARCHAR(50);
INSERT INTO "vias_tbl" ("objectid_1", "objectid", "cod_sigem", "nvia", "tipovia", "toponimo", "distmunici", "senderecam", "hierarquia", "compriment", "largura_m", "obs", "shape_fid", "shape_leng", "shape_stle", "icp_value", "intervencao_type", "icp_pos_value", "volume_transito", "custo_seguimento", "criterio01_value", "prioridade01_value", "psi_value
", "criterio02_value", "priodade02_value
", "criterio03_value
", "prioridade03_value", "criterio04_value", "prioridade04_value", "criterio05_value
", "prioridade05_value", "criterio06_value", "prioridade06_value", "criterio07_value", "prioridade07_value", "prioridade08_value", "criterio09_value", "prioridade09_value", "prioridade_value", "prioridade_status") VALUES (1, 1, 'EF668302-86CA-4B99-881C-4B09915CCAF2', '3.712', 'Rua', '(Rua)', 'D.M. KaMaxakeni', '3', 'T', 170.00000000000, 5.00000000000, NULL, 6595, 186.33171220000, 186.33171219900, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO "vias_tbl" ("objectid_1", "objectid", "cod_sigem", "nvia", "tipovia", "toponimo", "distmunici", "senderecam", "hierarquia", "compriment", "largura_m", "obs", "shape_fid", "shape_leng", "shape_stle", "icp_value", "intervencao_type", "icp_pos_value", "volume_transito", "custo_seguimento", "criterio01_value", "prioridade01_value", "psi_value
", "criterio02_value", "priodade02_value
", "criterio03_value
", "prioridade03_value", "criterio04_value", "prioridade04_value", "criterio05_value
", "prioridade05_value", "criterio06_value", "prioridade06_value", "criterio07_value", "prioridade07_value", "prioridade08_value", "criterio09_value", "prioridade09_value", "prioridade_value", "prioridade_status") VALUES (2, 2, 'BC906EE4-5ADF-4F06-8D48-55435B8559B4', '3.019', 'Rua', '(Rua)', 'D.M. KaMaxakeni', '1', 'T', 103.00000000000, 5.00000000000, NULL, 8385, 95.12478751000, 95.12478750880, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO "vias_tbl" ("objectid_1", "objectid", "cod_sigem", "nvia", "tipovia", "toponimo", "distmunici", "senderecam", "hierarquia", "compriment", "largura_m", "obs", "shape_fid", "shape_leng", "shape_stle", "icp_value", "intervencao_type", "icp_pos_value", "volume_transito", "custo_seguimento", "criterio01_value", "prioridade01_value", "psi_value
", "criterio02_value", "priodade02_value
", "criterio03_value
", "prioridade03_value", "criterio04_value", "prioridade04_value", "criterio05_value
", "prioridade05_value", "criterio06_value", "prioridade06_value", "criterio07_value", "prioridade07_value", "prioridade08_value", "criterio09_value", "prioridade09_value", "prioridade_value", "prioridade_status") VALUES (3, 3, 'AE417A21-AC0E-433A-8DB4-83647E24D906', '3.263', 'Rua', '(Rua)', 'D.M. KaMaxakeni', '2', 'T', 59.00000000000, 5.00000000000, NULL, 6387, 64.09990147000, 64.09990146510, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO "vias_tbl" ("objectid_1", "objectid", "cod_sigem", "nvia", "tipovia", "toponimo", "distmunici", "senderecam", "hierarquia", "compriment", "largura_m", "obs", "shape_fid", "shape_leng", "shape_stle", "icp_value", "intervencao_type", "icp_pos_value", "volume_transito", "custo_seguimento", "criterio01_value", "prioridade01_value", "psi_value
", "criterio02_value", "priodade02_value
", "criterio03_value
", "prioridade03_value", "criterio04_value", "prioridade04_value", "criterio05_value
", "prioridade05_value", "criterio06_value", "prioridade06_value", "criterio07_value", "prioridade07_value", "prioridade08_value", "criterio09_value", "prioridade09_value", "prioridade_value", "prioridade_status") VALUES (4, 4, 'C355D8B9-CC99-4147-BDE2-A91D349E08D6', '3.278', 'Rua', '(Rua)', 'D.M. KaMaxakeni', '2', 'T', 58.00000000000, 5.00000000000, NULL, 6347, 72.12121521000, 72.12121520960, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO "vias_tbl" ("objectid_1", "objectid", "cod_sigem", "nvia", "tipovia", "toponimo", "distmunici", "senderecam", "hierarquia", "compriment", "largura_m", "obs", "shape_fid", "shape_leng", "shape_stle", "icp_value", "intervencao_type", "icp_pos_value", "volume_transito", "custo_seguimento", "criterio01_value", "prioridade01_value", "psi_value
", "criterio02_value", "priodade02_value
", "criterio03_value
", "prioridade03_value", "criterio04_value", "prioridade04_value", "criterio05_value
", "prioridade05_value", "criterio06_value", "prioridade06_value", "criterio07_value", "prioridade07_value", "prioridade08_value", "criterio09_value", "prioridade09_value", "prioridade_value", "prioridade_status") VALUES (5, 5, '921024CA-5CFD-4BB8-B598-3E1F879928EB', '1.097', 'Rua', 'RobÃ¡ti Carlos (Rua)', 'D.M. KaMpfumu', '1', 'T', 117.00000000000, 6.00000000000, NULL, 5675, 147.27115270000, 147.27115270400, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO "vias_tbl" ("objectid_1", "objectid", "cod_sigem", "nvia", "tipovia", "toponimo", "distmunici", "senderecam", "hierarquia", "compriment", "largura_m", "obs", "shape_fid", "shape_leng", "shape_stle", "icp_value", "intervencao_type", "icp_pos_value", "volume_transito", "custo_seguimento", "criterio01_value", "prioridade01_value", "psi_value
", "criterio02_value", "priodade02_value
", "criterio03_value
", "prioridade03_value", "criterio04_value", "prioridade04_value", "criterio05_value
", "prioridade05_value", "criterio06_value", "prioridade06_value", "criterio07_value", "prioridade07_value", "prioridade08_value", "criterio09_value", "prioridade09_value", "prioridade_value", "prioridade_status") VALUES (6, 6, '77B13A92-FC78-4121-AED3-8E0152895BE0', '3.622', 'Rua', '(Rua)', 'D.M. KaMaxakeni', '3', 'T', 242.00000000000, 4.00000000000, NULL, 6484, 247.75264496000, 247.75264495800, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);