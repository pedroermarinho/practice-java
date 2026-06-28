CREATE TABLE Pagamento (
    id BIGINT PRIMARY KEY,
    valor DECIMAL(9, 2) NOT NULL,
    status ENUM('CRIADO', 'CONFIRMADO', 'CANCELADO') NOT NULL,
    pedidoId BIGINT NOT NULL
);

CREATE TABLE Pagamento_SEQ (
    next_val BIGINT
);
