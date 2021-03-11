CREATE TABLE tb_order
(
    id             BIGSERIAL PRIMARY KEY,
    user_id        BIGSERIAL,
    price          DOUBLE PRECISION,
    payment_method SMALLINT,
    status         SMALLINT
);
CREATE TABLE tb_order_item
(
    order_id   BIGINT,
    item_id    BIGINT,
    item_count INTEGER,
    PRIMARY KEY (order_id, item_id),
    CONSTRAINT fk_order_id FOREIGN KEY (order_id) references tb_order (id)
);