INSERT INTO tb_user(email, first_name, last_name, password, user_role)
VALUES ('admin@ifpb.com', 'Admin', 'Admin', '$2a$10$YjV1XLSYQbWOuP5XAiA5pObm3mkDoRLJXt3v1Nq8XaxEAOijxShU.', 'ADMIN')
    ON CONFLICT (email) DO NOTHING;
--
--
--
-- INSERT INTO tb_user(email, first_name, last_name, password, user_role)
-- VALUES ('operator@ifpb.com', 'Operator', '01', '$2a$10$JtA4yuYEc2fBOta8p3IlaOoAqanOUy/fh5OfH.hwpHUauctBWIE3e', 'OPERATOR')
--     ON CONFLICT (email) DO NOTHING;


