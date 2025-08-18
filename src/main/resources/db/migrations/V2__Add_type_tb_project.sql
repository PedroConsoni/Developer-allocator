-- V2: Migrations to add the type column to the project table

ALTER TABLE tb_project
ADD COLUMN type VARCHAR(255);

