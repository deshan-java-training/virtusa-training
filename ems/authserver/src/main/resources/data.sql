
INSERT INTO oauth_client_details (client_id, client_secret, web_server_redirect_uri, scope, access_token_validity, refresh_token_validity, resource_ids, authorized_grant_types, additional_information) VALUES ('admin', '{bcrypt}$2a$10$shbJaEQn/jgaGTbyUwaJ4On/bmnI0dDRkVKTC8P2nrvpePFpXiGgC', 'http://localhost:8095/login', 'READ,WRITE', '3600', '10000', 'inventory,payment', 'authorization_code,password,refresh_token,implicit', '{}');

 INSERT INTO permission (name) VALUES
 ('create_perm'),
 ('read_perm'),
 ('delete_profile');

 INSERT INTO role (name) VALUES
		('ROLE_manager'),('ROLE_operator');

 INSERT INTO permission_role (permission_id, role_id) VALUES
     (1,1), /*create-> manager */
     (2,1), /* read manager */
     (3,1), /* delete manager */
     (2,2);  /* read operator */
insert into user (id, username,password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked) VALUES ('1', 'manageremi','{bcrypt}$2a$10$HUinPTF3o7hsWgjJcNFfiO9wAswDV2dHuB.tpoaWyjTZdB9YFK2yW', 'deshandhr@gmail.com', '1', '1', '1', '1');
insert into user (id, username,password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked) VALUES ('2', 'operatoremi', '{bcrypt}$2a$10$7vv2F4dwvC9eELvWs4eoX.BolwbszomZL66Z/sTJcZP8Sg7C71XK6','deshandhr@gmail.com', '1', '1', '1', '1');

INSERT INTO role_user (role_id, user_id)
    VALUES
    (1, 1) /* manageremi-manager */,
    (2, 2) /* operatoremi-operator */ ;