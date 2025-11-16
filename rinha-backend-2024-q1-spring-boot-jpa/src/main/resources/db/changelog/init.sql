--liquibase formatted sql

--changeset pedroermarinho:1

CREATE UNLOGGED TABLE transacoes (
	id SERIAL PRIMARY KEY,
	cliente_id INTEGER NOT NULL,
	valor INTEGER NOT NULL,
	tipo CHAR(1) NOT NULL,
	descricao VARCHAR(10) NOT NULL,
	realizada_em TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE UNLOGGED TABLE saldos (
	id SERIAL PRIMARY KEY,
	valor INTEGER NOT NULL DEFAULT 0,
	limite INTEGER NOT NULL
);

INSERT INTO saldos (id, limite)
	VALUES
		('1', 1000 * 100),
		('2', 800 * 100),
		('3', 10000 * 100),
		('4', 100000 * 100),
		('5', 5000 * 100);