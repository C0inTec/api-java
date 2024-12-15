CREATE TABLE wallets (
            id SERIAL PRIMARY KEY,
            saldo DOUBLE PRECISION DEFAULT 0 NOT NULL,
            gastos DOUBLE PRECISION DEFAULT 0 NOT NULL,
            salario DOUBLE PRECISION DEFAULT 0 NOT NULL,
            investimento DOUBLE PRECISION DEFAULT 0 NOT NULL,
            user_id BIGINT NOT NULL
);
