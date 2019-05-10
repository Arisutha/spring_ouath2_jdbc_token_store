INSERT INTO oauth_client_details (client_id, client_secret, web_server_redirect_uri, 
	scope, access_token_validity, refresh_token_validity, resource_ids, authorized_grant_types, additional_information)
VALUES 
('mobile','{bcrypt}$2a$10$EOs8VROb14e7ZnydvXECA.4LoIhPOoFHKvVF/iBZ/ker17Eocz4Vi','http://localhost:8080/code','READ,WRITE',
'3600','10000','inventory,payment','authorization,password,refresh_token,implicit','{}');

INSERT INTO role (name) VALUES
	('ROLE_admin'),('ROLE_operator');

INSERT INTO permission (name) VALUES
('create_profile'),
('read_profile'),
('update_profile'),
('delete_profile');

INSERT INTO PERMISSION_ROLE (PERMISSION_ID, ROLE_ID) VALUES
(1,1),
(2,1),
(3,1),
(4,1),
(2,2),
(3,2);


INSERT INTO user (id, username, password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked) VALUES
('','admin','{bcrypt}$2a$10$EOs8VROb14e7ZnydvXECA.4LoIhPOoFHKvVF/iBZ/ker17Eocz4Vi','admin@test.com','1','0','0','0'),
('','user','{bcrypt}$2a$10$EOs8VROb14e7ZnydvXECA.4LoIhPOoFHKvVF/iBZ/ker17Eocz4Vi','user@test.com','1','0','0','0');


INSERT INTO ROLE_USER (ROLE_ID, USER_ID) VALUES
(1,1),
(2,2);