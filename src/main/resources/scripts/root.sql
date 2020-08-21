# net start mysql80
# mysql -u root -p

CREATE SCHEMA java_backend_demo_dev;

CREATE USER 'java_backend_demo_dev_user'@'%' IDENTIFIED BY 'secret';

GRANT INSERT, UPDATE, DELETE, SELECT ON java_backend_demo_dev.* TO 'java_backend_demo_dev_user'@'%';

CREATE SCHEMA java_backend_demo_prod;

CREATE USER 'java_backend_demo_prod_user'@'%' IDENTIFIED BY 'secret';

GRANT INSERT, UPDATE, DELETE, SELECT ON java_backend_demo_prod.* TO 'java_backend_demo_prod_user'@'%';