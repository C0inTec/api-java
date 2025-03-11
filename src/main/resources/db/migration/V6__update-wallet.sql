-- Adicionar colunas apenas se elas não existirem
ALTER TABLE wallets
    ADD COLUMN IF NOT EXISTS acoes DOUBLE PRECISION DEFAULT 0 NOT NULL,
    ADD COLUMN IF NOT EXISTS fundos DOUBLE PRECISION DEFAULT 0 NOT NULL,
    ADD COLUMN IF NOT EXISTS criptomoedas DOUBLE PRECISION DEFAULT 0 NOT NULL,
    ADD COLUMN IF NOT EXISTS imoveis DOUBLE PRECISION DEFAULT 0 NOT NULL,
    ADD COLUMN IF NOT EXISTS renda_fixa DOUBLE PRECISION DEFAULT 0 NOT NULL,
    ADD COLUMN IF NOT EXISTS negocios DOUBLE PRECISION DEFAULT 0 NOT NULL,

    ADD COLUMN IF NOT EXISTS aluguel DOUBLE PRECISION DEFAULT 0 NOT NULL,
    ADD COLUMN IF NOT EXISTS contas DOUBLE PRECISION DEFAULT 0 NOT NULL,
    ADD COLUMN IF NOT EXISTS alimentacao DOUBLE PRECISION DEFAULT 0 NOT NULL,
    ADD COLUMN IF NOT EXISTS transporte DOUBLE PRECISION DEFAULT 0 NOT NULL,
    ADD COLUMN IF NOT EXISTS educacao DOUBLE PRECISION DEFAULT 0 NOT NULL,
    ADD COLUMN IF NOT EXISTS saude DOUBLE PRECISION DEFAULT 0 NOT NULL,
    ADD COLUMN IF NOT EXISTS lazer DOUBLE PRECISION DEFAULT 0 NOT NULL,

    ADD COLUMN IF NOT EXISTS salario DOUBLE PRECISION DEFAULT 0 NOT NULL,
    ADD COLUMN IF NOT EXISTS bonus DOUBLE PRECISION DEFAULT 0 NOT NULL,
    ADD COLUMN IF NOT EXISTS outros DOUBLE PRECISION DEFAULT 0 NOT NULL,
    ADD COLUMN IF NOT EXISTS rendimentos_passivos DOUBLE PRECISION DEFAULT 0 NOT NULL,
    ADD COLUMN IF NOT EXISTS freelas DOUBLE PRECISION DEFAULT 0 NOT NULL,
    ADD COLUMN IF NOT EXISTS dividendos DOUBLE PRECISION DEFAULT 0 NOT NULL;

-- Atualizar registros existentes para garantir que nenhum campo seja NULL
UPDATE wallets
SET
    acoes = COALESCE(acoes, 0),
    fundos = COALESCE(fundos, 0),
    criptomoedas = COALESCE(criptomoedas, 0),
    imoveis = COALESCE(imoveis, 0),
    renda_fixa = COALESCE(renda_fixa, 0),
    negocios = COALESCE(negocios, 0),

    aluguel = COALESCE(aluguel, 0),
    contas = COALESCE(contas, 0),
    alimentacao = COALESCE(alimentacao, 0),
    transporte = COALESCE(transporte, 0),
    educacao = COALESCE(educacao, 0),
    saude = COALESCE(saude, 0),
    lazer = COALESCE(lazer, 0),

    salario = COALESCE(salario, 0),
    bonus = COALESCE(bonus, 0),
    outros = COALESCE(outros, 0),
    rendimentos_passivos = COALESCE(rendimentos_passivos, 0),
    freelas = COALESCE(freelas, 0),
    dividendos = COALESCE(dividendos, 0);
